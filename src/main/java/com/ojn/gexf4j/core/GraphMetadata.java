package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

public interface GraphMetadata {
	
	Date getLastModified();
	
	String getCreator();
	String getDescription();
	List<String> getKeywords();
}