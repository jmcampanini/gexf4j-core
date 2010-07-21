package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ojn.gexf4j.core.data.Attribute;

public interface Graph {

	GraphMetadata getMetadata();
	
	EdgeType getDefaultEdgeType();
	void setDefaultEdgeType(EdgeType edgeType);
	
	GraphMode getGraphMode();
	void setGraphMode(GraphMode graphMode);
	
	Node createNode();
	Node createNode(String id);
	
	List<Attribute> getAttributes();
	Map<String, Node> getNodeMap();
	
	Date getStartDate();
	void setStartDate(Date startDate);
	
	Date getEndDate();
	void setEndDate(Date endDate);
	
	List<Slice> getSlices();
}