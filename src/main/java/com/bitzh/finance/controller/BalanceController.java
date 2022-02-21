package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.entity.Balance;
import com.bitzh.finance.entity.FlowOfFunds;
import com.bitzh.finance.entity.User;
import com.bitzh.finance.service.BalanceService;
import com.bitzh.finance.service.FlowOfFundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class BalanceController {

    @Autowired
    BalanceService balanceService;
    @Autowired
    FlowOfFundsService flowOfFundsService;

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
     * @param amount
     * @param userId
     * @return
     */
    @PostMapping("/user/addByBankCard")
    @ResponseBody
    public Msg addByBankCard(@RequestParam("amout") BigDecimal amount,
                             @RequestParam("userId") Integer userId,@RequestParam("bankcardText") String bankcardText) {
        Integer result = balanceService.addByBankCard(amount, userId);
        if (result == 1) {
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(userId);
            fof.setFlowmoney(amount);
            fof.setType(2);
            fof.setSource("充值");
            fof.setCreatetime(new Date());
            fof.setFunddesc(bankcardText+"充值");
            flowOfFundsService.insertFlowOfFunds(fof);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}
