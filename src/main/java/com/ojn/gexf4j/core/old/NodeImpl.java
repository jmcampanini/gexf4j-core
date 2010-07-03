package com.ojn.gexf4j.core.old;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NodeImpl {

	private String id = "";
	private String label = "";
	private List<EdgeImpl> edges = new ArrayList<EdgeImpl>();
	
	NodeImpl() {
		this(UUID.randomUUID().toString());
	}
	
	NodeImpl(String id) {
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

	public List<EdgeImpl> getEdges() {
		return edges;
	}
	
	public EdgeImpl connectTo(NodeImpl target) {
		if (target == null) {
			throw new IllegalArgumentException("Target Node cannot be null.");
		}
		EdgeImpl rv = new EdgeImpl(this, target);
		edges.add(rv);
		return rv;
	}
	
	public EdgeImpl connectTo(String id, NodeImpl target) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		if (target == null) {
			throw new IllegalArgumentException("Target Node cannot be null.");
		}
		EdgeImpl rv = new EdgeImpl(id, this, target);
		edges.add(rv);
		return rv;
	}
	
	public boolean hasEdgeTo(String nodeId) {
		for (EdgeImpl e : edges) {
			if (e.getTarget().getId().equals(nodeId)) {
				return true;
			}
		}
		return false;
	}
}