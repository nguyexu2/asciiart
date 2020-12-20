package ImageFilter

import scala.reflect.ClassTag

class RotateFilter(val degree: Int) extends Filter {
  final val supportedDegree = Array[Int](0, 90, 180, 270)

  private final val normalizedDegree =
    if (degree < 0) {
      degree + 360 * ((degree.abs / 360) + 1)
    }
    else degree % 360

  if (!supportedDegree.contains(normalizedDegree))
    throw new IllegalArgumentException(s"rotation by $degree not supported")

  override def filter[T: ClassTag](arr: Array[Array[T]]): Array[Array[T]] = {
    var ret = arr.map(_.clone())
    var tmpDeg = normalizedDegree
    while (tmpDeg != 0) {
      val height = ret.length
      val width = ret(0).length
      val tmpMat = Array.ofDim[T](width, height)
      for (i <- 0 until height; j <- 0 until width)
        tmpMat(j)(height - 1 - i) = ret(i)(j)

      ret = tmpMat
      tmpDeg = tmpDeg - 90
    }


    ret
  }
}
