package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.dynamic.Slice;

public class EdgeImpl implements Edge {

	private String id = "";
	private String label = null;
	private float weight = Float.MIN_VALUE;
	private EdgeType edgeType = EdgeType.NOTSET;
	private Node source = null;
	private Node target = null;
	private List<AttributeValue> attributeValues = null;
	private Date startDate = null;
	private Date endDate = null;
	private List<Slice> slices = null;
	
	public EdgeImpl(String id, Node source, Node target) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(source != null, "Source Node cannot be null.");
		checkArgument(target != null, "Target Node cannot be null.");
		
		this.id = id;
		this.source = source;
		this.target = target;
		
		attributeValues = new ArrayList<AttributeValue>();
		slices = new ArrayList<Slice>();
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean hasLabel() {
		return (label != null);
	}
	
	@Override
	public Edge clearLabel() {
		label = null;
		return this;
	}
	
	@Override
	public String getLabel() {
		checkState(hasLabel(), "Label has not been set.");
		return label;
	}
	
	@Override
	public Edge setLabel(String label) {
		checkArgument(label != null, "Label cannot be set to null.");
		this.label = label;
		return this;
	}
	
	@Override
	public boolean hasWeight() {
		return (weight != Float.MIN_VALUE);
	}

	@Override
	public Edge clearWeight() {
		weight = Float.MIN_VALUE;
		return this;
	}
	
	@Override
	public float getWeight() {
		checkState(hasWeight(), "Weight has not been set.");
		return weight;
	}
	
	@Override
	public Edge setWeight(float weight) {
		this.weight = weight;
		return this;
	}
	
	@Override
	public EdgeType getEdgeType() {
		return edgeType;
	}

	@Override
	public Edge setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
		return this;
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
	public Edge setTarget(Node target) {
		checkArgument(target != null, "Target Node cannot be null.");
		this.target = target;
		return this;
	}

	@Override
	public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	@Override
	public List<Slice> getSlices() {
		return slices;
	}
	
	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}
	
	@Override
	public Edge clearStartDate() {
		startDate = null;
		return this;
	}
	
	@Override
	public Date getStartDate() {
		checkState(hasStartDate(), "Start Data has not been set.");
		return startDate;
	}
	
	@Override
	public Edge setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be set to null.");
		this.startDate = startDate;
		return this;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}
	
	@Override
	public Edge clearEndDate() {
		endDate = null;
		return this;
	}
	
	@Override
	public Date getEndDate() {
		checkState(hasEndDate(), "End Data has not been set.");
		return endDate;
	}

	@Override
	public Edge setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be set to null.");
		this.endDate = endDate;
		return this;
	}
}