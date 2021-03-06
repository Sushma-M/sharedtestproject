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
 * ServiceImpl object for domain model class ArticleTags.
 * @see com.sharedtestproject.classicmodels.ArticleTags
 */
@Service("classicmodels.ArticleTagsService")
public class ArticleTagsServiceImpl implements ArticleTagsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleTagsServiceImpl.class);

    @Autowired
    @Qualifier("classicmodels.ArticleTagsDao")
    private WMGenericDao<ArticleTags, ArticleTagsId> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<ArticleTags, ArticleTagsId> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
     public Page<ArticleTags> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "classicmodelsTransactionManager")
    @Override
    public ArticleTags create(ArticleTags articletags) {
        LOGGER.debug("Creating a new articletags with information: {}" , articletags);
        return this.wmGenericDao.create(articletags);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public ArticleTags delete(ArticleTagsId articletagsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting articletags with id: {}" , articletagsId);
        ArticleTags deleted = this.wmGenericDao.findById(articletagsId);
        if (deleted == null) {
            LOGGER.debug("No articletags found with id: {}" , articletagsId);
            throw new EntityNotFoundException(String.valueOf(articletagsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<ArticleTags> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all articletagss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public Page<ArticleTags> findAll(Pageable pageable) {
        LOGGER.debug("Finding all articletagss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public ArticleTags findById(ArticleTagsId id) throws EntityNotFoundException {
        LOGGER.debug("Finding articletags by id: {}" , id);
        ArticleTags articletags=this.wmGenericDao.findById(id);
        if(articletags==null){
            LOGGER.debug("No articletags found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return articletags;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "classicmodelsTransactionManager")
    @Override
    public ArticleTags update(ArticleTags updated) throws EntityNotFoundException {
        LOGGER.debug("Updating articletags with information: {}" , updated);
        this.wmGenericDao.update(updated);

        ArticleTagsId id = new ArticleTagsId();
        id.setArticleId(updated.getArticleId());
        id.setTagId(updated.getTagId());

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "classicmodelsTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}


