package com.bitzh.finance.service;

import com.bitzh.finance.entity.News;

import java.util.List;

public interface NewsService {

    List<News> selectAllNews();
}
