package com.uniship.commodityms.service;

import com.uniship.commodityms.domain.Commodity;

import java.util.List;

public interface CommodityService {

    List<Commodity> getAllCommodity(Integer customerId);
    void saveCommodityList(List<Commodity> commodityList);
    void deleteCommodityList(List<Commodity> commodityList);


}
