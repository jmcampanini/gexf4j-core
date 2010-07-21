package com.ojn.gexf4j.core.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphMetadata;
import com.ojn.gexf4j.core.GraphMode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.Slice;
import com.ojn.gexf4j.core.data.Attribute;

public class GraphImpl implements Graph {

	private EdgeType defaultEdgeType = EdgeType.Directed;
	private GraphMode graphMode = GraphMode.Static;
	private List<Attribute> attributes = new ArrayList<Attribute>();
	private Map<String, Node> nodeMap = new HashMap<String, Node>();
	private GraphMetadata metadata = new GraphMetadataImpl();
	private Date startDate = null;
	private Date endDate = null;
	private List<Slice> slices = new ArrayList<Slice>();
	
	@Override
	public List<Attribute> getAttributes() {
		return attributes;
	}

	@Override
	public EdgeType getDefaultEdgeType() {
		return defaultEdgeType;
	}

	@Override
	public void setDefaultEdgeType(EdgeType edgeType) {
		if (edgeType == EdgeType.NotSet) {
			throw new IllegalArgumentException("Cannot set a graph's default EdgeType to NotSet.");
		}
		defaultEdgeType = edgeType;
	}
	
	@Override
	public GraphMode getGraphMode() {
		return graphMode;
	}

	@Override
	public void setGraphMode(GraphMode graphMode) {
		this.graphMode = graphMode;
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
	public GraphMetadata getMetadata() {
		return metadata;
	}

	@Override
	public Date getStartDate() {
		return startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public Date getEndDate() {
		return endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public List<Slice> getSlices() {
		return slices;
	}
}