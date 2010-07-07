gexf4j-core - java library for the .gexf file format
=================

Version 0.02
------------------
The API *WILL* change

Roadmap (subject to change!)
------------------
1. First release of gexf4j
2. *Streaming Graph Writer (using StAX)*
3. Data Support & Implementations - _Working On_
4. Dynamic Support
5. neo4j Support

Sample Code
------------------

	// create a graph and 3 nodes
	Graph g = new Graph();
	Node n1 = g.createNode();
	Node n2 = g.createNode();
	Node n3 = g.createNode();

	// connect the nodes
	n1.connectTo(n2);
	n2.connectTo(n3);

	// create a graphWriter and file output stream
	GraphWriter gw = new StaxGraphWriter();
	File f = new File("textout.gexf");
	FileOutputStream fos = new FileOutputStream(f);

	// write the file and close the stream - no XML worries!
	gw.write(g, fos);
	fos.close();