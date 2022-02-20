package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.entity.Balance;
import com.bitzh.finance.entity.User;
import com.bitzh.finance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class BalanceController {

    @Autowired
    BalanceService balanceService;

    /**
     * 跳转到账户余额界面（用户）
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/user/personal/toBalance.html")
    public String toBalance(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        Balance balance = balanceService.selectBalanceByUserId(loginUser.getId());
        model.addAttribute("Balance", balance);

        model.addAttribute("pageTopBarInfo", "账户余额界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "balanceActive");
        return "/user/personal/balance";
    }

    /**
     * 用户通过银行卡增加余额
     *
     * @param userId
     * @param rechargeamount
     * @return
     */
    @PostMapping("/user/addByBankCard")
    @ResponseBody
    public Msg addByBankCard(@RequestParam("amout") BigDecimal amout) {
        User loginUser = (User) session.getAttribute("loginUser");

        Balance balance = new Balance();
        balance.setUserid(loginUser.getId());
        balance.setBalance(amout);
        Integer result = balanceService.addByBankCard(balance);
        if (result==1){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }
}
