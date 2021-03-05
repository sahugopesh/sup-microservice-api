package com.efx.sup.api.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.efx.sup.domain.Data;
import com.efx.sup.service.SUPService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/sup/api/v1")
@Api(tags = {"sup"})
public class SUPController extends AbstractRestHandler {

    @Autowired
    private SUPService supService;

    @RequestMapping(value = "/data",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a data resource.", notes = "Returns the URL of the new resource in the Location header.")
    public void createData(@RequestBody Data data,
                                 HttpServletRequest request, HttpServletResponse response) {
    	System.out.println(" billig data "+data.getBillingData() + " :: price "+data.getInvoicePrice());
        Data createdData = this.supService.createData(data);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdData.getId()).toString());
    }

}
