package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.Metadata;

public class MetadataImpl implements Metadata {

	private String creator = null;
	private String description = null;
	private List<String> keywords = new ArrayList<String>();
	private Date lastModified = null;
	
	public MetadataImpl() {
		
	}
	
	@Override
	public String getCreator() {
		return creator;
	}
	
	@Override
	public Metadata setCreator(String creator) {
		this.creator = creator;
		return this;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public Metadata setDescription(String description) {
		this.description = description;
		return this;
	}
	
	@Override
	public List<String> getKeywords() {
		return keywords;
	}
	
	@Override
	public Date getLastModified() {
		return lastModified;
	}
	
	@Override
	public Metadata setLastModified(Date lastModified) {
		this.lastModified = lastModified;
		return this;
	}	
}