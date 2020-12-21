package Parameters

class ParamList(params : Seq[Parameter]) {}

abstract class Parameter {}

class FlipX() extends Parameter {}

class FlipY() extends Parameter {}

class Invert() extends Parameter {}

class Rotate(val degree: Int) extends Parameter {}

class Scale(val value: Double) extends Parameter {}

class Brightness(val value: Int) extends Parameter {}

class InputLocation(val path: String) extends Parameter {}

class OutputLocation(val path: String) extends Parameter {}

class OutputConsole extends Parameter {}


