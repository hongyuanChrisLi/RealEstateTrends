package org.ret.admin.controller;

import static org.ret.admin.constant.URLRequestMapping.MLS_PROP_MAPPING;
import static org.ret.admin.error.ErrorCode.MLS_PROP_DOES_NOT_EXIST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.ret.admin.service.MlsPropService;
import org.ret.admin.service.dto.JsonResponseDto;
import org.ret.admin.service.dto.MlsPropDto;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@Api(value = "MLS")
public class MlsPropController extends AbstractController {

    @Autowired
    private MlsPropService mlsPropService;

    @ApiOperation(value = "Gets", notes = "Returns")
    @RequestMapping(value = MLS_PROP_MAPPING + "{id}", method = GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<JsonResponseDto> getMlsProp(@PathVariable("id") String mlsId) {
        MlsPropDto mlsPropDto = mlsPropService.getMlsProp(mlsId);
        if (mlsPropDto != null) {
            return successResponse("mls", mlsPropDto);
        }
        return notFound(MLS_PROP_DOES_NOT_EXIST);
    }
}
