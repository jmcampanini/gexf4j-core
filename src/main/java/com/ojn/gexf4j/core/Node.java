package com.ojn.gexf4j.core;

import java.util.List;

public interface Node extends Dynamic<Node>, Datum {

	String getId();
	
	String getLabel();
	Node setLabel(String label);
	
	List<Edge> getEdges();
	
	Edge connectTo(Node target);
	Edge connectTo(String id, Node target);
	
	boolean hasEdgeTo(String nodeId);
}