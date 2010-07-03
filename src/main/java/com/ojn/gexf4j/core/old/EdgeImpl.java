package com.ojn.gexf4j.core.old;

import java.util.UUID;

import com.ojn.gexf4j.core.EdgeType;

public class EdgeImpl {

	private String id = "";
	private NodeImpl source = null;
	private NodeImpl target = null;
	private String label = "";
	private float weight = 1.0f;
	private EdgeType type = EdgeType.Directed;
	
	public EdgeImpl(NodeImpl source, NodeImpl target) {
		this(UUID.randomUUID().toString(), source, target);
	}
	
	public EdgeImpl(String id, NodeImpl source, NodeImpl target) {
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

	public NodeImpl getSource() {
		return source;
	}
	
	public NodeImpl getTarget() {
		return target;
	}

	public void setTarget(NodeImpl target) {
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