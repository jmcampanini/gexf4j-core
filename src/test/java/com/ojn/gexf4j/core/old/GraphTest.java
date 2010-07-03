package com.ojn.gexf4j.core.old;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.UUID;

import org.junit.Test;

import com.ojn.gexf4j.core.EdgeType;

public class GraphTest {

	@Test
	public void constructorValid() {
		new GraphImpl();
	}
	
	@Test
	public void setDefaultEdgeType() {
		GraphImpl g = new GraphImpl();
		for (EdgeType edgeType : EdgeType.values()) {
			g.setDefaultEdgeType(edgeType);
			assertThat(g.getDefaultEdgeType(), is(equalTo(edgeType)));
		}
	}
	
	@Test
	public void getNodes() {
		GraphImpl g = new GraphImpl();
		assertThat(g.getNodes(), is(notNullValue()));
	}
	
	@Test
	public void getMode() {
		GraphImpl g = new GraphImpl();
		assertThat(g.getMode(), is(notNullValue()));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void hasNodeByIdNull() {
		GraphImpl g = new GraphImpl();
		g.hasNodeById(null);
	}
	
	@Test
	public void hasNodeById() {
		String id = UUID.randomUUID().toString();
		GraphImpl g = new GraphImpl();
		g.createNode(id);
		
		assertThat(g.hasNodeById(id), is(true));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getNodeByIdNull() {
		GraphImpl g = new GraphImpl();
		g.getNodeById(null);
	}
	
	@Test
	public void getNodeById() {
		String id = UUID.randomUUID().toString();
		GraphImpl g = new GraphImpl();
		g.createNode(id);
		NodeImpl nfound = g.getNodeById(id);
		
		assertThat(nfound, is(notNullValue()));
		assertThat(nfound.getId(), is(equalTo(id)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeIdNull() {
		GraphImpl g = new GraphImpl();
		String id = null;
		g.createNode(id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeIdBlank() {
		GraphImpl g = new GraphImpl();
		g.createNode("");
	}
	
	@Test
	public void addNodeValid() {
		GraphImpl g = new GraphImpl();
		String id = UUID.randomUUID().toString();
		NodeImpl n1 = g.createNode(id);
		NodeImpl n2 = g.createNode();
		
		assertThat(n1.getId(), is(equalTo(id)));
		assertThat(g.hasNodeById(n2.getId()), is(equalTo(true)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void addNodeDuplicateId() {
		GraphImpl g = new GraphImpl();
		String id = UUID.randomUUID().toString();
		g.createNode(id);
		g.createNode(id);
	}
}