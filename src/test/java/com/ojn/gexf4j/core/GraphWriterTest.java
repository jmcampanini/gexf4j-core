package com.ojn.gexf4j.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.ojn.gexf4j.core.Edge;
import com.ojn.gexf4j.core.Graph;
import com.ojn.gexf4j.core.GraphWriter;
import com.ojn.gexf4j.core.Node;

public class GraphWriterTest {

	@Test
	public void useCase() throws IOException {
		Graph g = new Graph();
		
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();

		Edge e1 = new Edge(n1, n2);
		Edge e2 = new Edge(n2, n3);
		
		n1.getEdges().add(e1);
		n2.getEdges().add(e2);
		
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		
		GraphWriter gw = new GraphWriter();
		
		File f = new File("textout.gexf");
		FileOutputStream fos = new FileOutputStream(f);
		
		gw.write(g, fos);
		
		fos.close();
	}
}