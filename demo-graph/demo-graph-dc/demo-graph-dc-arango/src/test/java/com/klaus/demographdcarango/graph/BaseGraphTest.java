/*
 * DISCLAIMER
 *
 * Copyright 2016 ArangoDB GmbH, Cologne, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright holder is ArangoDB GmbH, Cologne, Germany
 */

package com.klaus.demographdcarango.graph;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.ArangoDatabase;
import com.arangodb.entity.EdgeDefinition;
import com.arangodb.entity.EdgeEntity;
import com.arangodb.entity.VertexEntity;

/**
 * @author Mark Vollmary
 *
 */
public abstract class BaseGraphTest {

	protected static final String TEST_DB = "java_driver_graph_test_db";
	protected static ArangoDB arangoDB;
	protected static ArangoDatabase db;
	protected static final String GRAPH_NAME = "traversalGraph";
	protected static final String EDGE_COLLECTION_NAME = "edges";
	protected static final String VERTEXT_COLLECTION_NAME = "circles";

	@BeforeClass
	public static void init() {
		if (arangoDB == null) {
			arangoDB = new ArangoDB.Builder().build();
		}
		try {
			arangoDB.db(TEST_DB).drop();
		} catch (final ArangoDBException e) {
		}
		arangoDB.createDatabase(TEST_DB);
		BaseGraphTest.db = arangoDB.db(TEST_DB);

		final Collection<EdgeDefinition> edgeDefinitions = new ArrayList<EdgeDefinition>();
		final EdgeDefinition edgeDefinition = new EdgeDefinition().collection(EDGE_COLLECTION_NAME)
				.from(VERTEXT_COLLECTION_NAME).to(VERTEXT_COLLECTION_NAME);
		edgeDefinitions.add(edgeDefinition);
		try {
			db.createGraph(GRAPH_NAME, edgeDefinitions, null);
			addExampleElements();
		} catch (final ArangoDBException ex) {

		}
	}

	@AfterClass
	public static void shutdown() {
		arangoDB.db(TEST_DB).drop();
		arangoDB.shutdown();
		arangoDB = null;
	}

	private static void addExampleElements() throws ArangoDBException {

		// Add circle circles
		final VertexEntity vA = createVertex(new Circle("A", "1"));
		final VertexEntity vB = createVertex(new Circle("B", "2"));
		final VertexEntity vC = createVertex(new Circle("C", "3"));
		final VertexEntity vD = createVertex(new Circle("D", "4"));
		final VertexEntity vE = createVertex(new Circle("E", "5"));
		final VertexEntity vF = createVertex(new Circle("F", "6"));
		final VertexEntity vG = createVertex(new Circle("G", "7"));
		final VertexEntity vH = createVertex(new Circle("H", "8"));
		final VertexEntity vI = createVertex(new Circle("I", "9"));
		final VertexEntity vJ = createVertex(new Circle("J", "10"));
		final VertexEntity vK = createVertex(new Circle("K", "11"));

		// Add relevant edges - left branch:
		saveEdge(new CircleEdge(vA.getId(), vB.getId(), false, true, "left_bar"));
		saveEdge(new CircleEdge(vB.getId(), vC.getId(), false, true, "left_blarg"));
		saveEdge(new CircleEdge(vC.getId(), vD.getId(), false, true, "left_blorg"));
		saveEdge(new CircleEdge(vB.getId(), vE.getId(), false, true, "left_blub"));
		saveEdge(new CircleEdge(vE.getId(), vF.getId(), false, true, "left_schubi"));

		// Add relevant edges - right branch:
		saveEdge(new CircleEdge(vA.getId(), vG.getId(), false, true, "right_foo"));
		saveEdge(new CircleEdge(vG.getId(), vH.getId(), false, true, "right_blob"));
		saveEdge(new CircleEdge(vH.getId(), vI.getId(), false, true, "right_blub"));
		saveEdge(new CircleEdge(vG.getId(), vJ.getId(), false, true, "right_zip"));
		saveEdge(new CircleEdge(vJ.getId(), vK.getId(), false, true, "right_zup"));
	}

	private static EdgeEntity saveEdge(final CircleEdge edge) throws ArangoDBException {
		return db.graph(GRAPH_NAME).edgeCollection(EDGE_COLLECTION_NAME).insertEdge(edge);
	}

	private static VertexEntity createVertex(final Circle vertex) throws ArangoDBException {
		return db.graph(GRAPH_NAME).vertexCollection(VERTEXT_COLLECTION_NAME).insertVertex(vertex);
	}

}
