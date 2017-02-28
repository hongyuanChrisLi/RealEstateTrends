package org.ret.service.dto;

import java.util.Map;

public class JsonResponseDto {
    
    private int status;
    
    private String statMsg;
    
    private Map<String, Object> responseData;
    
    private ErrorDto errorDto;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatMsg() {
        return statMsg;
    }

    public void setStatMsg(String statMsg) {
        this.statMsg = statMsg;
    }

    public Map<String, Object> getResponseData() {
        return responseData;
    }

    public void setResponseData(Map<String, Object> responseData) {
        this.responseData = responseData;
    }

    public ErrorDto getErrorDto() {
        return errorDto;
    }

    public void setErrorDto(ErrorDto errorDto) {
        this.errorDto = errorDto;
    }
    
}
