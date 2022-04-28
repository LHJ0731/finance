package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.*;
import com.bitzh.finance.service.*;
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
public class LoanController {
    @Autowired
    LoanService loanService;
    @Autowired
    InfoService infoService;
    @Autowired
    BalanceService balanceService;
    @Autowired
    FlowOfFundsService flowOfFundsService;
    @Autowired
    UserService userService;

    /**
     * 跳转到网贷申请界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/tools/toApplyLoan.html")
    public String toApplyLoan(Model model) {

        model.addAttribute("pageTopBarInfo", "申请借款界面");
        model.addAttribute("activeUrl1", "toolsActive");
        model.addAttribute("activeUrl2", "applyLoanActive");
        return "/user/tools/applyloan";
    }

    /**
     * 跳转到我的借款界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/personal/toMyLoan.html")
    public String toMyLoan(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                           Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");

        PageHelper.startPage(pageNum, pageSize);
        List<Loan> list = loanService.selectLoanByLoanId(loginUser.getId());
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(list, 5);
        model.addAttribute("myLoansPageInfo", pageInfo);
        model.addAttribute("loansList", list);

        model.addAttribute("pageTopBarInfo", "我的借款界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "myLoanActive");
        return "/user/personal/myloan";
    }

    /**
     * 新增借款申请
     *
     * @param amout
     * @param term
     * @param rate
     * @param session
     * @return
     */
    @PostMapping("/user/applyLoan")
    @ResponseBody
    @OperLog(operModul = "借款模块", operType = "新增", operDesc = "新增借款申请")
    public Msg applyLoan(@RequestParam("amout") BigDecimal amout,
                         @RequestParam("term") Integer term,
                         @RequestParam("rate") BigDecimal rate, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");

        Loan loan = new Loan();
        loan.setLoanid(loginUser.getId());
        loan.setLoantime(new Date());
        loan.setAmount(amout);
        loan.setTerm(term);
        loan.setRate(rate);
        loan.setApplystatus(0);
        loan.setLoanstatus(0);
        Integer result = loanService.insertLoan(loan);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 还款
     *
     * @param id
     * @return
     */
    @PutMapping("/user/repayment/{id}")
    @ResponseBody
    @OperLog(operModul = "借款模块", operType = "更新", operDesc = "还款,进行更新借款信息")
    public Msg repayment(@PathVariable("id") Integer id) {
        Loan loan = loanService.selectLoanById(id);
        loan.setLoanstatus(2);
        Integer result = loanService.updateLoan(loan);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到借款审核（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/loan/toLoanexam.html")
    public String toLoanexam(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<Loan> list = loanService.selectAllLoanByApplyStatusAsc();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(list, 5);
        model.addAttribute("loanPageInfo", pageInfo);
        model.addAttribute("loanList", list);

        model.addAttribute("activeUrl1", "loanActive");
        model.addAttribute("activeUrl2", "loanexamActive");
        model.addAttribute("pageTopBarInfo", "借款审核界面");
        return "admin/loan/loanexam";
    }

    /**
     * 借款审核通过
     *
     * @param id
     * @return
     */
    @PutMapping("/loan/passApplyStatus")
    @ResponseBody
    @OperLog(operModul = "借款模块", operType = "更新", operDesc = "借款审核通过")
    public Msg passApplyStatus(@RequestParam("id") Integer id, @RequestParam("amount") BigDecimal amount, @RequestParam("username") String username, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        Loan loan = loanService.selectLoanById(id);
        loan.setExamineid(admin.getId());
        loan.setApplystatus(2);
        Integer result = loanService.updateLoan(loan);
        User user = userService.selectUserByUsername(username);
        Integer incomeresult = balanceService.income(user.getId(), amount);
        if (result == 1 && incomeresult == 1) {
            Info info = new Info();
            info.setSendid(admin.getId());
            info.setReceiveid(loan.getLoanid());
            info.setCreatetime(new Date());
            info.setTitle("借款审核通过");
            info.setInfodesc("用户" + loan.getUser().getUsername() + "的" + loan.getAmount() + "元借款申请审核通过！审核人为：" + admin.getUsername());
            info.setStatus(0);
            Integer insertInfoResult = infoService.insertInfo(info);
            FlowOfFunds fof = new FlowOfFunds();
            fof.setUserid(user.getId());
            fof.setFlowmoney(amount);
            fof.setType(2);
            fof.setSource("借款申请");
            fof.setCreatetime(new Date());
            fof.setFunddesc("借款申请通过");
            Integer insertFlowOfFundsResult = flowOfFundsService.insertFlowOfFunds(fof);
            if (insertInfoResult == 1 && insertFlowOfFundsResult == 1) {
                return Msg.success();
            }
        }
        return Msg.fail();
    }

    /**
     * 借款审核不通过
     *
     * @param id
     * @return
     */
    @PutMapping("/loan/notPassApplyStatus/{id}")
    @ResponseBody
    @OperLog(operModul = "借款模块", operType = "更新", operDesc = "借款审核不通过")
    public Msg notPassApplyStatus(@PathVariable("id") Integer id, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        Loan loan = loanService.selectLoanById(id);
        loan.setExamineid(admin.getId());
        loan.setApplystatus(1);
        Integer result = loanService.updateLoan(loan);
        if (result == 1) {
            Info info = new Info();
            info.setSendid(admin.getId());
            info.setReceiveid(loan.getUser().getId());
            info.setCreatetime(new Date());
            info.setTitle("借款审核未通过");
            info.setInfodesc("用户" + loan.getUser().getUsername() + "的" + loan.getAmount() + "元借款申请审核未通过！审核人为：" + admin.getUsername());
            info.setStatus(0);
            infoService.insertInfo(info);
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到借款信息界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/loan/toLoaninfo.html")
    public String toLoaninfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<Loan> list = loanService.selectAllExamedLoan();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(list, 5);
        model.addAttribute("loanPageInfo", pageInfo);
        model.addAttribute("loanList", list);

        model.addAttribute("activeUrl1", "loanActive");
        model.addAttribute("activeUrl2", "loaninfoActive");
        model.addAttribute("pageTopBarInfo", "借款信息界面");
        return "admin/loan/loaninfo";
    }

    /**
     * 提醒用户还款（管理员）
     *
     * @param id
     * @param session
     * @return
     */
    @PutMapping("/loan/remindPay/{id}")
    @ResponseBody
    @OperLog(operModul = "借款模块", operType = "新增", operDesc = "提醒用户还款（管理员）")
    public Msg remindPay(@PathVariable("id") Integer id, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        Loan loan = loanService.selectLoanById(id);
        Info info = new Info();
        info.setSendid(admin.getId());
        info.setReceiveid(loan.getUser().getId());
        info.setCreatetime(new Date());
        info.setTitle("还款通知");
        info.setInfodesc("用户" + loan.getUser().getUsername() + "申请的" + loan.getAmount() + "元借款该还款了！该提醒发送人为：" + admin.getUsername());
        info.setStatus(0);
        Integer result = infoService.insertInfo(info);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }
}
