package org.ret.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class GreetingController {

    @ApiOperation(notes = "Takes an document Id and returns a file dto", value = "Get information of a document.")
    @RequestMapping(value = "/", method = GET, produces = APPLICATION_JSON_VALUE)
    public void getDocumentInfo(@PathVariable("file_id") int fileId) {
    }
}