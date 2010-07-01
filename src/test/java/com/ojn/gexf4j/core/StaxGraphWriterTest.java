package com.ojn.gexf4j.core;

public class StaxGraphWriterTest extends GraphWriterTest {

	@Override
	protected String getFilename() {
		return "stax.gexf";
	}

	@Override
	protected GraphWriter newInstance() {
		return new StaxGraphWriter();
	}
}