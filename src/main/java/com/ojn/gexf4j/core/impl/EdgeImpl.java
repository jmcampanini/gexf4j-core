package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.List;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeValue;

public class EdgeImpl implements Edge {

	private String id = "";
	private String label = "";
	private float weight = 1.0f;
	private EdgeType edgeType = EdgeType.NotSet;
	private Node source = null;
	private Node target = null;
	private List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();

	public EdgeImpl(String id, Node source, Node target) {
		this.id = id;
		this.source = source;
		this.target = target;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLabel() {
		return label;
	}
	
	@Override
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public float getWeight() {
		return weight;
	}
	
	@Override
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	@Override
	public EdgeType getEdgeType() {
		return edgeType;
	}

	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
	}

	@Override
	public Node getSource() {
		return source;
	}

	@Override
	public Node getTarget() {
		return target;
	}

	@Override
	public void setTarget(Node target) {
		this.target = target;
	}

	@Override
	public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}
}