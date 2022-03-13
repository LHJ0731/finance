package com.bitzh.finance.service;

import com.bitzh.finance.entity.TermFinancial;

import java.util.List;

public interface TermFinancialService {

    List<TermFinancial> selectAllTermFinancial();

    TermFinancial selectTermFinancialById(Integer id);

    Integer insertTermFinancial(TermFinancial termFinancial);

    Integer updateTermFinancial(TermFinancial termFinancial);

    Integer deleteTermFinancialById(Integer id);

    List<TermFinancial> selectTermFinancialByInfo(String information);

    Integer selectcount();
}
