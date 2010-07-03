package com.ojn.gexf4j.core.old;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.UUID;

import org.junit.Test;


public class NodeTest {

	@Test(expected=IllegalArgumentException.class)
	public void constructorIdBlank() {
		new NodeImpl("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void constructorIdNull() {
		new NodeImpl(null);
	}
	
	@Test
	public void constructorIdValid() {
		String id = UUID.randomUUID().toString();
		NodeImpl n = new NodeImpl(id);
		assertThat(n.getId(), is(equalTo(id)));
	}
	
	@Test
	public void getLabel() {
		NodeImpl n = new NodeImpl();
		String label = UUID.randomUUID().toString();
		n.setLabel(label);
		assertThat(n.getLabel(), is(equalTo(label)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setLabelNull() {
		NodeImpl n = new NodeImpl();
		n.setLabel(null);
	}
	
	@Test
	public void getEdges() {
		NodeImpl n = new NodeImpl();
		assertThat(n.getEdges(), is(notNullValue()));
	}
	
	@Test
	public void connectToValid() {
		NodeImpl n = new NodeImpl();
		NodeImpl n2 = new NodeImpl();
		NodeImpl n3 = new NodeImpl();
		String id = UUID.randomUUID().toString();
		
		EdgeImpl e1 = n.connectTo(n2);
		EdgeImpl e2 = n.connectTo(id, n3);
		
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
		NodeImpl n = new NodeImpl();
		n.connectTo(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToTargetNull() {
		NodeImpl n = new NodeImpl();
		n.connectTo(UUID.randomUUID().toString(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void connectToIdNull() {
		NodeImpl n = new NodeImpl();
		n.connectTo(null, new NodeImpl());
	}
	
	@Test
	public void hasEdgeTo() {
		GraphImpl g = new GraphImpl();
		NodeImpl n1 = g.createNode();
		NodeImpl n2 = g.createNode();
		NodeImpl n3 = g.createNode();
		n1.connectTo(n2);
		
		assertThat(n1.hasEdgeTo(n2.getId()), is(true));
		assertThat(n1.hasEdgeTo(n3.getId()), is(false));
	}
}