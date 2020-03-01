package com.starkindustries.business.service;

import java.util.List;


/**
 * Interface: CoreService
 * <p>Responsibilities:Core operations.</p>            
 */
public interface CoreService<T,Object>{		
	/**
	 * Method: save                          
	 * <p>
	 * Parameters:[T object] 
	 * </p>
	 * <p>
	 * Responsibility:Saves object to database
	 * </p>
	 * @throws Exception 
	 */
	void save(T object) throws Exception;

	
	/**
	 * Method: findAll                          
	 * <p>
	 * Parameters:[] 
	 * </p>
	 * <p>
	 * Responsibility:Returns object List from database
	 * </p>
	 */
	List<T> findAll();
	
	/**
	 * Method: findById                          
	 * <p>
	 * Parameters:[Object id] 
	 * </p>
	 * <p>
	 * Responsibility:Returns object from database
	 * </p>
	 */
	T findById(Object id);
	
	
}