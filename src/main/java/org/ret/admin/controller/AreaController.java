package org.ret.admin.controller;

import static org.ret.admin.constant.URLRequestMapping.AREA_COUNTY_MAPPING;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.ret.admin.error.ErrorCode.NO_COUNTY_FOUND;

import java.util.List;

import org.ret.admin.service.CountyService;
import org.ret.admin.service.dto.CountyDto;
import org.ret.admin.service.dto.JsonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value = "MLS")
public class AreaController extends AbstractController {
    
    @Autowired
    CountyService countyService;
    
    @ApiOperation(value = "Get All Counties", notes = "Get All Counties")
    @RequestMapping(value = AREA_COUNTY_MAPPING, method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JsonResponseDto> getAllCounties() {
        
        List<CountyDto> countyDtoList = countyService.getAllCountyDto();
        if (countyDtoList != null) {
            return successResponse("counties", countyDtoList);
        }
        return notFound(NO_COUNTY_FOUND);
    }
}
