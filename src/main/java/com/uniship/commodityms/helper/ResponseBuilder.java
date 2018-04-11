package com.uniship.commodityms.helper;

import com.uniship.commodityms.domain.*;
import com.uniship.commodityms.domain.Error;

import java.util.List;

public class ResponseBuilder {

    public static GetCommodityResponse buildGetCommodityResponse(List<Commodity> commodityList, boolean isSuccessful,
                                                                 Exception e) {
        GetCommodityResponse getCommodityResponse = new GetCommodityResponse();
        Status status;
        if (isSuccessful) {
            if (commodityList.size() > 0) {
                status = new Status(true, false);
                getCommodityResponse.setCommodityList(commodityList);

            } else {
                status = new Status(true, true);
            }
        } else {
            status = new Status(false, false);
            Error error = new Error();
            error.setErrorMessage(e.getMessage());
            getCommodityResponse.setError(error);
        }

        getCommodityResponse.setStatus(status);

        return getCommodityResponse;
    }

    public static SaveCommodityResponse buildSaveCommodityResponseSuccess() {
        SaveCommodityResponse saveCommodityResponse = new SaveCommodityResponse();
        Status status = new Status(true, false);
        saveCommodityResponse.setStatus(status);
        return saveCommodityResponse;
    }

    public static SaveCommodityResponse buildSaveCommodityResponseFailure() {
        SaveCommodityResponse saveCommodityResponse = new SaveCommodityResponse();
        Status status = new Status(false, true);
        saveCommodityResponse.setStatus(status);
        return saveCommodityResponse;
    }

    public static DeleteCommodityResponse buildDeleteCommodityResponseSuccess() {
        DeleteCommodityResponse deleteCommodityResponse = new DeleteCommodityResponse();
        Status status = new Status(true, false);
        deleteCommodityResponse.setStatus(status);
        return deleteCommodityResponse;
    }

    public static DeleteCommodityResponse buildDeleteCommodityResponseFailure() {
        DeleteCommodityResponse deleteCommodityResponse = new DeleteCommodityResponse();
        Status status = new Status(false, true);
        deleteCommodityResponse.setStatus(status);
        return deleteCommodityResponse;
    }

}
