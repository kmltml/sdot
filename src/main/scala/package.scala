import scala.language.dynamics

package object sdot {

  def digraph(name: String)(stmnts: Graph.Statement*): Graph =
    Graph(Graph.Type.Digraph, Some(name), stmnts)

  def node(name: String): Graph.Node =
    Graph.Node(name)

  object n extends Dynamic {

    def apply(name: String): Graph.Node =
      new Graph.Node(name)

    def apply(name: Int): Graph.Node =
      apply(name.toString)

    def selectDynamic(name: String): Graph.Node =
      apply(name)

    def applyDynamic(name: String, a: AttribPair[Graph.Node, _]*): Graph.Node =
      Graph.Node(name, attribs = a)

  }

  private val IdRegex = """[a-zA-Z_][a-zA-Z_0-9]*""".r

  def escapeString(s: String): String = s match {
    case IdRegex() => s
    case _ => "\"" + s.flatMap {
      case '"' => "\\\""
      case '\n' => "\\n"
      case c => c.toString
    } + "\""
  }

}
