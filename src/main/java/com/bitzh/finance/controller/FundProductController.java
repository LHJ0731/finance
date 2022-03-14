package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.*;
import com.bitzh.finance.service.BalanceService;
import com.bitzh.finance.service.FlowOfFundsService;
import com.bitzh.finance.service.FundProductService;
import com.bitzh.finance.service.UserFundProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class FundProductController {
    @Autowired
    FundProductService fundProductService;
    @Autowired
    UserFundProductService userFundProductService;
    @Autowired
    FlowOfFundsService flowOfFundsService;
    @Autowired
    BalanceService balanceService;

    /**
     * 跳转到基金理财界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toFundProduct.html")
    public String toFundProduct(Model model, HttpSession session) {
        List<FundProduct> list = fundProductService.selectAllFundProduct();
        User loginUser = (User) session.getAttribute("loginUser");
        Balance balance = balanceService.selectBalanceByUserId(loginUser.getId());
        model.addAttribute("Balance", balance);
        model.addAttribute("fundProductList", list);
        model.addAttribute("pageTopBarInfo", "基金理财界面");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "fundProductActive");
        return "/user/finance/fundproduct";
    }

    /**
     * 买入基金理财产品
     *
     * @param fundProductId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyFundProduct")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "新增", operDesc = "买入基金理财产品")
    public Msg buyFundProduct(@RequestParam("fundProductId") Integer fundProductId,
                              @RequestParam("userId") Integer userId,
                              @RequestParam("leastmoney") BigDecimal leastmoney) {
        Integer consumeresult = balanceService.consume(userId, leastmoney);
        UserFundProduct ufp = new UserFundProduct();
        ufp.setUserid(userId);
        ufp.setFundid(fundProductId);
        ufp.setStarttime(new Date());
        FundProduct fp = fundProductService.selectFundProductById(fundProductId);
        ufp.setAveryield(fp.getMonthlygrowth());
        ufp.setProfit(fp.getLeastmoney().multiply(fp.getMonthlygrowth()));
        ufp.setStatus(1);
        Integer result = userFundProductService.insertUserFundProduct(ufp);
        if (result == 1 && consumeresult == 1) {
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(userId);
            fof.setFlowmoney(fp.getLeastmoney());
            fof.setType(1);
            fof.setSource(fp.getFunddesc());
            fof.setCreatetime(new Date());
            fof.setFunddesc("无");
            flowOfFundsService.insertFlowOfFunds(fof);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 搜索基金理财产品
     *
     * @param information
     * @return
     */
    @PostMapping("/user/selectFundProduct")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "查询", operDesc = "搜索基金理财产品")
    public Msg selectFundProduct(@RequestParam("information") String information, Model model) {
        List<FundProduct> list = fundProductService.selectFundProductByInfo(information);
        model.addAttribute("fundProductList", list);
        return Msg.success().add("fundProductList", list);
    }

    /**
     * 跳转到基金理财管理界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toFundProduct.html")
    public String toFundProduct(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<FundProduct> list = fundProductService.selectAllFundProduct();
        PageInfo<FundProduct> pageInfo = new PageInfo<FundProduct>(list, 5);
        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "fundproductActive");
        model.addAttribute("pageTopBarInfo", "基金理财管理界面");
        return "/admin/finance/fundproduct";
    }

    /**
     * 新增基金理财产品(管理员)
     *
     * @return
     */
    @PostMapping("/admin/addFundProduct")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "新增", operDesc = "新增基金理财产品(管理员)")
    public Msg addFundProduct(FundProduct fundProduct) {
        Integer result = fundProductService.insertFundProduct(fundProduct);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 查询指定基金理财产品信息，用于更新时回显信息
     *
     * @param id
     * @return
     */
    @GetMapping("/admin/getFundProductInfoById/{id}")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "查询", operDesc = "查询指定基金理财产品信息，用于更新时回显信息")
    public Msg getFundProductInfoById(@PathVariable("id") Integer id) {
        FundProduct fundProduct = fundProductService.selectFundProductById(id);
        //System.out.println(fundProduct.getFunddesc());
        return Msg.success().add("fundProduct", fundProduct);
    }

    /**
     * 更新基金理财产品信息
     *
     * @param id
     * @return
     */
    @PutMapping("/admin/updateFundProduct/{id}")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "更新", operDesc = "更新基金理财产品信息")
    public Msg updateFundProduct(@PathVariable("id") Integer id, FundProduct fundProduct) {
        fundProduct.setId(id);
        Integer result = fundProductService.updateFundProduct(fundProduct);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除基金理财产品信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admin/deleteFundProductById/{id}")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "删除", operDesc = "删除基金理财产品信息")
    public Msg deleteFundProductById(@PathVariable("id") Integer id) {
        Integer result = fundProductService.deleteFundProductById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
