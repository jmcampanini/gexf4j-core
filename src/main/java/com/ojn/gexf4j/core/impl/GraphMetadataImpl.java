package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.GraphMetadata;

public class GraphMetadataImpl implements GraphMetadata {

	private String creator = null;
	private String description = null;
	private List<String> keywords = new ArrayList<String>();
	private Date lastModified = null;
	
	public GraphMetadataImpl() {
		
	}
	
	@Override
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public List<String> getKeywords() {
		return keywords;
	}
	
	@Override
	public Date getLastModified() {
		return lastModified;
	}
	
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}	
}