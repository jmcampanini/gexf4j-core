package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.Slice;
import com.ojn.gexf4j.core.data.AttributeValue;

public class EdgeImpl implements Edge {

	private String id = "";
	private String label = "";
	private float weight = 1.0f;
	private EdgeType edgeType = EdgeType.NOTSET;
	private Node source = null;
	private Node target = null;
	private List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
	private Date startDate = null;
	private Date endDate = null;
	private List<Slice> slices = new ArrayList<Slice>();
	
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
		if (label == null) {
			throw new IllegalArgumentException("Label cannot be null.");
		}
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
		if (target == null) {
			throw new IllegalArgumentException("Target cannot be null.");
		}
		this.target = target;
	}

	@Override
	public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public List<Slice> getSlices() {
		return slices;
	}
}