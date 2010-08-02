package com.ojn.gexf4j.core;

import java.util.Map;

import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.dynamic.Dynamic;
import com.ojn.gexf4j.core.dynamic.TimeType;

public interface Graph extends Dynamic<Graph> {

	EdgeType getDefaultEdgeType();
	Graph setDefaultEdgeType(EdgeType edgeType);
	
	IDType getIDType();
	Graph setIDType(IDType idtype);

	Mode getMode();
	Graph setMode(Mode graphMode);
	
	boolean hasTimeType();
	TimeType getTimeType();
	Graph setTimeType(TimeType timeType);
	
	AttributeList getNodeAttributes();
	AttributeList getEdgeAttributes();
	
	Node createNode();
	Node createNode(String id);
	
	Map<String, Node> getNodeMap();
}