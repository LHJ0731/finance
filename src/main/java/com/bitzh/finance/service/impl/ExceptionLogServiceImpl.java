package com.bitzh.finance.service.impl;

import com.bitzh.finance.entity.ExceptionLog;
import com.bitzh.finance.mapper.ExceptionLogMapper;
import com.bitzh.finance.service.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {
    @Autowired
    ExceptionLogMapper exceptionLogMapper;

    @Override
    public Integer insert(ExceptionLog excepLog) {
        return exceptionLogMapper.insert(excepLog);
    }

    @Override
    public List<ExceptionLog> selectAllExceptionLog() {
        return exceptionLogMapper.selectAllExceptionLog();
    }

    @Override
    public Integer deleteExceptionLogById(String id) {
        return exceptionLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ExceptionLog> selectExceptionLogByInfo(String opertor, String startdate, String enddate) {
        return exceptionLogMapper.selectExceptionLogByInfo(opertor, startdate, enddate);
    }
}
