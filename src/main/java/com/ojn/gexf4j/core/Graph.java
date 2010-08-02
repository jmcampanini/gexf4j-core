package com.ojn.gexf4j.core;

import java.util.List;
import java.util.Map;

import com.ojn.gexf4j.core.data.Attribute;

public interface Graph extends Dynamic<Graph> {

	Metadata getMetadata();
	
	EdgeType getDefaultEdgeType();
	Graph setDefaultEdgeType(EdgeType edgeType);

	Mode getMode();
	Graph setMode(Mode graphMode);
	
	Node createNode();
	Node createNode(String id);
	
	List<Attribute> getNodeAttributes();
	List<Attribute> getEdgeAttributes();
	
	Map<String, Node> getNodeMap();
}