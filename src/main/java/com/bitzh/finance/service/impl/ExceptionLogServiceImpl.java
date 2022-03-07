package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.ExceptionLog;
import com.bitzh.finance.mapper.ExceptionLogMapper;
import com.bitzh.finance.service.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionLogServiceImpl implements ExceptionLogService {
    @Autowired
    ExceptionLogMapper exceptionLogMapper;

    @Override
    public Integer insert(ExceptionLog excepLog) {
        return exceptionLogMapper.insert(excepLog);
    }
}
