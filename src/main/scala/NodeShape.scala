package sdot

abstract class NodeShape {

  def toDot: String

}

object NodeShape {

  implicit val nodeShapeIsAttrValue: IsAttribValue[NodeShape] =
    IsAttribValue.instance(_.toDot)

  final class Polygon(val name: String) extends NodeShape {
    def toDot = name
  }

  val Box = new Polygon("box")
  val Polygon = new Polygon("polygon")
  val Ellipse = new Polygon("ellipse")
  val Oval = new Polygon("oval")
  val Circle = new Polygon("circle")
  val Point = new Polygon("point")
  val Egg = new Polygon("egg")
  val Triangle = new Polygon("triangle")
  val Plaintext = new Polygon("plaintext")
  val Plain = new Polygon("plain")
  val Diamond = new Polygon("diamond")
  val Trapezium = new Polygon("trapezium")
  val Parallelogram = new Polygon("parallelogram")
  val House = new Polygon("house")
  val Pentagon = new Polygon("pentagon")
  val Hexagon = new Polygon("hexagon")
  val Septagon = new Polygon("septagon")
  val Octagon = new Polygon("octagon")
  val DoubleCircle = new Polygon("doublecircle")
  val DoubleOctagon = new Polygon("doubleoctagon")
  val TripleOctagon = new Polygon("tripleoctagon")
  val Invtriangle = new Polygon("invtriangle")
  val Invtrapezium = new Polygon("invtrapezium")
  val Invhouse = new Polygon("invhouse")
  val MDiamond = new Polygon("Mdiamond")
  val MSquare = new Polygon("Msquare")
  val MCircle = new Polygon("Mcircle")
  val Rect = new Polygon("rect")
  val Rectangle = new Polygon("rectangle")
  val Square = new Polygon("square")
  val Star = new Polygon("star")
  val None = new Polygon("none")
  val Underline = new Polygon("underline")
  val Cylinder = new Polygon("cylinder")
  val Note = new Polygon("note")
  val Tab = new Polygon("tab")
  val Folder = new Polygon("folder")
  val Box3d = new Polygon("box3d")
  val Component = new Polygon("component")
  val Promoter = new Polygon("promoter")
  val Cds = new Polygon("cds")
  val Terminator = new Polygon("terminator")
  val Utr = new Polygon("utr")
  val Primersite = new Polygon("primersite")
  val Restrictionsite = new Polygon("restrictionsite")
  val FivePOverhang = new Polygon("fivepoverhang")
  val ThreePOverhang = new Polygon("threepoverhang")
  val NOverhang = new Polygon("noverhang")
  val Assembly = new Polygon("assembly")
  val Signature = new Polygon("signature")
  val Insulator = new Polygon("insulator")
  val Ribosite = new Polygon("ribosite")
  val RnaStab = new Polygon("rnastab")
  val Proteasesite = new Polygon("proteasesite")
  val ProteinStab = new Polygon("proteinstab")
  val RPromoter = new Polygon("rpromoter")
  val RArrow = new Polygon("rarrow")
  val LArrow = new Polygon("larrow")
  val LPromoter = new Polygon("lpromoter")


}
