package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.Admin;
import com.bitzh.finance.entity.Balance;
import com.bitzh.finance.entity.User;
import com.bitzh.finance.service.AdminService;
import com.bitzh.finance.service.BalanceService;
import com.bitzh.finance.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    BalanceService balanceService;

    //public static final Map<String, HttpSession> USR_SESSION = new HashMap<>();
    public static String last_login = "";

    @GetMapping("/loginVerifyUsername/{username}")
    @ResponseBody
    public Msg loginVerifyUsername(@PathVariable("username") String username) {
        User user = userService.selectUserByTerms(username, null);
        if (user != null) {
            return Msg.success();
        }
        Admin admin = adminService.selectAdminByTerms(username, null);
        if (admin != null) {
            return Msg.success();
        }
        return Msg.fail();
    }

    @GetMapping("/verifyLogin")
    @ResponseBody
    @OperLog(operModul = "登录模块", operType = "登录", operDesc = "验证登录")
    public Msg verifyLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                           HttpSession session) {

        User loginUser = userService.selectUserByTerms(username, password);
        if (loginUser != null) {
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户登录数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                return Msg.success().add("url", "/user/index.html");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                return Msg.fail();
            }
        }

        Admin admin = adminService.selectAdminByTerms(username, password);
        if (admin != null) {
            //获取当前用户
            Subject subject = SecurityUtils.getSubject();
            //封装用户登录数据
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                subject.login(token);
                return Msg.success().add("url", "/admin/index.html");
            } catch (UnknownAccountException | IncorrectCredentialsException e) {
                //model.addAttribute("msg","密码错误");
                return Msg.fail();
            }
        }
        return Msg.fail();
    }

    @PostMapping("/register")
    @ResponseBody
    public Msg register(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(0);
        user.setReputation("良好");
        userService.insertUser(user);
        Balance balance = new Balance();
        balance.setUserid(userService.selectUserByUsername(username).getId());
        balance.setBalance(BigDecimal.valueOf(0));
        balanceService.insertBalance(balance);
        return Msg.success().add("url", "/");
    }


}
