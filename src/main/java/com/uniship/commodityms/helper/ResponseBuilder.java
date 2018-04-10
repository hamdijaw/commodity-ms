package com.uniship.commodityms.helper;

import com.uniship.commodityms.domain.Commodity;
import com.uniship.commodityms.domain.Error;
import com.uniship.commodityms.domain.GetCommodityResponse;
import com.uniship.commodityms.domain.Status;

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
}
