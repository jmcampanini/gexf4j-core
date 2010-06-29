package com.ojn.gexf4j.core;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.UUID;

import org.junit.Test;

public class GraphTest {

	@Test
	public void constructorValid() {
		new Graph();
	}
	
	@Test
	public void setDefaultEdgeType() {
		Graph g = new Graph();
		for (EdgeType edgeType : EdgeType.values()) {
			g.setDefaultEdgeType(edgeType);
			assertThat(g.getDefaultEdgeType(), is(equalTo(edgeType)));
		}
	}
	
	@Test
	public void getNodes() {
		Graph g = new Graph();
		assertThat(g.getNodes(), is(notNullValue()));
	}
	
	@Test
	public void getMode() {
		Graph g = new Graph();
		assertThat(g.getMode(), is(notNullValue()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hasNodeByIdNull() {
		Graph g = new Graph();
		g.hasNodeById(null);
	}
	
	@Test
	public void hasNodeById() {
		String id = UUID.randomUUID().toString();
		Node n = new Node(id);
		Graph g = new Graph();
		g.addNode(n);
		
		assertThat(g.hasNodeById(id), is(true));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getNodeByIdNull() {
		Graph g = new Graph();
		g.getNodeById(null);
	}
	
	@Test
	public void getNodeById() {
		String id = UUID.randomUUID().toString();
		Node n = new Node(id);
		Graph g = new Graph();
		g.addNode(n);
		Node nfound = g.getNodeById(id);
		
		assertThat(nfound, is(notNullValue()));
		assertThat(nfound.getId(), is(equalTo(id)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeNull() {
		Graph g = new Graph();
		Node n = null;
		g.addNode(n);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeIdNull() {
		Graph g = new Graph();
		String id = null;
		g.addNode(id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeIdBlank() {
		Graph g = new Graph();
		g.addNode("");
	}
	
	@Test
	public void addNodeValid() {
		Graph g = new Graph();
		String id = UUID.randomUUID().toString();
		Node n1 = g.addNode(id);
		Node n2 = new Node();
		
		g.addNode(n2);
		
		assertThat(n1.getId(), is(equalTo(id)));
		assertThat(g.hasNodeById(n2.getId()), is(equalTo(true)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeDuplicateNode() {
		Graph g = new Graph();
		String id = UUID.randomUUID().toString();
		Node n1 = new Node(id);
		Node n2 = new Node(id);
		
		g.addNode(n1);
		g.addNode(n2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeDuplicateId() {
		Graph g = new Graph();
		String id = UUID.randomUUID().toString();
		g.addNode(id);
		g.addNode(id);
	}
}