package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.IDType;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.dynamic.TimeType;
import com.ojn.gexf4j.core.impl.dynamic.DynamicBase;

public class GraphImpl extends DynamicBase<Graph> implements Graph {

	private EdgeType edgeType = EdgeType.UNDIRECTED;
	private List<AttributeList> attributeLists = null;
	private IDType idType = IDType.STRING;
	private Mode mode = Mode.STATIC;
	private List<Node> nodes = null;
	private TimeType timeType = TimeType.DATE;
	
	public GraphImpl() {
		attributeLists = new ArrayList<AttributeList>();
		nodes = new ArrayList<Node>();
	}
	
	@Override
	protected Graph getSelf() {
		return this;
	}

	@Override
	public EdgeType getDefaultEdgeType() {
		return edgeType;
	}

	@Override
	public IDType getIDType() {
		return idType;
	}

	@Override
	public Mode getMode() {
		return mode;
	}

	@Override
	public TimeType getTimeType() {
		return timeType;
	}

	@Override
	public Graph setDefaultEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
		return this;
	}

	@Override
	public Graph setIDType(IDType idType) {
		this.idType = idType;
		return this;
	}

	@Override
	public Graph setMode(Mode graphMode) {
		this.mode = graphMode;
		return this;
	}

	@Override
	public Graph setTimeType(TimeType timeType) {
		this.timeType = timeType;
		return this;
	}
 
	@Override
	public Node createNode() {
		return createNode(UUID.randomUUID().toString());
	}

	@Override
	public Node createNode(String id) {
		checkArgument(id != null, "ID cannot be null.");
		checkArgument(!id.trim().isEmpty(), "ID cannot be empty or blank.");
				
		Node rv = new NodeImpl(id);
		nodes.add(rv);
		return rv;
	}

	@Override
	public List<Edge> getAllEdges() {
		List<Edge> rv = new ArrayList<Edge>();
		
		for (Node n : nodes) {
			rv.addAll(n.getEdges());
			rv.addAll(n.getAllEdges());
		}
		
		return rv;
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public List<AttributeList> getAttributeLists() {
		return attributeLists;
	}

	@Override
	public Graph setStartDate(int startDate) {
		// TODO Auto-generated method stub
		this.startDateint = startDate;
		return this;
	}

	@Override
	public Graph setEndDate(int endDate) {
		this.endDateint = endDate;
		return this;
	}
}