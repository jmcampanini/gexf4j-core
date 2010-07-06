package com.ojn.gexf4j.core;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.UUID;

import org.junit.Test;

public abstract class GraphTest {

	protected abstract Graph newGraph();
	
	@Test
	public void defaultEdgeTypeValid() {
		Graph g = newGraph();
		
		for (EdgeType edgeType : EdgeType.values()) {
			if (edgeType != EdgeType.NotSet) {
				g.setDefaultEdgeType(edgeType);
				assertThat(g.getDefaultEdgeType(), is(equalTo(edgeType)));
			}
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void defaultEdgeTypeNotSet() {
		Graph g = newGraph();
		g.setDefaultEdgeType(EdgeType.NotSet);
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
		Node n = g.createNode();
		
		assertThat(n, is(notNullValue()));
		assertThat(n.getId(), is(notNullValue()));
		assertThat(n.getId().trim(), is(equalTo("")));
	}
	
	@Test
	public void createNodeIdValid() {
		Graph g = newGraph();
		String id = UUID.randomUUID().toString();
		Node n = g.createNode(id);
		
		assertThat(n, is(notNullValue()));
		assertThat(n.getId(), is(equalTo(id)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdNull() {
		Graph g = newGraph();
		String id = null;
		g.createNode(id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdBlank() {
		Graph g = newGraph();
		String id = "   ";
		g.createNode(id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void createNodeIdDupe() {
		Graph g = newGraph();
		String id = UUID.randomUUID().toString();
		g.createNode(id);
		g.createNode(id);
	}
	
	// TODO: Add tests for Attributes
	// TODO: Add tests for NodeMap	
}