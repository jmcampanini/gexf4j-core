package com.ojn.gexf4j.core;

public interface Edge extends Dynamic<Edge>, Datum {

	String getId();
	
	String getLabel();
	Edge setLabel(String label);
	
	Node getSource();
	
	Node getTarget();
	Edge setTarget(Node target);
	
	float getWeight();
	Edge setWeight(float weight);
	
	EdgeType getEdgeType();
	Edge setEdgeType(EdgeType edgeType);
}