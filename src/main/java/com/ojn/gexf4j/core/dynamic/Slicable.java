package com.ojn.gexf4j.core.dynamic;

import java.util.List;

public interface Slicable<T extends Object> extends Dynamic<T> {

	List<Slice> getSlices();
}