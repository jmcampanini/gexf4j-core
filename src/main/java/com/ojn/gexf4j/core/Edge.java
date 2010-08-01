package com.ojn.gexf4j.core;

public interface Edge extends DynamicDatum<Edge> {

	String getId();
	
	Node getSource();
	
	Node getTarget();
	Edge setTarget(Node target);
	
	boolean hasLabel();
	Edge clearLabel();
	String getLabel();
	Edge setLabel(String label);
	
	boolean hasWeight();
	Edge clearWeight();
	float getWeight();
	Edge setWeight(float weight);
	
	EdgeType getEdgeType();
	Edge setEdgeType(EdgeType edgeType);
}