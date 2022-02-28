package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.entity.*;
import com.bitzh.finance.service.BalanceService;
import com.bitzh.finance.service.FlowOfFundsService;
import com.bitzh.finance.service.TermFinancialService;
import com.bitzh.finance.service.UserTermFinancialService;
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
public class TermFinancialController {

    @Autowired
    TermFinancialService termFinancialService;
    @Autowired
    UserTermFinancialService userTermFinancialService;
    @Autowired
    FlowOfFundsService flowOfFundsService;
    @Autowired
    BalanceService balanceService;

    /**
     * 跳转到期限理财界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toTermFinancial.html")
    public String toPaymoney(Model model, HttpSession session) {
        List<TermFinancial> list = termFinancialService.selectAllTermFinancial();
        User loginUser = (User) session.getAttribute("loginUser");
        Balance balance = balanceService.selectBalanceByUserId(loginUser.getId());
        model.addAttribute("Balance", balance);
        model.addAttribute("termFinancialList", list);
        model.addAttribute("pageTopBarInfo", "期限理财界面");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "termFinancialActive");
        return "/user/finance/termfinancial";
    }

    /**
     * 购买工资理财产品
     *
     * @param termFinancialId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyTermFinancial")
    @ResponseBody
    public Msg buyTermFinancial(@RequestParam("termFinancialId") Integer termFinancialId,
                                @RequestParam("userId") Integer userId,
                                @RequestParam("leastmoney") BigDecimal leastmoney) {
        Integer consumeresult = balanceService.consume(userId, leastmoney);
        UserTermFinancial utf = new UserTermFinancial();
        utf.setUserid(userId);
        utf.setTermid(termFinancialId);
        utf.setStarttime(new Date());
        TermFinancial tf = termFinancialService.selectTermFinancialById(termFinancialId);
        utf.setAveryield(tf.getAnnualincome());
        utf.setProfit(tf.getAnnualincome().multiply(tf.getLeastmoney()));
        utf.setStatus(1);
        Integer result = userTermFinancialService.insertUserTermFinancial(utf);
        if (result == 1 && consumeresult == 1) {
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(userId);
            fof.setFlowmoney(tf.getLeastmoney());
            fof.setType(1);
            fof.setSource(tf.getName());
            fof.setCreatetime(new Date());
            fof.setFunddesc("无");
            flowOfFundsService.insertFlowOfFunds(fof);
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 搜索期限理财产品
     *
     * @param information
     * @return
     */
    @PostMapping("/user/selectTermFinancial")
    @ResponseBody
    public Msg selectTermFinancial(@RequestParam("information") String information, Model model) {
        List<TermFinancial> list = termFinancialService.selectTermFinancialByInfo(information);
        model.addAttribute("termFinancialList", list);
        return Msg.success().add("termFinancialList", list);
    }

    /**
     * 跳转到期限理财管理界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toTermFinancial.html")
    public String toTermFinancialInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                      Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<TermFinancial> list = termFinancialService.selectAllTermFinancial();
        PageInfo<TermFinancial> pageInfo = new PageInfo<TermFinancial>(list, 5);
        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "termfinancialActive");
        model.addAttribute("pageTopBarInfo", "期限理财管理界面");
        return "/admin/finance/termfinancial";
    }

    /**
     * 新增期限理财产品
     *
     * @return
     */
    @PostMapping("/admin/addTermFinancial")
    @ResponseBody
    public Msg addTermFinancial(TermFinancial termFinancial) {
        Integer result = termFinancialService.insertTermFinancial(termFinancial);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新时回显信息
     *
     * @param id
     * @return
     */
    @GetMapping("/admin/getTermFinancialInfoById/{id}")
    @ResponseBody
    public Msg getTermFinancialInfoById(@PathVariable("id") Integer id) {
        TermFinancial termFinancial = termFinancialService.selectTermFinancialById(id);
        return Msg.success().add("termFinancial", termFinancial);
    }

    /**
     * 更新
     *
     * @param id
     * @return
     */
    @PutMapping("/admin/updateTermFinancial/{id}")
    @ResponseBody
    public Msg updateTermFinancial(@PathVariable("id") Integer id, TermFinancial termFinancial) {
        termFinancial.setId(id);
        Integer result = termFinancialService.updateTermFinancial(termFinancial);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admin/deleteTermFinancialById/{id}")
    @ResponseBody
    public Msg deleteTermFinancialById(@PathVariable("id") Integer id) {
        Integer result = termFinancialService.deleteTermFinancialById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
