package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GraphWriter {

	public void write(Graph graph, OutputStream out) throws IOException {
		Document doc = new DocumentImpl();
		
		Element root = doc.createElement("gexf");
		root.setAttribute("version", "1.1");
		root.setAttribute("xmlns", "http://www.gexf.net/1.1draft");
		
		Element graphElement = doc.createElement("graph");
		graphElement.setAttribute("mode", graph.getMode().toString().toLowerCase());
		graphElement.setAttribute("defaultedgetype", graph.getDefaultEdgeType().toString().toLowerCase());
		
		Element nodeParent = doc.createElement("nodes");
		Element edgeParent = doc.createElement("edges");
		
		doc.appendChild(root);
		root.appendChild(graphElement);
		graphElement.appendChild(nodeParent);
		graphElement.appendChild(edgeParent);
		
		Element nodeElement = null;
		Element edgeElement = null;
		
		for (Node node : graph.getNodes().values()) {
			nodeElement = doc.createElement("node");
			nodeElement.setAttribute("id", node.getId());
			nodeElement.setAttribute("label", node.getLabel());
			nodeParent.appendChild(nodeElement);
			
			for (Edge edge : node.getEdges()) {
				edgeElement = doc.createElement("edge");
				edgeElement.setAttribute("id", edge.getId());
				edgeElement.setAttribute("label", edge.getLabel());
				edgeElement.setAttribute("source", edge.getSource().getId());
				edgeElement.setAttribute("target", edge.getTarget().getId());
				edgeElement.setAttribute("type", edge.getType().toString().toLowerCase());
				edgeElement.setAttribute("weight", edge.getWeight() + "");
				edgeParent.appendChild(edgeElement);
			}
		}
		
		OutputFormat of = new OutputFormat("XML", "UTF-8", true);
		of.setIndent(1);
		of.setIndenting(true);
		XMLSerializer serializer = new XMLSerializer(out, of);
		serializer.asDOMSerializer();
		serializer.serialize(doc);
	}
}