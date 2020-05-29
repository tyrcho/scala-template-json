package com.colisweb

import org.fusesource.scalate.{Template, TemplateEngine}

object Demo extends App {
  val engine             = new TemplateEngine
  val template: Template = engine.compileSsp("""
    |<%@ val json: ujson.Value.Value %>
    |<%
    |  val name = json("name").str
    |  val age = json("age").num.toInt
    |  val emails = json("contact")("emails").arr
    |
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

  println(engine.layout("aa.ssp", template, Map("json" -> ujson.read(data))))
}
