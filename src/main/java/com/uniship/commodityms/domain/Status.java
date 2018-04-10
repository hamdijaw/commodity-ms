package com.uniship.commodityms.domain;

public class Status {

    private static final String STATUS_CODE_SUCCESS = "0";
    private static final String STATUS_CODE_FAIL = "1";
    private static final String STATUS_CODE_SUCCESS_EMPTY_RESULT = "2";
    private static final String EMPTY_RESULT_MESSAGE = "Data not found";
    private static final String ERROR_MESSAGE = "error";
    private static final String SUCCESS_MESSAGE = "success";


    private String code;
    private String description;

    public Status(boolean isSuccessful, boolean isResultEmpty) {
        if (isSuccessful) {
            if (isResultEmpty) {
                this.code = STATUS_CODE_SUCCESS_EMPTY_RESULT;
                this.description = EMPTY_RESULT_MESSAGE;
            } else {
                this.code = STATUS_CODE_SUCCESS;
                this.description = SUCCESS_MESSAGE;
            }
        } else {
            this.code = STATUS_CODE_FAIL;
            this.description = ERROR_MESSAGE;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
