package com.ojn.gexf4j.core.testgraphs;

import java.util.Date;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.GraphImpl;
import com.ojn.gexf4j.core.impl.MetadataImpl;

public class MetaDataGraphBuilder implements GraphBuilder {

	@Override
	public String getSuffix() {
		return "meta";
	}
	
	@Override
	public String getXsdUrl() {
		return "http://gexf.net/1.1draft/gexf.xsd";
	}
	
	@Override
	public Graph buildGraph() {
		Graph g = new GraphImpl();
		
		MetadataImpl meta = (MetadataImpl) g.getMetadata();
		
		meta.setCreator("creatorString");
		meta.setDescription("my description goes here");
		meta.setLastModified(new Date());
		meta.getKeywords().add("keyword1");
		meta.getKeywords().add("keyword2");
		
		Node n1 = g.createNode();
		Node n2 = g.createNode();
		Node n3 = g.createNode();
		
		n1.connectTo(n2);
		n1.connectTo(n3);
		
		return g;
	}
}