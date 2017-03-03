package org.ret.admin.service.dto;

import org.ret.admin.error.ErrorCode;
import org.ret.admin.exception.AppException;
import org.springframework.http.HttpStatus;

public class ErrorDto {
    private ErrorCode errorCode;
    
    private String errorMsg;
    
    private HttpStatus httpStatus;
    
    public ErrorDto(ErrorCode errorCode){
        this.errorCode = errorCode;
    }
    
    public ErrorDto(ErrorCode errorCode, String errorMsg){
        this.errorMsg = errorMsg;
    }
    
    public ErrorDto(AppException appException){
        this.errorCode = appException.getErrorCode();
        this.httpStatus = appException.getHttpStatus();
        this.errorMsg = appException.getErrorMsg();
    }
    
    public ErrorCode getErrorCode(){
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
