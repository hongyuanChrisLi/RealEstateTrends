package org.ret.admin.exception;

import org.ret.admin.error.ErrorCode;
import org.springframework.http.HttpStatus;

public class AppException extends Exception{

    private static final long serialVersionUID = -1389682605416775692L;
    
    private String errorMsg;
    
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    
    public AppException(Throwable cause) {
        super(cause);
        StackTraceElement[] elements = cause.getStackTrace();
        this.errorMsg = elements[0].toString();
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

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
