package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.OutputStream;

import com.ojn.gexf4j.core.old.GraphImpl;

public interface GraphWriter {

	void writeToStream(GraphImpl graph, OutputStream out) throws IOException;
}