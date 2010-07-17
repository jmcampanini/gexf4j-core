package com.ojn.gexf4j.core.impl;

import com.ojn.gexf4j.core.GraphWriter;
import com.ojn.gexf4j.core.GraphWriterTest;
import com.ojn.gexf4j.core.testgraphs.GraphBuilder;

public class StaxGraphWriterTest extends GraphWriterTest {

	public StaxGraphWriterTest(GraphBuilder builder) {
		super(builder);
	}

	@Override
	protected String getFileNamePrefix() {
		return "stax";
	}

	@Override
	protected GraphWriter newGraphWriter() {
		return new StaxGraphWriter();
	}
}