package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.OperationLog;
import com.bitzh.finance.mapper.OperationLogMapper;
import com.bitzh.finance.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperationLogMapper operationLogMapper;

    @Override
    @Transactional
    public Integer insert(OperationLog operlog) {
        return operationLogMapper.insert(operlog);
    }

    @Override
    public List<OperationLog> selectAllOperationLog() {
        return operationLogMapper.selectAllOperationLog();
    }
}
