package com.uniship.commodityms.domain;

public class SaveCommodityResponse {

    public SaveCommodityResponse() {
    }

    private Status status;
    private Error error;

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

}
