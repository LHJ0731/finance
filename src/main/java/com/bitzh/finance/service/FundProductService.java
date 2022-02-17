package com.bitzh.finance.service;

import com.bitzh.finance.entity.FundProduct;

import java.util.List;

public interface FundProductService {

    List<FundProduct> selectAllFundProduct();

    FundProduct selectFundProductById(Integer id);

    Integer insertFundProduct(FundProduct fundProduct);

    Integer updateFundProduct(FundProduct fundProduct);

    Integer deleteFundProductById(Integer id);

    List<FundProduct> selectFundProductByInfo(String information);
}
