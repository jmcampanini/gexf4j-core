package com.ojn.gexf4j.core;

public interface Edge {

	String getId();
	
	String getLabel();
	void setLabel(String label);
	
	Node getSource();
	
	Node getTarget();
	void setTarget(Node target);
	
	float getWeight();
	void setWeight(float weight);
	
	EdgeType getEdgeType();
	void setEdgeType(EdgeType edgeType);
}