/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.sharedtestproject.classicmodels.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.sharedtestproject.classicmodels.*;

/**
 * Service object for domain model class Offices.
 * @see com.sharedtestproject.classicmodels.Offices
 */

public interface OfficesService {
   /**
	 * Creates a new offices.
	 * 
	 * @param created
	 *            The information of the created offices.
	 * @return The created offices.
	 */
	public Offices create(Offices created);

	/**
	 * Deletes a offices.
	 * 
	 * @param officesId
	 *            The id of the deleted offices.
	 * @return The deleted offices.
	 * @throws EntityNotFoundException
	 *             if no offices is found with the given id.
	 */
	public Offices delete(String officesId) throws EntityNotFoundException;

	/**
	 * Finds all officess.
	 * 
	 * @return A list of officess.
	 */
	public Page<Offices> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Offices> findAll(Pageable pageable);
	
	/**
	 * Finds offices by id.
	 * 
	 * @param id
	 *            The id of the wanted offices.
	 * @return The found offices. If no offices is found, this method returns
	 *         null.
	 */
	public Offices findById(String id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a offices.
	 * 
	 * @param updated
	 *            The information of the updated offices.
	 * @return The updated offices.
	 * @throws EntityNotFoundException
	 *             if no offices is found with given id.
	 */
	public Offices update(Offices updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the officess in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the offices.
	 */

	public long countAll();


    public Page<Offices> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}
