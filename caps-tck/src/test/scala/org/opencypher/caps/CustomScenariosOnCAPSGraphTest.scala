/*
 * Copyright (c) 2016-2017 "Neo4j, Inc." [https://neo4j.com]
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
 */
package org.opencypher.caps

import java.io.File
import java.util

import org.junit.jupiter.api.{DynamicTest, TestFactory}
import org.opencypher.caps.TCKAdapterForCAPS._
import org.opencypher.caps.api.spark.CAPSGraph
import org.opencypher.tools.tck.api.CypherTCK

import scala.collection.JavaConverters._

class CustomScenariosOnCAPSGraphTest {
  import TCKFixture._

  @TestFactory
  def runCustomOnNeo4j(): util.Collection[DynamicTest] = {
    val file = new File(getClass.getResource("CAPSTestFeature.feature").toURI)
    CypherTCK
      .parseFilesystemFeature(file)
      .scenarios
      .map(TCKFixture.dynamicTest(CAPSGraph.empty))
      .asJavaCollection
  }
}
