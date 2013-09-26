/**
 * Copyright 2013 Wordnik, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wordnik.swagger.codegen

import com.wordnik.swagger.model._


object BasicEnyoModelGenerator extends BasicEnyoModelGenerator {
  def main(args: Array[String]) = generateClient(args)
}

class BasicEnyoModelGenerator extends BasicGenerator {

  /**
   * These are enyo mappings
   */
  //  override def typeMapping = Map(
  //    "Array" -> "array",
  //    "array" -> "array",
  //    "List" -> "array",
  //    "boolean" -> "Boolean",
  //    "string" -> "String",
  //    "int" -> "Number",
  //    "int32" -> "Number",
  //    "int64" -> "Number",
  //    "date-time" -> "Date",
  //    "float" -> "Number",
  //    "long" -> "Number",
  //    "double" -> "Number",
  //    "object" -> "Object",
  //    "integer" -> "Number")

  override def generateClient(args: Array[String]) {
    //    this.version = args(2)
    super.generateClient(args)
  }

  //  def version = "v1"

  // package for models
  override def modelPackage = Some("v1")

  // package for api classes
  override def apiPackage = Some("v1.api")

  //The package that will define the version for this api
  override def invokerPackage = Some("v1")

  // location of templates
  override def templateDir = "enyo"

  // where to write generated code
  override def destinationDir = "generated-code/enyo-model/"

  // template used for models
  modelTemplateFiles += "model.mustache" -> ".js"


  // file suffix
  override def fileSuffix = ".js"


  override def toDeclaredType(dataType: String): String = {
    def mappedType = typeMapping.get(dataType)

    if (mappedType == None) {
      //Can we assume that this is a model item?
      val rtn = modelPackage.get + "." + dataType
      return rtn
    } else {
      val rtn = super.toDeclaredType(dataType)
      return rtn
    }

  }


  // supporting classes
  override def supportingFiles =
    List(
//      ("api-package.mustache", destinationDir + java.io.File.separator + apiPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, "package.js"),
      ("model-package.mustache", destinationDir + java.io.File.separator + modelPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, "package.js")
//      ("invoker-package.mustache", destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, "package.js"),
//      ("api-lib.mustache", destinationDir + java.io.File.separator, "api-lib.js"))

  //      ("root-package.mustache", destinationDir + java.io.File.separator, "package.js")
    )


}
