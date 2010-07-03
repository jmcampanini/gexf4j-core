package com.ojn.gexf4j.core;

import java.util.List;
import java.util.Map;

public interface Graph {

	Map<String, Node> getNodeMap();
	
	EdgeType getDefaultEdgeType();
	void setDefaultEdgeType(EdgeType edgeType);
	
	GraphMode getGraphMode();
	void setGraphMode(GraphMode graphMode);
	
	Node createNode();
	Node createNode(String id);
	
	List<Attribute> getAttributes();
}