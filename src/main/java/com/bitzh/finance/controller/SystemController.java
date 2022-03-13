package com.bitzh.finance.controller;

import com.bitzh.finance.entity.ExceptionLog;
import com.bitzh.finance.entity.OperationLog;
import com.bitzh.finance.entity.User;
import com.bitzh.finance.service.ExceptionLogService;
import com.bitzh.finance.service.OperationLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SystemController {

    @Autowired
    OperationLogService operationLogService;
    @Autowired
    ExceptionLogService exceptionLogService;

    /**
     * 跳转到操作日志管理界面
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/admin/system/toOperationLogManage.html")
    public String toOperation(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                              Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<OperationLog> list = operationLogService.selectAllOperationLog();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<OperationLog> pageInfo = new PageInfo<OperationLog>(list, 5);

        model.addAttribute("operationLogPageInfo", pageInfo);
        model.addAttribute("operationLogList", list);

        model.addAttribute("pageTopBarInfo", "操作日志界面");
        model.addAttribute("activeUrl1", "systemActive");
        model.addAttribute("activeUrl2", "operationActive");
        return "/admin/system/operationlogmanage";
    }

    /**
     * 跳转到错误日志管理界面
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/admin/system/toExceptionLogManage.html")
    public String toException(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "2") Integer pageSize,
                              Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<ExceptionLog> list = exceptionLogService.selectAllExceptionLog();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<ExceptionLog> pageInfo = new PageInfo<ExceptionLog>(list, 5);
        model.addAttribute("exceptionLogPageInfo", pageInfo);
        model.addAttribute("exceptionLogList", list);

        model.addAttribute("activeUrl1", "systemActive");
        model.addAttribute("activeUrl2", "exceptionActive");
        model.addAttribute("pageTopBarInfo", "错误日志界面");
        return "/admin/system/exceptionlogmanage";
    }

//    /**
//     * 跳转监控界面
//     */
//    @GetMapping("/admin/system/toDataSource")
//    public String toDataSource(Model model){
//        model.addAttribute("activeUrl1", "systemActive");
//        model.addAttribute("activeUrl2", "DataSourceActive");
//        return "http://localhost:9090/druid/login.html";
//    }

}
