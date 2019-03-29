package sdot

case class Graph(typ: Graph.Type, name: Option[String], statements: Seq[Graph.Statement]) {

  def toDot: String = {
    s"${typ.name} ${name getOrElse ""} {\n" + statements.map(_.toDot).mkString("\n") + "\n}"
  }

}

object Graph {

  sealed abstract class Type(val name: String)
  object Type {
    case object Digraph extends Type("digraph")
    case object Graph extends Type("digraph")
  }

  sealed abstract class Statement {
    def toDot: String
  }
  final case class Edge(from: String, to: String, attribs: Seq[AttribPair[Edge, _]] = Seq()) extends Statement {
    def toDot: String =
      s""" ${escapeString(from)} -> ${escapeString(to)} [${attribs.map(_.toDot).mkString(" ")}]; """

    def apply(a: AttribPair[Edge, _]*): Edge =
      copy(attribs = attribs ++ a)
  }
  final case class Node(name: String, attribs: Seq[AttribPair[Node, _]] = Seq()) extends Statement {
    def toDot: String =
      s""" ${escapeString(name)} [${attribs.map(_.toDot).mkString(" ")}]; """

    def apply(a: AttribPair[Node, _]*): Node =
      copy(attribs = attribs ++ a)

    def --(b: String): Edge =
      Edge(name, b)
    def --(b: Node): Edge =
      Edge(name, b.name)

    def ->(b: String): Edge =
      Edge(name, b)
    def ->(b: Node): Edge =
      Edge(name, b.name)
  }

}
