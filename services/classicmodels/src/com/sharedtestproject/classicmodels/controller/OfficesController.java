/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/
package com.sharedtestproject.classicmodels.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.sharedtestproject.classicmodels.service.EmployeesService;
import com.sharedtestproject.classicmodels.service.OfficesService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;
import com.sharedtestproject.classicmodels.*;
import com.sharedtestproject.classicmodels.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Offices.
 * @see com.sharedtestproject.classicmodels.Offices
 */
@RestController(value = "Classicmodels.OfficesController")
@RequestMapping("/classicmodels/Offices")
@Api(description = "Exposes APIs to work with Offices resource.", value = "OfficesController")
public class OfficesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OfficesController.class);

    @Autowired
    @Qualifier("classicmodels.OfficesService")
    private OfficesService officesService;

    @Autowired
    @Qualifier("classicmodels.EmployeesService")
    private EmployeesService employeesService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Offices instances matching the search criteria.")
    public Page<Offices> findOfficess(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Officess list");
        return officesService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Offices instances.")
    public Page<Offices> getOfficess(Pageable pageable) {
        LOGGER.debug("Rendering Officess list");
        return officesService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}/employeeses", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the employeeses instance associated with the given id.")
    public Page<Employees> findAssociatedemployeeses(Pageable pageable, @PathVariable("id") String id) {
        LOGGER.debug("Fetching all associated employeeses");
        return employeesService.findAssociatedValues(id, "offices", "officeCode", pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setOfficesService(OfficesService service) {
        this.officesService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Offices instance.")
    public Offices createOffices(@RequestBody Offices instance) {
        LOGGER.debug("Create Offices with information: {}", instance);
        instance = officesService.create(instance);
        LOGGER.debug("Created Offices with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Offices instances.")
    public Long countAllOfficess() {
        LOGGER.debug("counting Officess");
        Long count = officesService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Offices instance associated with the given id.")
    public Offices getOffices(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Getting Offices with id: {}", id);
        Offices instance = officesService.findById(id);
        LOGGER.debug("Offices details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Offices instance associated with the given id.")
    public Offices editOffices(@PathVariable(value = "id") String id, @RequestBody Offices instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Offices with id: {}", instance.getOfficeCode());
        instance.setOfficeCode(id);
        instance = officesService.update(instance);
        LOGGER.debug("Offices details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Offices instance associated with the given id.")
    public boolean deleteOffices(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Offices with id: {}", id);
        Offices deleted = officesService.delete(id);
        return deleted != null;
    }
}