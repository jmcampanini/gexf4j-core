package com.ojn.gexf4j.core;

import java.util.Map;

public interface HasNodes {
	
	Node createNode();
	Node createNode(String id);
	
	Map<String, Node> getNodeMap();
}