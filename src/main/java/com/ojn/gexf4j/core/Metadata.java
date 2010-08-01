package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

public interface Metadata {
	
	Date getLastModified();
	Metadata setLastModified(Date lastModified);
	
	String getCreator();
	Metadata setCreator(String creator);
	
	String getDescription();
	Metadata setDescription(String description);
	
	List<String> getKeywords();
}