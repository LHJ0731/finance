package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.Bank;
import com.bitzh.finance.service.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BankController {
    @Autowired
    BankService bankService;

    /**
     * 跳转用户银行推荐界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/finance/toBank.html")
    public String toBank(Model model) {
        List<Bank> list = bankService.selectAllBank();
        model.addAttribute("bankList", list);
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "bankActive");
        model.addAttribute("pageTopBarInfo", "银行推荐界面");
        return "user/finance/bank";
    }

    /**
     * 跳转到推荐银行管理界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/finance/toBank.html")
    public String toBank(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                         Model model, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bank> list = bankService.selectAllBank();
        PageInfo<Bank> pageInfo = new PageInfo<Bank>(list, 5);
        model.addAttribute("finacnePageInfo", pageInfo);
        model.addAttribute("financeList", list);
        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "bankActive");
        model.addAttribute("pageTopBarInfo", "银行推荐页面");
        return "/admin/finance/bank";
    }

    /**
     * 新增推荐银行(管理员)
     *
     * @param bank
     * @return
     */
    @PostMapping("/admin/addBank")
    @ResponseBody
    @OperLog(operModul = "银行模块", operType = "新增", operDesc = "新增推荐银行(管理员)")
    public Msg addBank(Bank bank) {
        Integer result = bankService.insertBank(bank);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 查询指定银行信息，用于回显银行信息
     *
     * @param id
     * @return
     */
    @GetMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    @OperLog(operModul = "银行模块", operType = "查询", operDesc = "查询指定银行信息，用于回显银行信息")
    public Msg getBankInfoById(@PathVariable("id") Integer id) {
        Bank bank = bankService.selectBankById(id);
        return Msg.success().add("bank", bank);
    }

    /**
     * 更新银行信息
     *
     * @param id
     * @return
     */
    @PutMapping("/admin/updateBank/{id}")
    @ResponseBody
    @OperLog(operModul = "银行模块", operType = "更新", operDesc = "更新银行信息")
    public Msg updateBank(@PathVariable("id") Integer id, Bank bank) {
        bank.setId(id);
        Integer result = bankService.updateBank(bank);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除银行
     *
     * @param id
     * @return
     */
    @DeleteMapping("/admin/deleteBankById/{id}")
    @ResponseBody
    @OperLog(operModul = "银行模块", operType = "删除", operDesc = "删除银行")
    public Msg deleteBankById(@PathVariable("id") Integer id) {
        Integer result = bankService.deleteBankById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
