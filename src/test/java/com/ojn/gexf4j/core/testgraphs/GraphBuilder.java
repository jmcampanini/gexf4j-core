package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Graph;

public interface GraphBuilder {
	
	Graph buildGraph();
	String getSuffix();
	String getXsdUrl();
}