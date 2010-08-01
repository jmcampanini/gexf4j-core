package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Metadata;
import com.ojn.gexf4j.core.GraphMode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.Slice;
import com.ojn.gexf4j.core.data.Attribute;

public class GraphImpl implements Graph {

	private EdgeType defaultEdgeType = EdgeType.DIRECTED;
	private GraphMode graphMode = GraphMode.STATIC;
	private List<Attribute> attributes = null;
	private Map<String, Node> nodeMap = null;
	private Metadata metadata = null;
	private Date startDate = null;
	private Date endDate = null;
	private List<Slice> slices = null;
	
	public GraphImpl() {
		attributes = new ArrayList<Attribute>();
		nodeMap = new HashMap<String, Node>();
		metadata = new MetadataImpl();
		slices = new ArrayList<Slice>();
	}
	
	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}

	@Override
	public EdgeType getDefaultEdgeType() {
		return defaultEdgeType;
	}

	@Override
	public Graph setDefaultEdgeType(EdgeType edgeType) {
		if (edgeType == EdgeType.NOTSET) {
			throw new IllegalArgumentException("Cannot set a graph's default EdgeType to NotSet.");
		}
		defaultEdgeType = edgeType;
		return this;
	}
	
	@Override
	public GraphMode getGraphMode() {
		return graphMode;
	}

	@Override
	public Graph setGraphMode(GraphMode graphMode) {
		this.graphMode = graphMode;
		return this;
	}

	@Override
	public Map<String, Node> getNodeMap() {
		return nodeMap;
	}
	
	@Override
	public Node createNode() {
		return createNode(UUID.randomUUID().toString());
	}

	@Override
	public Node createNode(String id) {
		if (id == null) {
			throw new IllegalArgumentException("Node ID cannot be null.");
		} else if (id.trim().equals("")) {
			throw new IllegalArgumentException("Node ID cannot be blank.");
		} else if (nodeMap.containsKey(id)) {
			throw new IllegalArgumentException("Node cannot be created with a duplicate ID.");
		}
		Node rv = new NodeImpl(id);
		nodeMap.put(id, rv);
		return rv; 
	}

	@Override
	public Metadata getMetadata() {
		return metadata;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public Graph setStartDate(Date startDate) {
		this.startDate = startDate;
		return this;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public Graph setEndDate(Date endDate) {
		this.endDate = endDate;
		return this;
	}

	@Override
	public List<Slice> getSlices() {
		return slices;
	}
}