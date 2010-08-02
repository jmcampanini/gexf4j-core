package com.ojn.gexf4j.core;

import java.util.List;
import java.util.Map;

import com.ojn.gexf4j.core.phylogenic.Parent;
import com.ojn.gexf4j.core.viz.Color;
import com.ojn.gexf4j.core.viz.NodeShapeEntity;
import com.ojn.gexf4j.core.viz.Position;

public interface Node extends SlicableDatum<Node> {

	String getId();
	
	String getLabel();
	Node setLabel(String label);
	
	List<Edge> getEdges();
	
	Edge connectTo(Node target);
	Edge connectTo(String id, Node target);
	
	boolean hasEdgeTo(String nodeId);
	
	boolean hasColor();
	Node clearColor();
	Color getColor();
	Node setColor(Color color);
	
	boolean hasPosition();
	Node clearPosition();
	Position getPosition();
	Node setPosition(Position position);
	
	boolean hasSize();
	Node clearSize();
	float getSize();
	Node setSize(float size);
	
	boolean hasShape();
	Node clearShape();
	NodeShapeEntity getShapeEntity();
	
	List<Parent> getParents();

	Map<String, Node> getSubNodeMap();
	List<Edge> getSubEdges();
	
	boolean hasPID();
	Node clearPID();
	String getPID();
	Node setPID(String pid);
}