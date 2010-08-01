package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

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

	private EdgeType defaultEdgeType = EdgeType.NOTSET;
	private GraphMode graphMode = GraphMode.NOTSET;
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
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
		checkArgument(!nodeMap.containsKey(id), "Node cannot be created with a duplicate ID.");
		
		Node rv = new NodeImpl(id);
		nodeMap.put(id, rv);
		return rv; 
	}

	@Override
	public Metadata getMetadata() {
		return metadata;
	}

	@Override
	public List<Slice> getSlices() {
		return slices;
	}

	@Override
	public boolean hasStartDate() {
		return (startDate != null);
	}
	
	@Override
	public Graph clearStartDate() {
		startDate = null;
		return this;
	}
	
	@Override
	public Date getStartDate() {
		checkState(hasStartDate(), "Start Data has not been set.");
		return startDate;
	}
	
	@Override
	public Graph setStartDate(Date startDate) {
		checkArgument(startDate != null, "Start Date cannot be set to null.");
		this.startDate = startDate;
		return this;
	}

	@Override
	public boolean hasEndDate() {
		return (endDate != null);
	}
	
	@Override
	public Graph clearEndDate() {
		endDate = null;
		return this;
	}
	
	@Override
	public Date getEndDate() {
		checkState(hasEndDate(), "End Data has not been set.");
		return endDate;
	}

	@Override
	public Graph setEndDate(Date endDate) {
		checkArgument(endDate != null, "End Date cannot be set to null.");
		this.endDate = endDate;
		return this;
	}
}