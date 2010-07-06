package com.ojn.gexf4j.core.impl;

import java.util.List;
import java.util.UUID;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeValue;

public class NodeImpl implements Node {

	private Graph graph = null;
	private String id = "";
	private String label = "";
	
	NodeImpl(Graph graph, String id) {
		this.graph = graph;
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
		return null;
	}

	@Override
	public List<AttributeValue> getAttributeValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Edge> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEdgeTo(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasEdgeTo(Node node) {
		// TODO Auto-generated method stub
		return false;
	}
}