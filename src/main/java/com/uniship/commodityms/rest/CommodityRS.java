package com.uniship.commodityms.rest;

import com.uniship.commodityms.domain.*;
import com.uniship.commodityms.domain.Error;
import com.uniship.commodityms.helper.ResponseBuilder;
import com.uniship.commodityms.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity getCommodityList(@RequestParam Integer customerId) {
        List<Commodity> commodityList = new ArrayList<>();
        GetCommodityResponse getCommodityResponse = null;
        ResponseEntity responseEntity = null;
        try {
            if (customerId == 999) throw new RuntimeException("RuntimeException occured");
            commodityList = commodityService.getAllCommodity(customerId);
            getCommodityResponse = ResponseBuilder.buildGetCommodityResponse(commodityList, true, null);
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(getCommodityResponse);
        } catch (Exception e) {
            LOGGER.error("An error occured during fetch. Exception Message: {}", e.getMessage());
            getCommodityResponse = ResponseBuilder.buildGetCommodityResponse(null, false, e);
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(getCommodityResponse);
        }
        return responseEntity;
    }

    @PostMapping("/Commodity")
    public ResponseEntity<SaveCommodityResponse> saveCommodityList(@RequestPart(name = "commodityList") List<Commodity> commodityList,
                                                                   @RequestPart(name = "document", required = false) MultipartFile documentFile
                                                                   ) {
        SaveCommodityResponse saveCommodityResponse = null;
        ResponseEntity<SaveCommodityResponse> responseResponseEntity = null;
        try {
            for (Commodity commodity : commodityList) {
                Document document = commodity.getDocumentDetails();
                if (null != document) {
                    document.setDocumentImage(documentFile.getBytes());
                }
            }

            commodityService.saveCommodityList(commodityList);
            saveCommodityResponse = ResponseBuilder.buildSaveCommodityResponseSuccess();
            responseResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(saveCommodityResponse);
        } catch (Exception e) {
            LOGGER.error("An error occured during save. Exception Message: {}", e.getMessage());
            saveCommodityResponse = ResponseBuilder.buildSaveCommodityResponseFailure();
            responseResponseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(saveCommodityResponse);
            final Error error = new Error();
            error.setErrorMessage(e.getMessage());
            error.setErrorId("400");
            saveCommodityResponse.setError(error);
        }

        return responseResponseEntity;
    }

    @DeleteMapping("/Commodity")
    public ResponseEntity<DeleteCommodityResponse> deleteCommodityList(@RequestBody List<Commodity> commodityList) {
        DeleteCommodityResponse deleteCommodityResponse = null;
        ResponseEntity<DeleteCommodityResponse> responseEntity = null;
        try {
            commodityService.deleteCommodityList(commodityList);
            deleteCommodityResponse = ResponseBuilder.buildDeleteCommodityResponseSuccess();
            responseEntity = ResponseEntity.status(HttpStatus.OK).body(deleteCommodityResponse);
        } catch (Exception e) {
            LOGGER.error("An error occured during delete. Exception Message: {}", e.getMessage());
            deleteCommodityResponse = ResponseBuilder.buildDeleteCommodityResponseFailure();
            responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(deleteCommodityResponse);
        }

        return responseEntity;
    }

}
