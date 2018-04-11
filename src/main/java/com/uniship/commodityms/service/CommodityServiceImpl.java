package com.uniship.commodityms.service;

import com.uniship.commodityms.domain.Commodity;
import com.uniship.commodityms.repository.CommodityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommodityServiceImpl.class);

    private CommodityRepository commodityRepository;

    @Autowired
    public CommodityServiceImpl(CommodityRepository commodityRepository) {
        this.commodityRepository = commodityRepository;
    }

    @Override
    public List<Commodity> getAllCommodity(Integer customerId) {
        LOGGER.info("fetching commodityList");
        return commodityRepository.findByCustomerId(customerId);
    }

    @Override
    public void saveCommodityList(List<Commodity> commodityList) {
        LOGGER.info("saving commodityList");
        commodityRepository.saveAll(commodityList);
    }

    @Override
    public void deleteCommodityList(List<Commodity> commodityList) {
        LOGGER.info("deleting commodityList");
        final List<Integer> commodityIdList = new ArrayList<>();
        commodityList.forEach(c -> commodityIdList.add(c.getId()));
        commodityRepository.deleteByIdIn(commodityIdList);
    }
}
