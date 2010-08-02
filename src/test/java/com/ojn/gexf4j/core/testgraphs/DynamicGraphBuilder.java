package com.ojn.gexf4j.core.testgraphs;

import java.util.Date;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.EdgeImpl;
import com.ojn.gexf4j.core.impl.GraphImpl;
import com.ojn.gexf4j.core.impl.NodeImpl;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;
import com.ojn.gexf4j.core.impl.data.AttributeValueImpl;

public class DynamicGraphBuilder implements GraphBuilder {

	@Override
	public String getSuffix() {
		return "dynamic";
	}
	
	@Override
	public String getXsdUrl() {
		return "http://gexf.net/1.1draft/gexf.xsd";
	}
	
	@Override
	public Graph buildGraph() {
		GraphImpl rv = new GraphImpl();
		
		rv.setStartDate(new Date());
		
		Attribute attribUrl = new AttributeImpl(AttributeType.STRING, "0", AttributeClass.NODE);
		Attribute attribInDegree = new AttributeImpl(AttributeType.STRING, "1", AttributeClass.NODE);
		Attribute attribFrog = new AttributeImpl(AttributeType.STRING, "2", AttributeClass.NODE);
		
		attribUrl.setTitle("url");
		attribInDegree.setTitle("indegree");
		attribFrog.setTitle("frog");
		
		rv.getNodeAttributes().add(attribUrl);
		rv.getNodeAttributes().add(attribInDegree);
		rv.getNodeAttributes().add(attribFrog);
		
		NodeImpl nGephi = (NodeImpl) rv.createNode("0");
		nGephi.setLabel("Gephi");
		nGephi.getAttributeValues().add(attribUrl.createValue("http://gephi.org"));
		nGephi.getAttributeValues().add(attribInDegree.createValue("1"));
		
		nGephi.setStartDate(new Date());
		nGephi.setEndDate(new Date());
		
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
		
		AttributeValueImpl avi = (AttributeValueImpl) nBar.getAttributeValues().get(0);
		avi.setStartDate(new Date());
		avi.setEndDate(new Date());
		
		nGephi.connectTo("0", nWebatlas);
		nGephi.connectTo("1", nRTGI);
		nWebatlas.connectTo("2", nGephi);
		nRTGI.connectTo("3", nWebatlas);
		nGephi.connectTo("4", nBar);
		
		nGephi.getEdges().get(0).getAttributeValues().add(attribFrog.createValue("true"));
		EdgeImpl ei = (EdgeImpl) nGephi.getEdges().get(0);
		ei.setStartDate(new Date());
		ei.setEndDate(new Date());
		
		return rv;
	}
}