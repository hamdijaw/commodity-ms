package com.uniship.commodityms.domain;

public class Status {

    private static final String SUCCESS = "0";
    private static final String ERROR = "1";
    private static final String DATA_NOT_FOUND = "2";
    private static final String EXCEPTION = "3";
    private static final String EMPTY_RESULT_MESSAGE = "Data not found";
    private static final String ERROR_MESSAGE = "error";
    private static final String SUCCESS_MESSAGE = "success";


    private String code;
    private String description;

    public Status(boolean isSuccessful, boolean isResultEmpty) {
        if (isSuccessful) {
            if (isResultEmpty) {
                this.code = DATA_NOT_FOUND;
                this.description = EMPTY_RESULT_MESSAGE;
            } else {
                this.code = SUCCESS;
                this.description = SUCCESS_MESSAGE;
            }
        } else {
            this.code = ERROR;
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
