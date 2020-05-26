package com.colisweb

import com.github.pathikrit.dijon.parse
import org.fusesource.scalate.{Template, TemplateEngine}

object Demo2 extends App {
  val engine             = new TemplateEngine
  val template: Template = engine.compileSsp("""
    |<%@ val json: com.github.pathikrit.dijon.SomeJson %>
    |<%
    |  val name = json.name.asString.get
    |  val age = json.age.asInt.get
    |  val emails = json.contact.emails.toSeq.map(_.asString.get)
    |%>
    |yo ${name} (${age})
    |
    |<ul>
    |#for (email <- emails)
    |  <li>contact via <a href="mailto:${email}">${email}</a></li>
    |#end
    |</ul>
    |""".stripMargin)

  val data = """{
                |  "name": "Rick",
                |  "age": 27,
                |  "contact": {
                |    "emails": [
                |      "pathikritbhowmick@msn.com",
                |      "pathikrit.bhowmick@gmail.com"
                |    ]
                |  }
                |}""".stripMargin

  val json = parse(data)
  println(engine.layout("aa.ssp", template, Map("json" -> json)))
}
