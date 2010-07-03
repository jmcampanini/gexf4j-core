package com.ojn.gexf4j.core;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Graph {

	private Map<String, Node> nodeMap = new HashMap<String, Node>();
	private EdgeType defaultEdgeType = EdgeType.Directed;
	private GraphMode mode = GraphMode.Static;
	
	public Graph() {
		
	}

	public EdgeType getDefaultEdgeType() {
		return defaultEdgeType;
	}

	public void setDefaultEdgeType(EdgeType defaultEdgeType) {
		this.defaultEdgeType = defaultEdgeType;
	}

	public Map<String, Node> getNodes() {
		return nodeMap;
	}

	public Node createNode() {
		return createNode(UUID.randomUUID().toString());
	}
	
	public Node createNode(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		} else if (id.trim() == "") {
			throw new IllegalArgumentException("ID cannot be blank.");
		} else if (nodeMap.containsKey(id)) {
			throw new IllegalArgumentException("ID already exists.");
		}
		Node node = new Node(id);
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

	public Node getNodeById(String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be null.");
		}
		return nodeMap.get(id);
	}
}