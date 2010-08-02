package com.ojn.gexf4j.core.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.IDType;
import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.dynamic.TimeType;
import com.ojn.gexf4j.core.impl.data.AttributeListImpl;
import com.ojn.gexf4j.core.impl.dynamic.DynamicBase;

public class GraphImpl extends DynamicBase<Graph> implements Graph {

	private EdgeType edgeType = EdgeType.UNDIRECTED;
	private AttributeList edgeAttributeList = null;
	private AttributeList nodeAttributeList = null;
	private IDType idType = IDType.STRING;
	private Mode mode = Mode.STATIC;
	private Map<String, Node> nodeMap = null;
	private TimeType timeType = TimeType.DATE;
	
	public GraphImpl() {
		edgeAttributeList = new AttributeListImpl(AttributeClass.EDGE);
		nodeAttributeList = new AttributeListImpl(AttributeClass.NODE);
		nodeMap = new HashMap<String, Node>();
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
	public AttributeList getEdgeAttributes() {
		return edgeAttributeList;
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
	public AttributeList getNodeAttributes() {
		return nodeAttributeList;
	}

	@Override
	public Map<String, Node> getNodeMap() {
		return nodeMap;
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
		checkArgument(!nodeMap.containsKey(id), "Cannot use a duplicate ID.");
		
		Node rv = new NodeImpl(id);
		nodeMap.put(id, rv);
		return rv;
	}
}