package org.ret.controller;

import static org.slf4j.LoggerFactory.getLogger;
import org.ret.error.ErrorCode;
import org.ret.exception.AppException;

import java.util.HashMap;
import java.util.Map;

import org.ret.service.dto.ErrorDto;
import org.ret.service.dto.JsonResponseDto;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


public abstract class AbstractController {
    
    private final static Logger LOGGER = getLogger(AbstractController.class);

    protected <T> ResponseEntity<JsonResponseDto> successResponse(String key, T data) {
        Map<String, Object> responseData = new HashMap<>();
        responseData.put(key, data);
        return success(responseData);
    }
    
    protected ResponseEntity<JsonResponseDto> notFound(ErrorCode errorCode) {
        ErrorDto errorDto = new ErrorDto(errorCode);
        errorDto.setHttpStatus(HttpStatus.BAD_REQUEST);
        return failure(errorDto);
    }
    
    private ResponseEntity<JsonResponseDto> success(Map<String, Object> responseData) {
        JsonResponseDto jsonResponseDto = new JsonResponseDto();
        jsonResponseDto.setResponseData(responseData);
        return genericResponse(jsonResponseDto, HttpStatus.OK);
    }
    
    private ResponseEntity<JsonResponseDto> failure(ErrorDto errorDto){
        JsonResponseDto jsonResponseDto = new JsonResponseDto();
        jsonResponseDto.setErrorDto(errorDto);
        return genericResponse(jsonResponseDto, errorDto.getHttpStatus());
    }
    
    private ResponseEntity<JsonResponseDto> genericResponse(JsonResponseDto jsonResponseDto, HttpStatus httpStatus) {
        return new ResponseEntity<>(jsonResponseDto, httpStatus);
    }
    
    @ExceptionHandler
    public ResponseEntity<JsonResponseDto> handlAppException(AppException appException){
        LOGGER.error(appException.getErrorCode().name(), appException);
        ErrorDto errorDto = new ErrorDto(appException);
        return failure(errorDto);
    }
    
    @ExceptionHandler
    public ResponseEntity<JsonResponseDto> handlException(Exception exception){
        AppException appException = new AppException(exception);
        appException.setErrorCode(ErrorCode.INTERNAL_SERVER_ERROR);
        appException.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return handlAppException(appException);
    }
    
}
