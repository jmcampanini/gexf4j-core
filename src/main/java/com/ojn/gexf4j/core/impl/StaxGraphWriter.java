package com.ojn.gexf4j.core.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.EdgeType;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphMetadata;
import com.ojn.gexf4j.core.GraphWriter;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeValue;

public class StaxGraphWriter implements GraphWriter {

	@Override
	public void writeToStream(Graph graph, OutputStream out) throws IOException {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		
		try {
			XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
			
			writer.writeStartDocument("1.0");
			
			writeGexf(writer, graph);
			
			writer.writeEndDocument();
			
			writer.flush();
			writer.close();
			
		} catch (XMLStreamException e) {
			throw new IOException("XML Exception: " + e.getMessage(), e);
		}
	}
	
	private void writeGexf(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("gexf");
		writer.writeAttribute("version", "1.1");
		writer.writeAttribute("xmlns", "http://www.gexf.net/1.1draft");

		writeMeta(writer, graph);
		writeGraph(writer, graph);
		
		writer.writeEndElement();
	}
	
	private void writeMeta(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GraphMetadata meta = graph.getMetadata();
		
		if (meta != null) {
			writer.writeStartElement("meta");
			
			if (meta.getLastModified() != null) {
				writer.writeAttribute("lastmodifieddate", sdf.format(graph.getMetadata().getLastModified()));
			}
			
			if (meta.getCreator() != null && !meta.getCreator().isEmpty()) {
				writer.writeStartElement("creator");
				writer.writeCharacters(meta.getCreator());
				writer.writeEndElement();
			}
			
			if (meta.getDescription() != null && !meta.getDescription().isEmpty()) {
				writer.writeStartElement("description");
				writer.writeCharacters(meta.getDescription());
				writer.writeEndElement();
			}
			
			if (meta.getKeywords() != null && meta.getKeywords().size() > 0) {
				writer.writeStartElement("keywords");

				String keywords = "";
				for (String k : meta.getKeywords()) {
					keywords += k + ", ";
				}
				
				keywords = keywords.substring(0, keywords.length() - 2);

				writer.writeCharacters(keywords);
				writer.writeEndElement();
			}
			
			writer.writeEndElement();
		}
	}
	
	private void writeGraph(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("graph");
		writer.writeAttribute("defaultedgetype", graph.getDefaultEdgeType().toString().toLowerCase());
		writer.writeAttribute("mode", graph.getGraphMode().toString().toLowerCase());
		
		writeAllAttributes(writer, graph);
		writeAllNodes(writer, graph);
		writeAllEdges(writer, graph);
		
		writer.writeEndElement();
	}
	
	private void writeAllAttributes(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		if (graph.getAttributes().size() > 0) {
			
			List<Attribute> attribNodes = new ArrayList<Attribute>();
			List<Attribute> attribEdges = new ArrayList<Attribute>();
			
			for (Attribute attrib : graph.getAttributes()) {
				switch (attrib.getAttributeClass()) {
					case Edge:
						attribEdges.add(attrib);
						break;
						
					case Node:
						attribNodes.add(attrib);
						break;
				}
			}
			
			// write node attributes
			if (attribNodes.size() > 0) {
				writer.writeStartElement("attributes");
				writer.writeAttribute("class", "node");
				
				for (Attribute attrib : attribNodes) {
					writeAttribute(writer, attrib);
				}		
				
				writer.writeEndElement();
			}
			
			// write edge attributes
			if (attribNodes.size() > 0) {
				writer.writeStartElement("attributes");
				writer.writeAttribute("class", "edge");
				
				for (Attribute attrib : attribEdges) {
					writeAttribute(writer, attrib);
				}		
				
				writer.writeEndElement();
			}
		}
	}
	
	private void writeAttribute(XMLStreamWriter writer, Attribute attrib) throws XMLStreamException {
		writer.writeStartElement("attribute");
		writer.writeAttribute("id", attrib.getId());
		writer.writeAttribute("title", attrib.getTitle());
		writer.writeAttribute("type", attrib.getAttributeType().toString().toLowerCase());
		
		if (attrib.getDefaultValue() != null) {
			writer.writeStartElement("default");
			writer.writeCharacters(attrib.getDefaultValue());
			writer.writeEndElement();
		}
		
		writer.writeEndElement();
	}
	
	private void writeAllNodes(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("nodes");
		
		for (Node n : graph.getNodeMap().values()) {
			writeNode(writer, n);
		}
		
		writer.writeEndElement();
	}
	
	private void writeNode(XMLStreamWriter writer, Node node) throws XMLStreamException {
		writer.writeStartElement("node");
		
		writer.writeAttribute("id", node.getId());
		writer.writeAttribute("label", node.getLabel());
		
		if (node.getAttributeValues().size() > 0) {
			writer.writeStartElement("attvalues");
			
			for (AttributeValue av : node.getAttributeValues()) {
				writeAttributeValue(writer, av);
			}
			
			writer.writeEndElement();
		}
		
		writer.writeEndElement();
	}

	private void writeAttributeValue(XMLStreamWriter writer, AttributeValue av) throws XMLStreamException {
		writer.writeStartElement("attvalue");
		writer.writeAttribute("for", av.valueFor().getId());
		writer.writeAttribute("value", av.getValue());
		writer.writeEndElement();
	}
	
	private void writeAllEdges(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		writer.writeStartElement("edges");
		
		for (Node n : graph.getNodeMap().values()) {
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
		writer.writeAttribute("weight", edge.getWeight() + "");
		
		if (edge.getEdgeType() != EdgeType.NotSet) {
			writer.writeAttribute("type", edge.getEdgeType().toString().toLowerCase());
		}
		
		writer.writeEndElement();
	}
}