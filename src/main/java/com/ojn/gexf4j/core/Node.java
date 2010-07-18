package com.ojn.gexf4j.core;

import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.data.AttributeValue;

public interface Node {

	String getId();
	
	String getLabel();
	void setLabel(String label);
	
	List<AttributeValue> getAttributeValues();
	
	List<Edge> getEdges();
	
	Edge connectTo(Node target);
	Edge connectTo(String id, Node target);
	
	boolean hasEdgeTo(String nodeId);
	
	Date getStartDate();
	Date getEndDate();
}