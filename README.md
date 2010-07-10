gexf4j-core - java library for the .gexf file format
=================

Version 0.02
------------------
The API *WILL* change

Roadmap (subject to change!)
------------------
1. First release of gexf4j
2. Streaming Graph Writer (using StAX)
3. **Data Support & Implementations**
4. Dynamic Support
5. neo4j Support

Planned Feature Set
-----------------
* in-java graph creation
* neo4j graph exporting
* sql/nosql graphing
* file structure graphing
* site-mapping
* facebook graphing *(eventually)*

Sample Code
------------------
The following code creates the same graph located on: http://gexf.net/format/data.html

	Graph rv = new GraphImpl();

	Attribute attribUrl = new AttributeImpl(AttributeType.String, "0", AttributeClass.Node);
	Attribute attribInDegree = new AttributeImpl(AttributeType.String, "1", AttributeClass.Node);
	Attribute attribFrog = new AttributeImpl(AttributeType.String, "2", AttributeClass.Node);

	attribUrl.setTitle("url");
	attribInDegree.setTitle("indegree");
	attribFrog.setTitle("frog");

	rv.getAttributes().add(attribUrl);
	rv.getAttributes().add(attribInDegree);
	rv.getAttributes().add(attribFrog);

	Node nGephi = rv.createNode("0");
	nGephi.setLabel("Gephi");
	nGephi.getAttributeValues().add(attribUrl.createValue("http://gephi.org"));
	nGephi.getAttributeValues().add(attribInDegree.createValue("1"));

	Node nWebatlas = rv.createNode("1");
	nWebatlas.setLabel("Webatlas");
	nWebatlas.getAttributeValues().add(attribUrl.createValue("http://webatlas.fr"));
	nWebatlas.getAttributeValues().add(attribInDegree.createValue("2"));

	Node nRTGI = rv.createNode("2");
	nRTGI.setLabel("RTGI");
	nRTGI.getAttributeValues().add(attribUrl.createValue("http://rtgi.fr"));
	nRTGI.getAttributeValues().add(attribInDegree.createValue("1"));

	Node nBar = rv.createNode("3");
	nBar.setLabel("BarabasiLab");
	nBar.getAttributeValues().add(attribUrl.createValue("http://barabasilab.com"));
	nBar.getAttributeValues().add(attribInDegree.createValue("1"));
	nBar.getAttributeValues().add(attribFrog.createValue("false"));

	nGephi.connectTo("0", nWebatlas);
	nGephi.connectTo("1", nRTGI);
	nWebatlas.connectTo("2", nGephi);
	nRTGI.connectTo("3", nWebatlas);
	nGephi.connectTo("4", nBar);