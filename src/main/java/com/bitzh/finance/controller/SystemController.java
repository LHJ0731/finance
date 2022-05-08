package com.bitzh.finance.controller;

import com.bitzh.finance.common.Msg;
import com.bitzh.finance.entity.ExceptionLog;
import com.bitzh.finance.entity.OperationLog;
import com.bitzh.finance.service.ExceptionLogService;
import com.bitzh.finance.service.OperationLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                              @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                              Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<ExceptionLog> list = exceptionLogService.selectAllExceptionLog();
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<ExceptionLog> pageInfo = new PageInfo<ExceptionLog>(list, 5);
        model.addAttribute("exceptionLogPageInfo", pageInfo);
        model.addAttribute("exceptionLogList", list);

        model.addAttribute("pageTopBarInfo", "错误日志界面");
        model.addAttribute("activeUrl1", "systemActive");
        model.addAttribute("activeUrl2", "exceptionActive");

        return "/admin/system/exceptionlogmanage";
    }

    /**
     * 删除操作日志记录
     *
     * @param id
     */
    @DeleteMapping("/admin/deleteOperationLogById/{id}")
    @ResponseBody
    public Msg deleteOperationlog(@PathVariable("id") String id) {
        Integer result = operationLogService.deleteOperationLogById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 删除操作日志记录
     *
     * @param id
     */
    @DeleteMapping("/admin/deleteExceptionLogById/{id}")
    @ResponseBody
    public Msg deleteExceptionlog(@PathVariable("id") String id) {
        Integer result = exceptionLogService.deleteExceptionLogById(id);
        if (result == 1) {
            return Msg.success();
        }
        return Msg.fail();
    }

    /**
     * 查询操作日志
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/admin/selectOperationLog")
    public String selectOperationLog(@RequestParam("opertor") String opertor,
                                     @RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                     Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<OperationLog> list = operationLogService.selectOperationLogByInfo(opertor, startdate, enddate);
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<OperationLog> pageInfo = new PageInfo<OperationLog>(list, 5);

        model.addAttribute("operationLogPageInfo", pageInfo);
        model.addAttribute("operationLogList", list);
        return "/admin/system/operationlogmanage::card";
    }

    /**
     * 查询错误日志
     *
     * @param pageNum
     * @param pageSize
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/admin/selectExceptionLog")
    public String selectExceptionLog(@RequestParam("opertor") String opertor,
                                     @RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                     Model model, HttpSession session) {
        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        List<ExceptionLog> list = exceptionLogService.selectExceptionLogByInfo(opertor, startdate, enddate);

        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<ExceptionLog> pageInfo = new PageInfo<ExceptionLog>(list, 5);
        model.addAttribute("exceptionLogPageInfo", pageInfo);
        model.addAttribute("exceptionLogList", list);
        return "/admin/system/exceptionlogmanage::card";
    }
}
