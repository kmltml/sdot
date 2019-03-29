package sdot

final case class Attrib[-S <: Graph.Statement, V](name: String) {

  def :=(v: V)(implicit V: IsAttribValue[V]): AttribPair[S, V] =
    AttribPair(this, v)

}

final case class AttribPair[-S <: Graph.Statement, V](attrib: Attrib[S, V], value: V)(implicit V: IsAttribValue[V]) {

  def toDot: String = s""" ${attrib.name}=${V.toDot(value)} """

}

trait IsAttribValue[V] {

  def toDot(v: V): String

}

object IsAttribValue {

  def instance[V](f: V => String): IsAttribValue[V] = new IsAttribValue[V] {
    def toDot(v: V): String = f(v)
  }

  implicit val stringIsAttribValue: IsAttribValue[String] =
    instance(escapeString)

  implicit val symbolIsAttribValue: IsAttribValue[Symbol] =
    instance((escapeString _) compose (_.name))

  implicit val intIsAttribValue: IsAttribValue[Int] =
    instance(_.toString)

}
