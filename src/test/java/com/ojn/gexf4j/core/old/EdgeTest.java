package com.ojn.gexf4j.core.old;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import com.ojn.gexf4j.core.EdgeType;

public class EdgeTest {

	@Test
	public void construtorValid() {
		new EdgeImpl(new NodeImpl(), new NodeImpl());
		new EdgeImpl(UUID.randomUUID().toString(), new NodeImpl(), new NodeImpl());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorSourceNull() {
		new EdgeImpl(null, new NodeImpl());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorTargetNull() {
		new EdgeImpl(new NodeImpl(), null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdNull() {
		new EdgeImpl(null, new NodeImpl(), new NodeImpl());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdBlank() {
		new EdgeImpl("", new NodeImpl(), new NodeImpl());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdSourceNull() {
		new EdgeImpl(UUID.randomUUID().toString(), null, new NodeImpl());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void construtorIdTargetNull() {
		new EdgeImpl(UUID.randomUUID().toString(), new NodeImpl(), null);
	}
	
	@Test
	public void getSource() {
		NodeImpl n1 = new NodeImpl();
		NodeImpl n2 = new NodeImpl();
		EdgeImpl e1 = new EdgeImpl(n1, n2);
		assertThat(e1.getSource(), is(equalTo(n1)));
	}
	
	@Test
	public void setTarget() {
		NodeImpl n1 = new NodeImpl();
		NodeImpl n2 = new NodeImpl();
		NodeImpl n3 = new NodeImpl();
		
		EdgeImpl e1 = new EdgeImpl(n1, n2);
		e1.setTarget(n3);
		assertThat(e1.getTarget(), is(equalTo(n3)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setTargetNull() {
		EdgeImpl e = new EdgeImpl(new NodeImpl(), new NodeImpl());
		e.setTarget(null);
	}
	
	@Test
	public void setLabel() {
		EdgeImpl e = new EdgeImpl(new NodeImpl(), new NodeImpl());
		String label = UUID.randomUUID().toString();
		e.setLabel(label);
		assertThat(e.getLabel(), is(equalTo(label)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void setLabelNull() {
		EdgeImpl e = new EdgeImpl(new NodeImpl(), new NodeImpl());
		e.setLabel(null);
	}
	
	@Test
	public void setWeight() {
		EdgeImpl e = new EdgeImpl(new NodeImpl(), new NodeImpl());
		Random rnd = new Random();
		float weight = rnd.nextFloat();
		
		e.setWeight(weight);
		assertThat(e.getWeight(), is(equalTo(weight)));
	}
	
	@Test
	public void setEdgeType() {
		EdgeImpl e = new EdgeImpl(new NodeImpl(), new NodeImpl());
		
		for (EdgeType type : EdgeType.values()) {
			e.setType(type);
			assertThat(e.getType(), is(equalTo(type)));
		}
	}
}