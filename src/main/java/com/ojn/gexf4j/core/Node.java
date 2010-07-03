package com.ojn.gexf4j.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Node {

	private String id = "";
	private String label = "";
	private List<Edge> edges = new ArrayList<Edge>();
	
	Node() {
		this(UUID.randomUUID().toString());
	}
	
	Node(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Label cannot be null.");
		} else if (id.trim() == "") {
			throw new IllegalArgumentException("Label cannot be blank.");
		}
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		if (label == null) {
			throw new IllegalArgumentException("Label cannot be null.");
		}
		this.label = label;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
	public Edge connectTo(Node target) {
		if (target == null) {
			throw new IllegalArgumentException("Target Node cannot be null.");
		}
		Edge rv = new Edge(this, target);
		edges.add(rv);
		return rv;
	}
	
	public Edge connectTo(String id, Node target) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		if (target == null) {
			throw new IllegalArgumentException("Target Node cannot be null.");
		}
		Edge rv = new Edge(id, this, target);
		edges.add(rv);
		return rv;
	}
	
	public boolean hasEdgeTo(String nodeId) {
		for (Edge e : edges) {
			if (e.getTarget().getId().equals(nodeId)) {
				return true;
			}
		}
		return false;
	}
}