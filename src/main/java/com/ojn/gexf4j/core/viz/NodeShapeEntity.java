package com.ojn.gexf4j.core.viz;

public interface NodeShapeEntity {

	NodeShape getNodeShape();
	NodeShapeEntity setNodeShape(NodeShape shape);
	
	boolean hasUri();
	void clearUri();
	String getUri();
	NodeShapeEntity setUri(String uri);
}