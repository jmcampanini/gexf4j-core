package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

public interface GraphMetadata {
	
	Date getLastModified();
	void setLastModified(Date lastModified);
	
	String getCreator();
	void setCreator(String creator);
	
	String getDescription();
	void setDescription(String description);
	
	List<String> getKeywords();
}