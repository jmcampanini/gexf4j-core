package com.ojn.gexf4j.core;

import java.util.UUID;

public class Edge {

	private String id = "";
	private Node source = null;
	private Node target = null;
	private String label = "";
	private float weight = 1.0f;
	private EdgeType type = EdgeType.Directed;
	
	public Edge(Node source, Node target) {
		this(UUID.randomUUID().toString(), source, target);
	}
	
	public Edge(String id, Node source, Node target) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		} else if (id.trim() == "") {
			throw new IllegalArgumentException("ID cannot be blank.");
		} else if (source == null) {
			throw new IllegalArgumentException("Source Node cannot be null.");
		} else if (target == null) {
			throw new IllegalArgumentException("Target Node cannot be null.");
		}
		
		this.id = id;
		this.source = source;
		this.target = target;
	}

	public String getId() {
		return id;
	}

	public Node getSource() {
		return source;
	}
	
	public Node getTarget() {
		return target;
	}

	public void setTarget(Node target) {
		if (target == null) {
			throw new IllegalArgumentException("Source Node cannot be null.");
		}
		this.target = target;
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public EdgeType getType() {
		return type;
	}

	public void setType(EdgeType type) {
		this.type = type;
	}
}