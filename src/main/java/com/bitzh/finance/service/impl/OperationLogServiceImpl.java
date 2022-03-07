package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.OperationLog;
import com.bitzh.finance.mapper.OperationLogMapper;
import com.bitzh.finance.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    OperationLogMapper operationLogMapper;

    @Override
    public Integer insert(OperationLog operlog) {
        return operationLogMapper.insert(operlog);
    }
}
