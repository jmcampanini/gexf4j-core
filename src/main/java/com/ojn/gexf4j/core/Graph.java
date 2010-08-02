package com.ojn.gexf4j.core;

import com.ojn.gexf4j.core.data.AttributeList;
import com.ojn.gexf4j.core.dynamic.Dynamic;
import com.ojn.gexf4j.core.dynamic.TimeType;

public interface Graph extends Dynamic<Graph>, HasNodes {

	EdgeType getDefaultEdgeType();
	Graph setDefaultEdgeType(EdgeType edgeType);
	
	IDType getIDType();
	Graph setIDType(IDType idType);

	Mode getMode();
	Graph setMode(Mode graphMode);
	
	TimeType getTimeType();
	Graph setTimeType(TimeType timeType);
	
	AttributeList getNodeAttributes();
	AttributeList getEdgeAttributes();	
}