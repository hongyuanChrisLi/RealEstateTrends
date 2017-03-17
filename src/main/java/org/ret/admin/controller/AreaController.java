package org.ret.admin.controller;

import static org.ret.admin.constant.URLRequestMapping.AREA_COUNTY_MAPPING;
import static org.ret.admin.constant.URLRequestMapping.AREA_CITY_MAPPING;
import static org.ret.admin.constant.URLRequestMapping.AREA_ZIPCODE_MAPPING;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.ret.admin.error.ErrorCode.NO_COUNTY_FOUND;
import static org.ret.admin.error.ErrorCode.NO_CITY_FOUND;
import static org.ret.admin.error.ErrorCode.NO_ZIPCODE_FOUND;

import java.util.List;

import org.ret.admin.service.AreaService;
import org.ret.admin.service.dto.CityDto;
import org.ret.admin.service.dto.CountyDto;
import org.ret.admin.service.dto.JsonResponseDto;
import org.ret.admin.service.dto.ZipcodeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value = "Area")
public class AreaController extends AbstractController {
    
    @Autowired
    AreaService areaService;
    
    @ApiOperation(value = "Get All Counties", notes = "Get All Counties")
    @RequestMapping(value = AREA_COUNTY_MAPPING, method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResponseDto> getAllCounties() {
        
        List<CountyDto> countyDtos = areaService.getAllCountyDtos();
        if (countyDtos != null) {
            return successResponse("counties", countyDtos);
        }
        return notFound(NO_COUNTY_FOUND);
    }
    
    @ApiOperation(value = "Get Cities of A County", notes = "Input County Id")
    @RequestMapping(value = AREA_CITY_MAPPING + "/{countyId}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResponseDto> getCountyCities(@PathVariable("countyId") int countyId) {
        
        List<CityDto> cityDtos = areaService.getCountyCityDtos(countyId);
        if (cityDtos != null) {
            return successResponse("cities", cityDtos);
        }
        return notFound(NO_CITY_FOUND);
    }
    
    
    @ApiOperation(value = "Get Zipcodes of A City", notes = "Input City Id")
    @RequestMapping(value = AREA_ZIPCODE_MAPPING + "/{cityId}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResponseDto> getCityZipcodes(@PathVariable("cityId") int cityId) {
        
        List<ZipcodeDto> zipcodeDtos = areaService.getCityZipcodeDtos(cityId);
        if (zipcodeDtos != null) {
            return successResponse("zipcodes", zipcodeDtos);
        }
        return notFound(NO_ZIPCODE_FOUND);
    }
    
}
