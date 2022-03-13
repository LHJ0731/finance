package com.bitzh.finance.controller;

import com.bitzh.finance.service.ChangeMoneyService;
import com.bitzh.finance.service.FundProductService;
import com.bitzh.finance.service.PayMoneyService;
import com.bitzh.finance.service.TermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class StatController {
    @Autowired
    ChangeMoneyService changeMoneyService;
    @Autowired
    FundProductService fundProductService;
    @Autowired
    PayMoneyService payMoneyService;
    @Autowired
    TermFinancialService termFinancialService;

    /**
     * 跳转到产品统计页面
     *
     * @param
     * @return
     */
    @RequestMapping("/admin/finance/toProductStat.html")
    public String toProductStat(Model model, HttpSession session) {

        Integer changMoneyNum = changeMoneyService.selectcount();
        Integer fundProductNum = fundProductService.selectcount();
        Integer payMoneyNum = payMoneyService.selectcount();
        Integer termFinancialNum = termFinancialService.selectcount();
        model.addAttribute("changMoneyNum", changMoneyNum);
        model.addAttribute("fundProductNum", fundProductNum);
        model.addAttribute("payMoneyNum", payMoneyNum);
        model.addAttribute("termFinancialNum", termFinancialNum);

        model.addAttribute("activeUrl1", "financeActive");
        model.addAttribute("activeUrl2", "statActive");
        model.addAttribute("pageTopBarInfo", "产品分析界面");
        return "/admin/finance/productstat";
    }
}
