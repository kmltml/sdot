package sdot

object Attribs {

  import Graph._

  val label = Attrib[Statement, String]("label")
  val shape = Attrib[Node, NodeShape]("shape")

}
