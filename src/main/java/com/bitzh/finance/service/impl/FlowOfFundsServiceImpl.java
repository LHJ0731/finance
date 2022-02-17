package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.FlowOfFunds;
import com.bitzh.finance.entity.FlowOfFundsExample;
import com.bitzh.finance.mapper.FlowOfFundsMapper;
import com.bitzh.finance.service.FlowOfFundsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlowOfFundsServiceImpl implements FlowOfFundsService {

    @Autowired
    FlowOfFundsMapper flowOfFundsMapper;

    @Override
    @Transactional
    public Integer insertFlowOfFunds(FlowOfFunds flowOfFunds) {
        return flowOfFundsMapper.insertSelective(flowOfFunds);
    }

    @Override
    public List<FlowOfFunds> selectFlowOfFundsByUserId(Integer userId) {
        FlowOfFundsExample fofe = new FlowOfFundsExample();
        fofe.createCriteria().andUseridEqualTo(userId);
        fofe.setOrderByClause("id desc");
        return flowOfFundsMapper.selectByExample(fofe);
    }
}
