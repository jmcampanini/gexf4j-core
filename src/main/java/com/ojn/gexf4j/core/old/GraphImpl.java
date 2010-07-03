package com.ojn.gexf4j.core.old;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.GraphMode;

public class GraphImpl {

	private Map<String, NodeImpl> nodeMap = new HashMap<String, NodeImpl>();
	private EdgeType defaultEdgeType = EdgeType.Directed;
	private GraphMode mode = GraphMode.Static;
	
	public GraphImpl() {
		
	}

	public EdgeType getDefaultEdgeType() {
		return defaultEdgeType;
	}

	public void setDefaultEdgeType(EdgeType defaultEdgeType) {
		this.defaultEdgeType = defaultEdgeType;
	}

	public Map<String, NodeImpl> getNodes() {
		return nodeMap;
	}

	public NodeImpl createNode() {
		return createNode(UUID.randomUUID().toString());
	}
	
	public NodeImpl createNode(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		} else if (id.trim() == "") {
			throw new IllegalArgumentException("ID cannot be blank.");
		} else if (nodeMap.containsKey(id)) {
			throw new IllegalArgumentException("ID already exists.");
		}
		NodeImpl node = new NodeImpl(id);
		nodeMap.put(id, node);
		return node;
	}
	
	public GraphMode getMode() {
		return mode;
	}

	public boolean hasNodeById(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		return nodeMap.containsKey(id);
	}

	public NodeImpl getNodeById(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		return nodeMap.get(id);
	}
}