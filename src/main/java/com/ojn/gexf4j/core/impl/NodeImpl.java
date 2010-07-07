package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeValue;

public class NodeImpl implements Node {

	private String id = "";
	private String label = "";
	private List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
	private List<Edge> edges = new ArrayList<Edge>();
	
	NodeImpl(String id) {
		this.id = id;
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
	public Edge connectTo(Node target) {
		return connectTo(UUID.randomUUID().toString(), target);
	}

	@Override
	public Edge connectTo(String id, Node target) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
			
		} else if (id.trim().equals("")) {
			throw new IllegalArgumentException("ID cannot be blank.");
			
		} else if (target == null) {
			throw new IllegalArgumentException("Target cannot be null.");
		}
		
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
		if (nodeId == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		
		for (Edge e : edges) {
			if (e.getTarget().getId().equals(nodeId)) {
				return true;
			}
		}
		return false;
	}
}