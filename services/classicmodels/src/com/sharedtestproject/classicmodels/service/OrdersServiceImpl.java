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
 * ServiceImpl object for domain model class Orders.
 * @see com.sharedtestproject.classicmodels.Orders
 */
@Service("classicmodels.OrdersService")
public class OrdersServiceImpl implements OrdersService {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    @Qualifier("classicmodels.OrdersDao")
    private WMGenericDao<Orders, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Orders, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
     public Page<Orders> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public Orders create(Orders orders) {
        LOGGER.debug("Creating a new orders with information: {}" , orders);
        return this.wmGenericDao.create(orders);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Orders delete(Integer ordersId) throws EntityNotFoundException {
        LOGGER.debug("Deleting orders with id: {}" , ordersId);
        Orders deleted = this.wmGenericDao.findById(ordersId);
        if (deleted == null) {
            LOGGER.debug("No orders found with id: {}" , ordersId);
            throw new EntityNotFoundException(String.valueOf(ordersId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Orders> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all orderss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<Orders> findAll(Pageable pageable) {
        LOGGER.debug("Finding all orderss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Orders findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding orders by id: {}" , id);
        Orders orders=this.wmGenericDao.findById(id);
        if(orders==null){
            LOGGER.debug("No orders found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return orders;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public Orders update(Orders updated) throws EntityNotFoundException {
        LOGGER.debug("Updating orders with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getOrderNumber();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


