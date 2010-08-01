package com.ojn.gexf4j.core;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.ojn.gexf4j.core.data.Attribute;
import com.ojn.gexf4j.core.data.AttributeClass;
import com.ojn.gexf4j.core.data.AttributeType;
import com.ojn.gexf4j.core.impl.data.AttributeImpl;

public abstract class GraphTest {

	protected abstract Graph newGraph();
	
	@Test
	public void defaultEdgeTypeValid() {
		Graph g = newGraph();
		for (EdgeType edgeType : EdgeType.values()) {
			g.setDefaultEdgeType(edgeType);
			assertThat(g.getDefaultEdgeType(), is(equalTo(edgeType)));
		}
	}
	
	@Test
	public void graphModeValid() {
		Graph g = newGraph();
		for (GraphMode gm : GraphMode.values()) {
			g.setGraphMode(gm);
			assertThat(g.getGraphMode(), is(equalTo(gm)));
		}
	}
	
	@Test
	public void createNode() {
		Graph g = newGraph();
		g.createNode();
	}
	
	@Test
	public void createNodeId() {
		Graph g = newGraph();
		String id = UUID.randomUUID().toString();
		Node n = g.createNode(id);
		
		assertThat(n, is(notNullValue()));
		assertThat(n.getId(), is(equalTo(id)));
		assertThat(g.getNodeMap().containsKey(id), is(true));
		assertThat(g.getNodeMap().get(id), is(equalTo(n)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdNull() {
		Graph g = newGraph();
		g.createNode(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdBlank() {
		Graph g = newGraph();
		g.createNode("   ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdDuplicate() {
		Graph g = newGraph();
		String id = UUID.randomUUID().toString();
		g.createNode(id);
		g.createNode(id);
	}
	
	@Test
	public void getAttributes() {
		Graph g = newGraph();
		Attribute attrib = new AttributeImpl(AttributeType.STRING, "test", AttributeClass.NODE);
		
		int a = g.getAttributes().size();
		g.getAttributes().add(attrib);
		int b = g.getAttributes().size();
		
		assertThat(b, is(equalTo(a+1)));
		assertThat(g.getAttributes().contains(attrib), is(true));
	}
	
	@Test
	public void getNodeMap() {
		Graph g = newGraph();
		
		String id1 = UUID.randomUUID().toString();
		String id2 = UUID.randomUUID().toString();
		
		Node n1 = g.createNode(id1);
		Node n2 = g.createNode(id2);
		Node n3 = g.createNode();
		
		Map<String, Node> map = g.getNodeMap();
		
		assertThat(map.size(), is(equalTo(3)));
		assertThat(map.containsKey(id1), is(true));
		assertThat(map.containsKey(id2), is(true));
		assertThat(map.containsValue(n1), is(true));
		assertThat(map.containsValue(n2), is(true));
		assertThat(map.containsValue(n3), is(true));
		assertThat(map.get(id1), is(equalTo(n1)));
		assertThat(map.get(id2), is(equalTo(n2)));
	}
}