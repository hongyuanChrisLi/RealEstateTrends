package org.ret.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.ret.error.ErrorCode.MLS_PROP_DOES_NOT_EXIST;

import org.ret.service.MlsPropService;
import org.ret.service.dto.JsonResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Component
@Api(value = "MLS")
public class MlsPropController extends AbstractController {

    @Autowired
    private MlsPropService mlsPropService;
    
    @ApiOperation(value = "Gets", notes = "Returns")
    @RequestMapping(value = "/get", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JsonResponseDto> getMlsProp(){
        mlsPropService.getMlsProp("Somethin");
        return notFound(MLS_PROP_DOES_NOT_EXIST);
    }
    
    
}
