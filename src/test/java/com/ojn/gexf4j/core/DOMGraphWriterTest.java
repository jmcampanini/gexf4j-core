package com.ojn.gexf4j.core;

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