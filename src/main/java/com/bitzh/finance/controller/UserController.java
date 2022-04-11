package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.User;
import com.bitzh.finance.service.UserService;
import com.bitzh.finance.utils.UploadUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 跳转到账户安全界面（用户）(修改密码)
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/personal/toSecurity.html")
    public String toSecurity(Model model) {
        model.addAttribute("pageTopBarInfo", "账户安全界面");
        model.addAttribute("activeUrl1", "personalActive");
        model.addAttribute("activeUrl2", "securityActive");
        return "/user/personal/security";
    }

    /**
     * 跳转到个人信息界面（用户）
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/user/personal/toProfile.html")
    public String toProfile(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        User user = userService.selectUserById(loginUser.getId());
        model.addAttribute("user", user);

        model.addAttribute("pageTopBarInfo", "个人信息界面");
        return "/user/personal/profile";
    }

    /**
     * 判断并更新密码（用户）
     *
     * @param request
     * @return
     */
    @PutMapping("/user/updatePwd")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "更新", operDesc = "判断并更新密码（用户）")
    public Msg updatePwd(HttpServletRequest request, HttpSession session) {

        String id = request.getParameter("id");
        User user = userService.selectUserById(Integer.valueOf(id));
        String oldpwd = request.getParameter("oldpwd");
        String newpwd = request.getParameter("newpwd");
        User verifyExistUser = userService.selectUserByTerms(user.getUsername(), oldpwd);
        if (verifyExistUser != null) {
            user.setPassword(newpwd);

            // 当前登录用户信息改变时session里面存储的用户信息也应该同时改变
            User loginUser = (User) session.getAttribute("loginUser");
            if (Integer.valueOf(id) == (loginUser.getId())) {
                session.setAttribute("loginUser", user);
            }
            userService.updateUser(user);
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新用户信息
     *
     * @param id
     * @param user
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserProfile/{userId}")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "更新", operDesc = "更新用户信息")
    public Msg updateUserProfile(@PathVariable("userId") Integer id, User user, HttpSession session) {
        user.setId(id);
        Integer result = userService.updateUser(user);
        if (result == 1) {
            // 当前登录用户信息改变时session里面存储的用户信息也应该同时改变
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser != null) {
                if (id == (loginUser.getId())) {
                    session.setAttribute("loginUser", userService.selectUserById(id));
                }
            }
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 用户强制下线（管理员更改用户信息）
     *
     * @param id
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserStatus/{id}")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "更新", operDesc = "用户强制下线（管理员更改用户信息）")
    public Msg updateUserStatus(@PathVariable("id") Integer id, HttpSession session) {
        User user = userService.selectUserById(id);
        user.setStatus(0);
        Integer result = userService.updateUser(user);
        if (result == 1) {
            // 当前登录用户强制下线
            session.removeAttribute("loginUser");
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到用户信息界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toUserInfo.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAllUser();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
        model.addAttribute("userPageInfo", pageInfo);
        model.addAttribute("userList", list);

        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "userInfoActive");
        model.addAttribute("pageTopBarInfo", "用户信息界面");
        return "/admin/userinfo/userinfo";
    }

    /**
     * 添加用户（管理员）
     *
     * @param user
     * @return
     */
    @PostMapping("/user/addUser")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "新增", operDesc = "添加用户（管理员）")
    public Msg addUser(User user) {
        user.setStatus(0);
        user.setReputation("良好");
        Integer result = userService.insertUser(user);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 更新用户信息时回显用户信息（管理员）
     *
     * @param id
     * @return
     */
    @GetMapping("/user/getUserById/{id}")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "查询", operDesc = "更新用户信息时回显用户信息（管理员）")
    public Msg getUserInfoById(@PathVariable("id") Integer id) {
        User user = userService.selectUserById(id);
        return Msg.success().add("user", user);
    }

    /**
     * 删除用户（管理员）
     *
     * @param id
     * @param session
     * @return
     */
    @DeleteMapping("/user/deleteUserById/{id}")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "删除", operDesc = "删除用户（管理员）")
    public Msg deleteUserById(@PathVariable("id") Integer id, HttpSession session) {
        Integer result = userService.deleteUserById(id);
        if (result == 1) {
            // 删除用户时应先判断这个用户是否在线
            User loginUser = (User) session.getAttribute("loginUser");
            if (loginUser != null) {
                if (id == (loginUser.getId())) {
                    session.removeAttribute("loginUser");
                }
            }
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 跳转到用户信誉管理界面（管理员）
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/userinfo/toReputation.html")
    public String toUserReputation(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                   Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userService.selectAllUser();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<User> pageInfo = new PageInfo<User>(list, 5);
        model.addAttribute("userPageInfo", pageInfo);
        model.addAttribute("userList", list);

        model.addAttribute("activeUrl1", "userInfoActive");
        model.addAttribute("activeUrl2", "reputationActive");
        model.addAttribute("pageTopBarInfo", "用户信誉界面");
        return "/admin/userinfo/reputation";
    }

    /**
     * 更新用户头像
     *
     * @param headimgFile
     * @param username
     * @param request
     * @param session
     * @return
     */
    @PutMapping("/user/updateUserheadimg/{username}")
    @ResponseBody
    @OperLog(operModul = "用户模块", operType = "更新", operDesc = "更新用户头像")
    public Msg upload(@RequestParam("file") MultipartFile headimgFile, @PathVariable("username") String username, HttpServletRequest request, HttpSession session) {
        if (!headimgFile.isEmpty() && headimgFile.getSize() > 0) {
            // 拿到文件名
            String filename = headimgFile.getOriginalFilename();
            // 存放上传图片的文件夹
            File fileDir = UploadUtils.getImgDirFile();
            // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
            System.out.println(fileDir.getAbsolutePath());
            //文件改名
            String filetype = filename.substring(filename.indexOf(".") + 1);
            System.out.println(filetype);
            String filehouzui = "." + filetype;
            String newFilename = username + filehouzui;
            File file = new File(fileDir.getAbsolutePath() + File.pathSeparator + newFilename);
            if (file.exists() && file.isFile()) {
                System.out.println("该用户原头像文件存在，即将删除文件");
                file.delete();
                System.out.println("删除该原用户原头像文件成功");
            }
            try {
                // 构建真实的文件路径
                File newFile = new File(fileDir.getAbsolutePath() + File.separator + newFilename);
                System.out.println(newFile.getAbsolutePath());
                // 上传图片到 -》 “绝对路径”
                headimgFile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}