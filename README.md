gexf4j-core - java library for the .gexf file format
=================

About
------------------
GEXF File Format Java Library. Supports [GEXF 1.1](http://gexf.net/format/index.html). Used to create and write GEXF Files for visualizing graphs using Gephi and any other GEXF-supporting application.

License
------------------
Copyright [2010] [Javier Campanini]

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Version 0.1
------------------
The underlying API will most likely not change.

Roadmap
------------------
* 0.1 - Basic Implementation of GEXF File Format (including data + dynamics)
* 0.2 - Read GEXF Files
* 0.3 - Data Validation & Integerity
* 0.4 - Helper Functionality for Dynamic Timelines

Moving to gexf4j-util
-----------------
* in-java graph creation
* neo4j graph exporting
* sql/nosql graphing
* file structure graphing
* site-mapping
* facebook graphing *(eventually)*

Installing
------------------
You have two options:

1. Download the latest JAR files from the download page OR
2. Download the source, and compile/install using maven2

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