/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.sharedtestproject.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.sharedtestproject.classicmodels.*;


/**
 * ServiceImpl object for domain model class Offices.
 * @see com.sharedtestproject.classicmodels.Offices
 */
@Service("classicmodels.OfficesService")
public class OfficesServiceImpl implements OfficesService {


    private static final Logger LOGGER = LoggerFactory.getLogger(OfficesServiceImpl.class);

    @Autowired
    @Qualifier("classicmodels.OfficesDao")
    private WMGenericDao<Offices, String> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Offices, String> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
     public Page<Offices> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Offices create(Offices offices) {
        LOGGER.debug("Creating a new offices with information: {}" , offices);
        return this.wmGenericDao.create(offices);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Offices delete(String officesId) throws EntityNotFoundException {
        LOGGER.debug("Deleting offices with id: {}" , officesId);
        Offices deleted = this.wmGenericDao.findById(officesId);
        if (deleted == null) {
            LOGGER.debug("No offices found with id: {}" , officesId);
            throw new EntityNotFoundException(String.valueOf(officesId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Offices> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all officess");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Offices> findAll(Pageable pageable) {
        LOGGER.debug("Finding all officess");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Offices findById(String id) throws EntityNotFoundException {
        LOGGER.debug("Finding offices by id: {}" , id);
        Offices offices=this.wmGenericDao.findById(id);
        if(offices==null){
            LOGGER.debug("No offices found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return offices;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Offices update(Offices updated) throws EntityNotFoundException {
        LOGGER.debug("Updating offices with information: {}" , updated);
        this.wmGenericDao.update(updated);

        String id = (String)updated.getOfficeCode();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


