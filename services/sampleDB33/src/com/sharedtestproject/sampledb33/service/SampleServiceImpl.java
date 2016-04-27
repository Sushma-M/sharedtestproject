/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.sharedtestproject.sampledb33.service;

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

import com.sharedtestproject.sampledb33.*;


/**
 * ServiceImpl object for domain model class Sample.
 * @see com.sharedtestproject.sampledb33.Sample
 */
@Service("sampleDB33.SampleService")
public class SampleServiceImpl implements SampleService {


    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Autowired
    @Qualifier("sampleDB33.SampleDao")
    private WMGenericDao<Sample, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Sample, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "sampleDB33TransactionManager")
     public Page<Sample> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "sampleDB33TransactionManager")
    @Override
    public Sample create(Sample sample) {
        LOGGER.debug("Creating a new sample with information: {}" , sample);
        return this.wmGenericDao.create(sample);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "sampleDB33TransactionManager")
    @Override
    public Sample delete(Integer sampleId) throws EntityNotFoundException {
        LOGGER.debug("Deleting sample with id: {}" , sampleId);
        Sample deleted = this.wmGenericDao.findById(sampleId);
        if (deleted == null) {
            LOGGER.debug("No sample found with id: {}" , sampleId);
            throw new EntityNotFoundException(String.valueOf(sampleId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "sampleDB33TransactionManager")
    @Override
    public Page<Sample> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all samples");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "sampleDB33TransactionManager")
    @Override
    public Page<Sample> findAll(Pageable pageable) {
        LOGGER.debug("Finding all samples");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "sampleDB33TransactionManager")
    @Override
    public Sample findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding sample by id: {}" , id);
        Sample sample=this.wmGenericDao.findById(id);
        if(sample==null){
            LOGGER.debug("No sample found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return sample;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "sampleDB33TransactionManager")
    @Override
    public Sample update(Sample updated) throws EntityNotFoundException {
        LOGGER.debug("Updating sample with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "sampleDB33TransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

