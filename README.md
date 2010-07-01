gexf4j-core - java library for the .gexf file format
=================

// create a graph and 3 nodes
Graph g = new Graph();
Node n1 = new Node();
Node n2 = new Node();
Node n3 = new Node();

// create 2 edges and add them manually
Edge e1 = new Edge(n1, n2);
Edge e2 = new Edge(n2, n3);
n1.getEdges().add(e1);
n2.getEdges().add(e2);

// connect n3 to n1
n3.connectTo(n1);

// add all 3 nodes to the graph
g.addNode(n1);
g.addNode(n2);
g.addNode(n3);

// create a graphWriter and file output stream
GraphWriter gw = new GraphWriter();
File f = new File("textout.gexf");
FileOutputStream fos = new FileOutputStream(f);

// write the file and close the stream - no XML worries!
gw.write(g, fos);
fos.close();