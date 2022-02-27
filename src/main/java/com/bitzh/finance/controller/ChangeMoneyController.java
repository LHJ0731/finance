package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.entity.*;
import com.bitzh.finance.service.BalanceService;
import com.bitzh.finance.service.ChangeMoneyService;
import com.bitzh.finance.service.FlowOfFundsService;
import com.bitzh.finance.service.UserChangeMoneyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ChangeMoneyController {
    @Autowired
    ChangeMoneyService changeMoneyService;
    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    FlowOfFundsService flowOfFundsService;
    @Autowired
    BalanceService balanceService;

    /**
     * 跳转到零钱理财界面（用户）
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toChangeMoney.html")
    public String toChangemoney(Model model, HttpSession session) {
        List<ChangeMoney> list = changeMoneyService.selectAllChangeMoney();
        User loginUser = (User) session.getAttribute("loginUser");
        Balance balance = balanceService.selectBalanceByUserId(loginUser.getId());
        model.addAttribute("Balance", balance);
        model.addAttribute("changeMoneyList", list);
        model.addAttribute("pageTopBarInfo", "零钱理财界面");
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "changeMoneyActive");
        return "/user/finance/changemoney";
    }

    /**
     * 买入零钱理财产品
     *
     * @param changeMoneyId
     * @param userId
     * @return
     */
    @PostMapping("/user/buyChangeMoney")
    @ResponseBody
    public Msg buyChangeMoney(@RequestParam("changeMoneyId") Integer changeMoneyId,
                              @RequestParam("userId") Integer userId) {
        ChangeMoney cm = changeMoneyService.selectChangeMoneyById(changeMoneyId);
        UserChangeMoney ucm = new UserChangeMoney();
        ucm.setUserid(userId);
        ucm.setChangeid(changeMoneyId);
        ucm.setStarttime(new Date());
        ucm.setAveryield(cm.getAnnualincome());
        ucm.setProfit(cm.getAnnualincome().multiply(cm.getInvesmoney()));
        ucm.setStatus(1);
        Integer result = userChangeMoneyService.insertUserChangeMoney(ucm);
        if (result == 1) {
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(userId);
            fof.setFlowmoney(cm.getInvesmoney());
            fof.setType(1);
            fof.setSource(cm.getName());
            fof.setCreatetime(new Date());
            fof.setFunddesc("无");
            flowOfFundsService.insertFlowOfFunds(fof);
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 搜索零钱理财产品
     *
     * @param information
     * @return
     */
    @PostMapping("/user/selectChangeMoney")
    @ResponseBody
    public Msg selectChangeMoney(@RequestParam("information") String information, Model model) {
        List<ChangeMoney> list = changeMoneyService.selectChangeMoneyByInfo(information);
        model.addAttribute("changeMoneyList", list);
        return Msg.success().add("changeMoneyList", list);
    }

    /**
     * 跳转到零钱理财管理界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toChangeMoney.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<ChangeMoney> list = changeMoneyService.selectAllChangeMoney();
        PageInfo<ChangeMoney> pageInfo = new PageInfo<ChangeMoney>(list, 5);
        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "changemoneyActive");
        model.addAttribute("pageTopBarInfo", "零钱理财管理界面");
        return "/admin/finance/changemoney";
    }

    /**
     * 新增零钱理财产品
     *
     * @param changeMoney
     * @return
     */
    @PostMapping("/admin/addChangeMoney")
    @ResponseBody
    public Msg addChangeMoney(ChangeMoney changeMoney) {
        Integer result = changeMoneyService.insertChangeMoney(changeMoney);
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
    @GetMapping("/admin/getChangeMoneyInfoById/{id}")
    @ResponseBody
    public Msg getChangeMoneyInfoById(@PathVariable("id") Integer id) {
        ChangeMoney changeMoney = changeMoneyService.selectChangeMoneyById(id);
        return Msg.success().add("changeMoney", changeMoney);
    }

    /**
     * 更新
     *
     * @param id
     * @param changeMoney
     * @return
     */
    @PutMapping("/admin/updateChangeMoney/{id}")
    @ResponseBody
    public Msg updateChangeMoney(@PathVariable("id") Integer id, ChangeMoney changeMoney) {
        changeMoney.setId(id);
        Integer result = changeMoneyService.updateChangeMoney(changeMoney);
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
    @DeleteMapping("/admin/deleteChangeMoneyById/{id}")
    @ResponseBody
    public Msg deleteChangeMoneyById(@PathVariable("id") Integer id) {
        Integer result = changeMoneyService.deleteChangeMoneyById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
