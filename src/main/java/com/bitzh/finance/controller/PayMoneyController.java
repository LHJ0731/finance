package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.*;
import com.bitzh.finance.service.BalanceService;
import com.bitzh.finance.service.FlowOfFundsService;
import com.bitzh.finance.service.PayMoneyService;
import com.bitzh.finance.service.UserPayMoneyService;
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
public class PayMoneyController {

    @Autowired
    PayMoneyService payMoneyService;
    @Autowired
    UserPayMoneyService userPayMoneyService;
    @Autowired
    FlowOfFundsService flowOfFundsService;
    @Autowired
    BalanceService balanceService;

    /**
     * 跳转到工资理财界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toPayMoney.html")
    public String toPaymoney(Model model, HttpSession session) {
        List<PayMoney> list = payMoneyService.selectAllPayMoney();
        User loginUser = (User) session.getAttribute("loginUser");
        Balance balance = balanceService.selectBalanceByUserId(loginUser.getId());
        model.addAttribute("Balance", balance);
        model.addAttribute("payMoneyList", list);
        model.addAttribute("pageTopBarInfo", "工资理财界面");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "payMoneyActive");
        return "/user/finance/paymoney";
    }

    /**
     * 买入工资理财产品
     *
     * @param payMoneyId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyPayMoney")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "新增", operDesc = "买入工资理财产品")
    public Msg buyPayMoney(@RequestParam("payMoneyId") Integer payMoneyId,
                           @RequestParam("userId") Integer userId,
                           @RequestParam("monthmoney") BigDecimal monthmoney) {
        Integer consumeresult = balanceService.consume(userId, monthmoney);
        PayMoney pm = payMoneyService.selectPayMoneyById(payMoneyId);
        UserPayMoney upm = new UserPayMoney();
        upm.setUserid(userId);
        upm.setPayid(payMoneyId);
        upm.setStarttime(new Date());
        upm.setAveryield(new BigDecimal("0.03123"));
        upm.setProfit(new BigDecimal("0.03123").multiply(pm.getMonthmoney()));
        upm.setStatus(1);
        Integer result = userPayMoneyService.insertUserPayMoney(upm);
        if (result == 1 && consumeresult == 1) {
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(userId);
            fof.setFlowmoney(pm.getMonthmoney());
            fof.setType(1);
            fof.setSource("工资理财");
            fof.setCreatetime(new Date());
            if (pm.getType() == 1) {
                fof.setFunddesc("国债");
            } else if (pm.getType() == 2) {
                fof.setFunddesc("期货");
            }
            flowOfFundsService.insertFlowOfFunds(fof);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 搜索工资理财产品
     *
     * @param information
     * @return
     */
    @PostMapping("/user/selectPayMoney")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "查询", operDesc = "搜索工资理财产品")
    public Msg selectChangeMoney(@RequestParam("information") String information, Model model) {
        List<PayMoney> list = payMoneyService.selectPayMoneyByInfo(information);
        model.addAttribute("payMoneyList", list);
        return Msg.success().add("payMoneyList", list);
    }

    /**
     * 跳转到工资理财管理界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toPayMoney.html")
    public String toPayMoneyInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<PayMoney> list = payMoneyService.selectAllPayMoney();
        PageInfo<PayMoney> pageInfo = new PageInfo<PayMoney>(list, 5);
        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "paymoneyActive");
        model.addAttribute("pageTopBarInfo", "工资理财管理界面");
        return "/admin/finance/paymoney";
    }

    /**
     * 新增工资理财产品(管理员)
     *
     * @param payMoney
     * @return
     */
    @PostMapping("/admin/addPayMoney")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "新增", operDesc = "新增工资理财产品(管理员)")
    public Msg addPayMoney(PayMoney payMoney) {
        Integer result = payMoneyService.insertPayMoney(payMoney);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 查询指定工资理财产品信息，用于更新时回显信息
     *
     * @param id
     * @return
     */
    @GetMapping("/admin/getPayMoneyInfoById/{id}")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "查询", operDesc = "查询指定工资理财产品信息，用于更新时回显信息")
    public Msg getPayMoneyInfoById(@PathVariable("id") Integer id) {
        PayMoney payMoney = payMoneyService.selectPayMoneyById(id);
        return Msg.success().add("payMoney", payMoney);
    }

    /**
     * 更新工资理财产品信息
     *
     * @param id
     * @param payMoney
     * @return
     */
    @PutMapping("/admin/updatePayMoney/{id}")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "更新", operDesc = "更新工资理财产品信息")
    public Msg updatePayMoney(@PathVariable("id") Integer id, PayMoney payMoney) {
        payMoney.setId(id);
        Integer result = payMoneyService.updatePayMoney(payMoney);
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
    @DeleteMapping("/admin/deletePayMoneyById/{id}")
    @ResponseBody
    @OperLog(operModul = "产品模块", operType = "删除", operDesc = "删除基工资理财产品信息")
    public Msg deletePayMoneyById(@PathVariable("id") Integer id) {
        Integer result = payMoneyService.deletePayMoneyById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
