package com.uniship.commodityms.rest;

import com.uniship.commodityms.domain.Commodity;
import com.uniship.commodityms.domain.GetCommodityResponse;
import com.uniship.commodityms.helper.ResponseBuilder;
import com.uniship.commodityms.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/msapi/CommodityManagementMs/v1")
public class CommodityRS {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommodityRS.class);

    private CommodityService commodityService;

    @Autowired
    public CommodityRS(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/commodityList")
    public GetCommodityResponse getCommodityList(@RequestParam Integer customerId) {
        List<Commodity> commodityList = new ArrayList<>();
        GetCommodityResponse getCommodityResponse = null;
        try {
            commodityList = commodityService.getAllCommodity(customerId);
            getCommodityResponse = ResponseBuilder.buildGetCommodityResponse(commodityList, true, null);
        } catch (Exception e) {
            LOGGER.error("An error occured during fetch. Exception Message: {}", e.getMessage());
            getCommodityResponse = ResponseBuilder.buildGetCommodityResponse(null, false, e);
        }

        return getCommodityResponse;
    }

    @PostMapping("/Commodity")
    public void saveCommodityList(@RequestBody List<Commodity> commodityList) {
        try {
            commodityService.saveCommodityList(commodityList);
        } catch (Exception e) {
            LOGGER.error("An error occured during save. Exception Message: {}", e.getMessage());
        }
    }

    @DeleteMapping("/Commodity")
    public void deleteCommodityList(@RequestBody List<Commodity> commodityList) {
        try {
            commodityService.deleteCommodityList(commodityList);
        } catch (Exception e) {
            LOGGER.error("An error occured during delete. Exception Message: {}", e.getMessage());
        }

    }

}
