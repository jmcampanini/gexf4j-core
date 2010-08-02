package com.ojn.gexf4j.core;

public interface Gexf {

	String getVersion();
	
	String getVariant();
	Gexf setVariant(String variant);
	
	Metadata getMetadata();
	
	Graph getGraph();
}