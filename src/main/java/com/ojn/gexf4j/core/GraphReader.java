package com.ojn.gexf4j.core;

import java.io.IOException;
import java.io.InputStream;

public interface GraphReader {

	Graph readFromStream(InputStream in) throws IOException;
}