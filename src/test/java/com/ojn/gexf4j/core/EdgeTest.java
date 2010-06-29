package com.ojn.gexf4j.core;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Random;
import java.util.UUID;

import org.junit.Test;

public class EdgeTest {

	@Test
	public void construtorValid() {
		new Edge(new Node(), new Node());
		new Edge(UUID.randomUUID().toString(), new Node(), new Node());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorSourceNull() {
		new Edge(null, new Node());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorTargetNull() {
		new Edge(new Node(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdNull() {
		new Edge(null, new Node(), new Node());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdBlank() {
		new Edge("", new Node(), new Node());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdSourceNull() {
		new Edge(UUID.randomUUID().toString(), null, new Node());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdTargetNull() {
		new Edge(UUID.randomUUID().toString(), new Node(), null);
	}
	
	@Test
	public void getSource() {
		Node n1 = new Node();
		Node n2 = new Node();
		Edge e1 = new Edge(n1, n2);
		assertThat(e1.getSource(), is(equalTo(n1)));
	}
	
	@Test
	public void setTarget() {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		
		Edge e1 = new Edge(n1, n2);
		e1.setTarget(n3);
		assertThat(e1.getTarget(), is(equalTo(n3)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setTargetNull() {
		Edge e = new Edge(new Node(), new Node());
		e.setTarget(null);
	}
	
	@Test
	public void setLabel() {
		Edge e = new Edge(new Node(), new Node());
		String label = UUID.randomUUID().toString();
		e.setLabel(label);
		assertThat(e.getLabel(), is(equalTo(label)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setLabelNull() {
		Edge e = new Edge(new Node(), new Node());
		e.setLabel(null);
	}
	
	@Test
	public void setWeight() {
		Edge e = new Edge(new Node(), new Node());
		Random rnd = new Random();
		float weight = rnd.nextFloat();
		
		e.setWeight(weight);
		assertThat(e.getWeight(), is(equalTo(weight)));
	}
	
	@Test
	public void setEdgeType() {
		Edge e = new Edge(new Node(), new Node());
		
		for (EdgeType type : EdgeType.values()) {
			e.setType(type);
			assertThat(e.getType(), is(equalTo(type)));
		}
	}
}