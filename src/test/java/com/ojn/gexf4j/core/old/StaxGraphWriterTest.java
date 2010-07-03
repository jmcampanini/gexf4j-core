package com.ojn.gexf4j.core.old;

import com.ojn.gexf4j.core.GraphWriter;

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