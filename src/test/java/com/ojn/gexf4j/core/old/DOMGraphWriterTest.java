package com.ojn.gexf4j.core.old;

import com.ojn.gexf4j.core.GraphWriter;

public class DOMGraphWriterTest extends GraphWriterTest {

	@Override
	protected String getFilename() {
		return "dom.gexf";
	}

	@Override
	protected GraphWriter newInstance() {
		return new DOMGraphWriter();
	}
}