package Parameters

class ParamList(params: Seq[Parameter]) {}

abstract class Parameter {}

abstract class InputParam extends Parameter {}

abstract class OutputParam extends Parameter {}

abstract class FilterParam extends Parameter {}

class FlipX() extends FilterParam {}

class FlipY() extends FilterParam {}

class Invert() extends FilterParam {}

class Rotate(val degree: Int) extends FilterParam {}

class Scale(val value: Double) extends FilterParam {}

class Brightness(val value: Int) extends FilterParam {}

class InputLocation(val path: String) extends InputParam {}

class OutputLocation(val path: String) extends OutputParam {}

class OutputConsole extends OutputParam {}


