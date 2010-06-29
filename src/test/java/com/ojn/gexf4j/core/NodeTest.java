package com.ojn.gexf4j.core;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.UUID;

import org.junit.Test;

public class NodeTest {

	@Test(expected=IllegalArgumentException.class)
	public void constructorIdBlank() {
		new Node("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructorIdNull() {
		new Node(null);
	}
	
	@Test
	public void constructorIdValid() {
		String id = UUID.randomUUID().toString();
		Node n = new Node(id);
		assertThat(n.getId(), is(equalTo(id)));
	}
	
	@Test
	public void getLabel() {
		Node n = new Node();
		String label = UUID.randomUUID().toString();
		n.setLabel(label);
		assertThat(n.getLabel(), is(equalTo(label)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setLabelNull() {
		Node n = new Node();
		n.setLabel(null);
	}
	
	@Test
	public void getEdges() {
		Node n = new Node();
		assertThat(n.getEdges(), is(notNullValue()));
	}
	
	@Test
	public void connectToValid() {
		Node n = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		String id = UUID.randomUUID().toString();
		
		Edge e1 = n.connectTo(n2);
		Edge e2 = n.connectTo(id, n3);
		
		assertThat(n.getEdges().size(), is(equalTo(2)));
		assertThat(n.getEdges().contains(e1), is(true));
		assertThat(n.getEdges().contains(e2), is(true));
		assertThat(e1.getSource(), is(equalTo(n)));
		assertThat(e2.getSource(), is(equalTo(n)));
		assertThat(e1.getTarget(), is(equalTo(n2)));
		assertThat(e2.getTarget(), is(equalTo(n3)));
		assertThat(e2.getId(), is(equalTo(id)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdTargetNull() {
		Node n = new Node();
		n.connectTo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToTargetNull() {
		Node n = new Node();
		n.connectTo(UUID.randomUUID().toString(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdNull() {
		Node n = new Node();
		n.connectTo(null, new Node());
	}
}