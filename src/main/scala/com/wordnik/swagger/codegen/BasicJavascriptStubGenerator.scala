/**
 *  Copyright 2013 Wordnik, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.wordnik.swagger.codegen

import com.wordnik.swagger.model._


object BasicJavascriptStubGenerator extends BasicJavascriptStubGenerator {
  def main(args: Array[String]) = generateClient(args)
}

class BasicJavascriptStubGenerator extends BasicGenerator {

  // package for models
  override def modelPackage = Some("model")

  // package for api classes
  override def apiPackage = Some("api")

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

}
