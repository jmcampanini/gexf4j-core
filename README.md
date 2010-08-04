gexf4j-core - java library for the .gexf file format
=================

Latest Version: 0.2.0-ALPHA [Here](http://github.com/jmcampanini/gexf4j-core/tree/version0-2)

About
------------------
GEXF File Format Java Library. Supports [GEXF 1.1](http://gexf.net/format/index.html). Used to create and write GEXF Files for visualizing graphs using Gephi and any other GEXF-supporting application.

License
------------------
Copyright [2010] [Javier Campanini]

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

Version 0.2 - ALPHA
------------------
NOTE: The alpha version does NOT have a full test suite.

The underlying API has changed dramatically. Gexf4j now supports the entire GEXF file format, including:

* Data Graphs
* Dynamics
* Hierarchy
* Phylogeny
* Visualization

Also introduced in 0.2 is a chaining API, allowing for a more descriptive interaction with the API. Here's an example:

	Node gephi = gexf.getGraph().createNode("0");
	gephi
		.setLabel("Gephi")
		.setStartDate(toDate("2009-03-01"))
		.getAttributeValues()
			.addValue(attUrl, "http://gephi.org")
			.addValue(attIndegree, "1");

Roadmap
------------------
* 0.2 - Write GEXF Files
* 0.3 - Read GEXF Files
* 0.4 - Data Validation & Integerity
* 0.5 - Helper Functionality for Dynamic Timelines
* 1.0 - Finalize API

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

	Gexf gexf = new GexfImpl();
	
	gexf.getMetadata()
		.setLastModified(toDate("2009-03-20"))
		.setCreator("Gephi.org")
		.setDescription("A Web network");
	
	AttributeList attrList = new AttributeListImpl(AttributeClass.NODE);
	gexf.getGraph().getAttributeLists().add(attrList);
	
	Attribute attUrl = attrList.createAttribute("0", AttributeType.STRING, "url");
	Attribute attIndegree = attrList.createAttribute("1", AttributeType.FLOAT, "indegree");
	Attribute attFrog = attrList.createAttribute("2", AttributeType.BOOLEAN, "frog")
		.setDefaultValue("true");
	
	Node gephi = gexf.getGraph().createNode("0");
	gephi
		.setLabel("Gephi")
		.getAttributeValues()
			.addValue(attUrl, "http://gephi.org")
			.addValue(attIndegree, "1");
	
	Node webatlas = gexf.getGraph().createNode("1");
	webatlas
		.setLabel("Webatlas")
		.getAttributeValues()
			.addValue(attUrl, "http://webatlas.fr")
			.addValue(attIndegree, "2");
	
	Node rtgi = gexf.getGraph().createNode("2");
	rtgi
		.setLabel("RTGI")
		.getAttributeValues()
			.addValue(attUrl, "http://rtgi.fr")
			.addValue(attIndegree, "1");
	
	Node blab = gexf.getGraph().createNode("3");
	blab
		.setLabel("BarabasiLab")
		.getAttributeValues()
			.addValue(attUrl, "http://barabasilab.com")
			.addValue(attIndegree, "1")
			.addValue(attFrog, "false");
	
	gephi.connectTo("0", webatlas);
	gephi.connectTo("1", rtgi);
	webatlas.connectTo("2", gephi);
	rtgi.connectTo("3", webatlas);
	gephi.connectTo("4", blab);