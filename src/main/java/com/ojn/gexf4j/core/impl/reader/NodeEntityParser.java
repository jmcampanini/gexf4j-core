package com.ojn.gexf4j.core.impl.reader;

import javax.xml.stream.XMLStreamReader;

import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.Node;
import com.ojn.gexf4j.core.impl.viz.ColorImpl;
import com.ojn.gexf4j.core.impl.viz.PositionImpl;

public class NodeEntityParser extends SliceableDatumEntityParser<Node> {
	private static final String ATTRIB_ID = "id";
	private static final String ATTRIB_LABEL = "label";
	private static final String ATTRIB_PID = "pid";
	private static final String ENTITY_NODES = "nodes";
	private static final String ENTITY_EDGES = "edges";
	private static final String ENTITY_PARENTS = "parents";
	private static final String ENTITY_COLOR = "color";
	private static final String ENTITY_POSITION = "position";
	private static final String ENTITY_SIZE = "size";
	private static final String ENTITY_SHAPE = "shape";
	
	private String id = "";
	private String label = "";
	private String pid = null;
	
	public NodeEntityParser(XMLStreamReader reader, Graph graph) {
		super(reader, null, graph);
		this.graph = graph;
		parse();
	}
		
	@Override
	protected void onAttribute(String name, String value) {
		super.onAttribute(name, value);
		
		if (ATTRIB_ID.equalsIgnoreCase(name)) {
			id = value;
			
		} else if (ATTRIB_LABEL.equalsIgnoreCase(name)) {
			label = value;
			
		} else if (ATTRIB_PID.equalsIgnoreCase(name)) {
			pid = value;
		}
	}
	
	@Override
	protected void onStartElement(String name, XMLStreamReader reader) {
		super.onStartElement(name, reader);
		
		if (ENTITY_NODES.equalsIgnoreCase(name)) {
			// TODO: Sub Nodes support
			
		} else if (ENTITY_EDGES.equalsIgnoreCase(name)) {
			// TODO: Sub Edges support
			
		} else if (ENTITY_PARENTS.equalsIgnoreCase(name)) {
			// TODO: Parents support
			
		} else if (ENTITY_COLOR.equalsIgnoreCase(name)) {
			ColorEntityParser cep = new ColorEntityParser(reader, new ColorImpl());
			entity.setColor(cep.getEntity());
			
		} else if (ENTITY_POSITION.equalsIgnoreCase(name)) {
			PositionEntityParser pep = new PositionEntityParser(reader, new PositionImpl());
			entity.setPosition(pep.getEntity());
			
		} else if (ENTITY_SIZE.equalsIgnoreCase(name)) {
		} else if (ENTITY_SHAPE.equalsIgnoreCase(name)) {
		}
	}

	@Override
	protected void buildEntity() {
		entity = graph.createNode(id);
		entity.setLabel(label);
		
		if (pid != null) {
			entity.setPID(pid);
		}
		
		super.buildEntity();
	}
}