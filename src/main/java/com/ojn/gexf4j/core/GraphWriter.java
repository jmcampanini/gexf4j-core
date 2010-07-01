package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

public interface GraphWriter {

	void write(Graph graph, OutputStream out) throws IOException;
}