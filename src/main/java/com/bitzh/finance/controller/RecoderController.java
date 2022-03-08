package com.bitzh.finance.controller;

import com.bitzh.finance.common.OperLog;
import com.bitzh.finance.entity.FlowOfFunds;
import com.bitzh.finance.entity.User;
import com.bitzh.finance.service.FlowOfFundsService;
import com.bitzh.finance.utils.ExportUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class RecoderController {

    @Autowired
    FlowOfFundsService flowOfFundsService;

    /**
     * 跳转到资金记录界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/user/tools/toRecord.html")
    public String toRecoder(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                            Model model, HttpSession session) {

        // 引入PageHelper插件，在查询之前调用startPage方法，传入页码以及每页大小
        PageHelper.startPage(pageNum, pageSize);
        User user = (User) session.getAttribute("loginUser");
        List<FlowOfFunds> list = flowOfFundsService.selectFlowOfFundsByUserId(user.getId());
        // 使用PageInfo包装查询后的结果，并交给页面处理
        // PageInfo封装了详细的分页信息，包括我们查询出来的数据，还可以传入连续显示的页数（5）
        PageInfo<FlowOfFunds> pageInfo = new PageInfo<FlowOfFunds>(list, 5);

        model.addAttribute("flowOfFundsList", list);
        model.addAttribute("flowOfFundsPageInfo", pageInfo);
        model.addAttribute("pageTopBarInfo", "资金记录界面");
        model.addAttribute("activeUrl1", "toolsActive");
        model.addAttribute("activeUrl2", "recordActive");
        return "/user/tools/record";
    }

    /**
     * 导出用户资金记录数据
     *
     * @param userId
     * @param session
     */
    @RequestMapping("/user/export/{userId}")
    @OperLog(operModul = "资金记录模块", operType = "查询", operDesc = "导出用户资金记录数据")
    public ResponseEntity<Object> export(@PathVariable("userId") String userId, HttpSession session) {
        List<FlowOfFunds> list = flowOfFundsService.selectFlowOfFundsByUserId(Integer.parseInt(userId));
        String fileName = "客户资金记录数据.xls";
        String sheetName = "资金记录数据";

        ByteArrayOutputStream bos = ExportUtils.exportRecord(list, sheetName);

        try {
            //处理文件名乱码
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //创建 封装响应头信息的对象
            HttpHeaders headers = new HttpHeaders();
            //封装响应内容类型(APPLICATION_OCTET_STREAM 响应的内容不限定)
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //设置下载的文件的名称
            headers.setContentDispositionFormData("attachment", fileName);
            return new ResponseEntity<Object>(bos.toByteArray(), headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
