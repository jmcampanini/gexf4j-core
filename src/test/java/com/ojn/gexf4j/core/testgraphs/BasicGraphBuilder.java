package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.GraphImpl;

public class BasicGraphBuilder implements GraphBuilder {
	
	@Override
	public String getSuffix() {
		return "basic";
	}
	
	@Override
	public String getXsdUrl() {
		return "http://gexf.net/1.1draft/gexf.xsd";
	}
	
	@Override
	public Graph buildGraph() {
		Graph g = new GraphImpl();
		
		Node n1 = g.createNode();
		Node n2 = g.createNode();
		Node n3 = g.createNode();
		
		n1.connectTo(n2);
		n1.connectTo(n3);
		
		return g;
	}
}