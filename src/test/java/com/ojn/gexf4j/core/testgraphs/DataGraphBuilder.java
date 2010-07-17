package com.ojn.gexf4j.core.testgraphs;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.GraphImpl;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;

public class DataGraphBuilder implements GraphBuilder {
	@Override
	public String getSuffix() {
		return "data";
	}
	
	@Override
	public String getXsdUrl() {
		return "http://gexf.net/1.1draft/gexf.xsd";
	}
	
	@Override
	public Graph buildGraph() {
		Graph rv = new GraphImpl();
		
		Attribute attribUrl = new AttributeImpl(AttributeType.String, "0", AttributeClass.Node);
		Attribute attribInDegree = new AttributeImpl(AttributeType.String, "1", AttributeClass.Node);
		Attribute attribFrog = new AttributeImpl(AttributeType.String, "2", AttributeClass.Node);
		
		attribUrl.setTitle("url");
		attribInDegree.setTitle("indegree");
		attribFrog.setTitle("frog");
		
		rv.getAttributes().add(attribUrl);
		rv.getAttributes().add(attribInDegree);
		rv.getAttributes().add(attribFrog);
		
		Node nGephi = rv.createNode("0");
		nGephi.setLabel("Gephi");
		nGephi.getAttributeValues().add(attribUrl.createValue("http://gephi.org"));
		nGephi.getAttributeValues().add(attribInDegree.createValue("1"));
		
		Node nWebatlas = rv.createNode("1");
		nWebatlas.setLabel("Webatlas");
		nWebatlas.getAttributeValues().add(attribUrl.createValue("http://webatlas.fr"));
		nWebatlas.getAttributeValues().add(attribInDegree.createValue("2"));
		
		Node nRTGI = rv.createNode("2");
		nRTGI.setLabel("RTGI");
		nRTGI.getAttributeValues().add(attribUrl.createValue("http://rtgi.fr"));
		nRTGI.getAttributeValues().add(attribInDegree.createValue("1"));
		
		Node nBar = rv.createNode("3");
		nBar.setLabel("BarabasiLab");
		nBar.getAttributeValues().add(attribUrl.createValue("http://barabasilab.com"));
		nBar.getAttributeValues().add(attribInDegree.createValue("1"));
		nBar.getAttributeValues().add(attribFrog.createValue("false"));
		
		nGephi.connectTo("0", nWebatlas);
		nGephi.connectTo("1", nRTGI);
		nWebatlas.connectTo("2", nGephi);
		nRTGI.connectTo("3", nWebatlas);
		nGephi.connectTo("4", nBar);
		
		return rv;
	}
}