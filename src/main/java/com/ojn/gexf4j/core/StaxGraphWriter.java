package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.stream.*;

public class StaxGraphWriter implements GraphWriter {

	@Override
	public void write(Graph graph, OutputStream out) throws IOException {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		
		try {
			XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
			
			writer.writeStartDocument("1.0");
			
			writeGraph(writer, graph);
			
			writer.writeEndDocument();
			
			writer.flush();
			writer.close();
			
		} catch (XMLStreamException e) {
			throw new IOException("XML Exception: " + e.getMessage(), e);
		}
	}
	
	private void writeGraph(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("gexf");
		writer.writeAttribute("version", "1.1");
		writer.writeAttribute("xmlns", "http://www.gexf.net/1.1draft");

		writeAllNodes(writer, graph);
		writeAllEdges(writer, graph);
		
		writer.writeEndElement();
	}
	
	private void writeAllNodes(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("nodes");
		
		for (Node n : graph.getNodes().values()) {
			writeNode(writer, n);
		}
		
		writer.writeEndElement();
	}
	
	private void writeNode(XMLStreamWriter writer, Node node) throws XMLStreamException {
		writer.writeStartElement("node");
		
		writer.writeAttribute("id", node.getId());
		writer.writeAttribute("label", node.getLabel());
		
		writer.writeEndElement();
	}
	
	private void writeAllEdges(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("edges");
		
		for (Node n : graph.getNodes().values()) {
			for (Edge e : n.getEdges()) {
				writeEdge(writer, e);
			}
		}
		
		writer.writeEndElement();
	}
	
	private void writeEdge(XMLStreamWriter writer, Edge edge) throws XMLStreamException {
		writer.writeStartElement("edge");
		
		writer.writeAttribute("id", edge.getId());
		writer.writeAttribute("label", edge.getLabel());
		writer.writeAttribute("source", edge.getSource().getId());
		writer.writeAttribute("target", edge.getTarget().getId());
		writer.writeAttribute("type", edge.getType().toString().toLowerCase());
		writer.writeAttribute("weight", edge.getWeight() + "");
		
		writer.writeEndElement();
	}
}