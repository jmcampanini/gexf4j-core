package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

public interface GraphWriter {

	void writeToStream(Graph graph, OutputStream out) throws IOException;
}