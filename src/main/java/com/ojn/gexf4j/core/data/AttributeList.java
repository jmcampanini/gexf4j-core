package com.ojn.gexf4j.core.data;

import java.util.List;

import com.ojn.gexf4j.core.Mode;
import com.ojn.gexf4j.core.dynamic.Dynamic;

public interface AttributeList extends List<Attribute>, Dynamic<AttributeList> {
	
	AttributeClass getAttributeClass();
	
	Mode getMode();
	AttributeList setMode(Mode mode);
}