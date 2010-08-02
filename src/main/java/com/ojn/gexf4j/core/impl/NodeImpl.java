package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeValue;
import com.ojn.gexf4j.core.dynamic.Slice;

public class NodeImpl implements Node {

	private String id = "";
	private String label = "";
	private List<AttributeValue> attributeValues = null;
	private List<Edge> edges = null;
	private Date startDate = null;
	private Date endDate = null;
	private List<Slice> slices = null;
	
	public NodeImpl() {
		this(UUID.randomUUID().toString());
	}
	
	public NodeImpl(String id) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		
		this.id = id;
		
		attributeValues = new ArrayList<AttributeValue>();
		edges = new ArrayList<Edge>();
		slices = new ArrayList<Slice>();
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
	public Node setLabel(String label) {
		checkArgument(label != null, "Label cannot be null.");
		this.label = label;
		return this;
	}
	
	@Override
	public Edge connectTo(Node target) {
		return connectTo(UUID.randomUUID().toString(), target);
	}

	@Override
	public Edge connectTo(String id, Node target) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(target != null, "Target Node cannot be null.");
				
		for (Edge e : edges) {
			if (e.getId().equals(id)) {
				throw new IllegalArgumentException("Cannot use duplicate Edge ID.");
			}
		}
		
		Edge rv = new EdgeImpl(id, this, target);
		edges.add(rv);
		return rv;
	}

	@Override
	public List<AttributeValue> getAttributeValues() {
		return attributeValues;
	}

	@Override
	public List<Edge> getEdges() {
		return edges;
	}

	@Override
	public boolean hasEdgeTo(String nodeId) {
		checkArgument(nodeId != null, "Node ID cannot be null.");
				
		for (Edge e : edges) {
			if (e.getTarget().getId().equals(nodeId)) {
				return true;
			}
		}
		return false;
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
	public Node clearStartDate() {
		startDate = null;
		return this;
	}
	
	@Override
	public Date getStartDate() {
		checkState(hasStartDate(), "Start Data has not been set.");
		return startDate;
	}
	
	@Override
	public Node setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be set to null.");
		this.startDate = startDate;
		return this;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}
	
	@Override
	public Node clearEndDate() {
		endDate = null;
		return this;
	}
	
	@Override
	public Date getEndDate() {
		checkState(hasEndDate(), "End Data has not been set.");
		return endDate;
	}

	@Override
	public Node setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be set to null.");
		this.endDate = endDate;
		return this;
	}
}