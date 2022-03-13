package com.bitzh.finance.service;

import com.bitzh.finance.entity.ExceptionLog;

import java.util.List;

public interface ExceptionLogService {
    Integer insert(ExceptionLog excepLog);

    List<ExceptionLog> selectAllExceptionLog();

    Integer deleteExceptionLogById(String id);
}
