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


object BasicJavascriptStubGenerator extends BasicJavascriptStubGenerator {
  def main(args: Array[String]) = generateClient(args)
}

class BasicJavascriptStubGenerator extends BasicGenerator {

  override def generateClient(args: Array[String]) {
    this.version = args(2)
    super.generateClient(args)

  }

  def version = "v1"

  // package for models
  override def modelPackage = Some("v1.model")

  // package for api classes
  override def apiPackage = Some("v1.api")

  //The package that will define the version for this api
  override def invokerPackage = Some("v1")


  // location of templates
  override def templateDir = "javascript-stub"

  // where to write generated code
  override def destinationDir = "generated-code/javascript-stub/"

  // template used for models
  modelTemplateFiles += "model.mustache" -> ".js"

  // template used for models
  apiTemplateFiles += "api.mustache" -> ".js"


  // file suffix
  override def fileSuffix = ".js"


  override def appendModel(model: Map[String, AnyRef]) {
    model += "version" -> this.version
  }

  // These are enyo specific
  override def typeMapping = Map(
    "string" -> "String",
    "int32" -> "Number",
    "int64" -> "Number",
    "double" -> "Number",
    "float" -> "Number",
    "boolean" -> "Boolean",
    "date-time" -> "Date")

  // supporting classes
  override def supportingFiles =
    List(
      ("api-package.mustache", destinationDir + java.io.File.separator + apiPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, "package.js"),
      ("model-package.mustache", destinationDir + java.io.File.separator + modelPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, "package.js"),
      ("invoker-package.mustache", destinationDir + java.io.File.separator + invokerPackage.get.replace(".", java.io.File.separator) + java.io.File.separator, "package.js"),
      ("api-lib.mustache", destinationDir + java.io.File.separator, "api-lib.js"))

  //      ("root-package.mustache", destinationDir + java.io.File.separator, "package.js"))


}
