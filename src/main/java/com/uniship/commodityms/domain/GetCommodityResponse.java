package com.uniship.commodityms.domain;

import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCommodityResponse {

    private Status status;
    private Error error;
    private List<Commodity> commodityList;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public List<Commodity> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Commodity> commodityList) {
        this.commodityList = commodityList;
    }
}
