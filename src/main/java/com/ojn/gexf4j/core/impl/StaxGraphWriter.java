package com.ojn.gexf4j.core.impl;

import java.io.IOException;
import java.io.OutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphWriter;
import com.ojn.gexf4j.core.impl.writer.GexfEntityWriter;

public class StaxGraphWriter implements GraphWriter {

	@Override
	public void writeToStream(Graph graph, OutputStream out) throws IOException {
		
		try {
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			XMLStreamWriter writer = outputFactory.createXMLStreamWriter(out);
			
			writer.writeStartDocument("1.0");
			
			new GexfEntityWriter(writer, graph);
			
			writer.writeEndDocument();
			
			writer.flush();
			writer.close();
			
		} catch (XMLStreamException e) {
			throw new IOException("XML Exception: " + e.getMessage(), e);
		}
	}
	
	/*
	private void writeAllSlices(XMLStreamWriter writer, List<Slice> slices) throws XMLStreamException {
		if (slices != null && slices.size() > 0) {
			writer.writeStartElement("slices");
			
			for (Slice s : slices) {
				writeSlice(writer, s);
			}
			
			writer.writeEndElement();
		}
	}
	
	private void writeSlice(XMLStreamWriter writer, Slice slice) throws XMLStreamException {
		writer.writeStartElement("slice");
		
		if (slice.getStartDate() != null) {
			writer.writeAttribute("start", sdf.format(slice.getStartDate()));
		}
		
		if (slice.getEndDate() != null) {
			writer.writeAttribute("end", sdf.format(slice.getEndDate()));
		}
		
		writer.writeEndElement();
	}
	
	private void writeAllAttributes(XMLStreamWriter writer, Graph graph) throws XMLStreamException {
		if (graph.getAttributes().size() > 0) {
			
			List<Attribute> attribNodes = new ArrayList<Attribute>();
			List<Attribute> attribEdges = new ArrayList<Attribute>();
			
			for (Attribute attrib : graph.getAttributes()) {
				switch (attrib.getAttributeClass()) {
					case EDGE:
						attribEdges.add(attrib);
						break;
						
					case NODE:
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
		
		if (edge.getStartDate() != null) {
			writer.writeAttribute("start", sdf.format(edge.getStartDate()));
		}
		
		if (edge.getEndDate() != null) {
			writer.writeAttribute("end", sdf.format(edge.getEndDate()));
		}
		
		if (edge.getEdgeType() != EdgeType.NOTSET) {
			writer.writeAttribute("type", edge.getEdgeType().toString().toLowerCase());
		}
		
		if (edge.getAttributeValues().size() > 0) {
			writer.writeStartElement("attvalues");
			
			for (AttributeValue av : edge.getAttributeValues()) {
				writeAttributeValue(writer, av);
			}
			
			writer.writeEndElement();
		}
		
		writeAllSlices(writer, edge.getSlices());
		
		writer.writeEndElement();
	}
	*/
}