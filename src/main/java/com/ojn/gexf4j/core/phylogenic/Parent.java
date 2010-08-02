package com.ojn.gexf4j.core.phylogenic;

import com.ojn.gexf4j.core.Node;

public interface Parent {

	Node getFor();
	Parent setFor(Node node);
}