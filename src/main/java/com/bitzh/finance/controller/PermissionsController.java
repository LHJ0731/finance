package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.AdminPermissions;
import com.bitzh.finance.entity.UserPermissions;
import com.bitzh.finance.service.AdminPermissionsService;
import com.bitzh.finance.service.PermissionsService;
import com.bitzh.finance.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PermissionsController {
    @Autowired
    UserPermissionsService userPermissionsService;
    @Autowired
    PermissionsService permissionsService;
    @Autowired
    AdminPermissionsService adminPermissionsService;

    /**
     * 跳转到用户权限管理界面（管理员）
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/admin/permission/toUserPermissions.html")
    public String toUserPermission(Model model, HttpSession session) {
        List<UserPermissions> list = userPermissionsService.selectUserPermissionsByUserId(1);
        ArrayList<String> list2 = new ArrayList<>();
        for (UserPermissions userPermissions : list) {
            list2.add(userPermissions.getPermissions().getPermission());
        }
        model.addAttribute("permissionsList", list2);
        //session.setAttribute("permissionsList",list);

        model.addAttribute("activeUrl1", "permissionActive");
        model.addAttribute("activeUrl2", "userPermissionsActive");
        model.addAttribute("pageTopBarInfo", "用户权限管理界面");
        return "/admin/permission/userpermissions";
    }

    /**
     * 更新用户权限
     *
     * @param userPermissions
     * @return
     */
    @PutMapping("/admin/updateUserPermissions")
    @ResponseBody
    @OperLog(operModul = "权限模块", operType = "更新", operDesc = "更新用户权限")
    public Msg updateUserPermissions(@RequestParam("userPermissions") String userPermissions) {
        String[] strings = userPermissions.split(";");
        //System.out.println(strings.length+":"+ Arrays.toString(strings));
        userPermissionsService.deleteAllUserPermissionsByUserId(1);
        for (String string : strings) {
            UserPermissions up = new UserPermissions();
            up.setUserid(1);
            up.setPermissionid(permissionsService.selectPermissionsByPermission(string).get(0).getId());
            userPermissionsService.insertUserPermissions(up);
        }
        return Msg.success();
    }

    @GetMapping("/admin/permission/toAdminPermissions.html")
    public String toAdminPermission(Model model, HttpSession session) {
        List<AdminPermissions> list = adminPermissionsService.selectAdminPermissionsByAdminId(1);
        ArrayList<String> list2 = new ArrayList<>();
        for (AdminPermissions adminPermissions : list) {
            list2.add(adminPermissions.getPermissions().getPermission());
        }
        model.addAttribute("permissionsList", list2);


        model.addAttribute("activeUrl1", "permissionActive");
        model.addAttribute("activeUrl2", "adminPermissionsActive");
        model.addAttribute("pageTopBarInfo", "管理员权限管理界面");
        return "/admin/permission/adminpermissions";
    }

    /**
     * 更新管理员权限
     *
     * @param adminPermissions
     * @return
     */
    @PutMapping("/admin/updateAdminPermissions")
    @ResponseBody
    @OperLog(operModul = "权限模块", operType = "更新", operDesc = "更新管理员权限")
    public Msg updateAdminPermissions(@RequestParam("adminPermissions") String adminPermissions) {
        String[] strings = adminPermissions.split(";");
        //System.out.println(strings.length+":"+ Arrays.toString(strings));
        adminPermissionsService.deleteAllAdminPermissionsByAdminId(1);
        for (String string : strings) {
            AdminPermissions ap = new AdminPermissions();
            ap.setAdminid(1);
            ap.setPermissionid(permissionsService.selectPermissionsByPermission(string).get(0).getId());
            adminPermissionsService.insertAdminPermissions(ap);
        }
        return Msg.success();
    }
}
