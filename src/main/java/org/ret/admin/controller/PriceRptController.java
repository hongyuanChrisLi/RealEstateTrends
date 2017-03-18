package org.ret.admin.controller;

import static org.ret.admin.constant.URLRequestMapping.PRICE_RPT_PROP_ADDR_MAPPING;
import static org.ret.admin.error.ErrorCode.NO_PROP_ADDR_PRICE_RPT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.ret.admin.service.PriceRptService;
import org.ret.admin.service.dto.JsonResponseDto;
import org.ret.admin.service.dto.PropAddrPriceRptDto;
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
@Api(value = "PriceRpt")
public class PriceRptController extends AbstractController {
    
    @Autowired
    PriceRptService priceRptService;
    
    @ApiOperation(value = "Return List of PropAddrPriceRptDto", notes = "Get Price Report History of Property Addresses")
    @RequestMapping(value = PRICE_RPT_PROP_ADDR_MAPPING + "/{countyId}-{cityId}-{zipcode}-{propTypeId}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResponseDto> getPropAddrPriceRpts(
            @PathVariable("countyId") Integer countyId, 
            @PathVariable("cityId") Integer cityId, 
            @PathVariable("zipcode") String zipcode, 
            @PathVariable("propTypeId") Integer propTypeId){
        
        List<PropAddrPriceRptDto> propAddrPriceRptDtos = priceRptService.getPropAddrPriceRpts(countyId, cityId, zipcode, propTypeId);
        if (propAddrPriceRptDtos != null) {
            return successResponse("priceRpts", propAddrPriceRptDtos);
        }
        return notFound(NO_PROP_ADDR_PRICE_RPT_FOUND);
    }
}
