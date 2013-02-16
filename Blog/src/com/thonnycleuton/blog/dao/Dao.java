package com.thonnycleuton.blog.dao;

import java.util.List;
import java.util.Map;

public interface Dao {
	
	public Object save ();
	public void delete();
	public Object find (Class entityClass, Object id);
	public List find (Class entityClass);
	public List find (String queryName);
	public List find (String queryName, Map<String, Object> namedParams);
	
	public List find(String queryName, Map<String, Object> namedParams, 
						int firstResult, int maxResults);
}
