package ImageFilter.ArrayFilters

import scala.reflect.ClassTag

abstract class ScaleFilter extends Filter {}

class ScaleUpFilter(value: Double) extends ScaleFilter{
  if(value < 1)
    throw new IllegalArgumentException(s"scaling up needs a value >=1, got $value")

  override def filter[T: ClassTag](arr: Array[Array[T]]): Array[Array[T]] = {
    if(arr.length == 0 || arr(0).isEmpty)
      return arr

    val width = arr.length
    if(arr.exists(row => row.length != width))
      throw new IllegalArgumentException("not all rows have the same length")

    val newHeight = (width * value).toInt
    val newWidth = (arr(0).length * value).toInt
    val ret = Array.ofDim[T](newHeight, newWidth)

    for (i <- 0 until newHeight; j <- 0 until newWidth)
      ret(i)(j) = arr((i / value).toInt)((j / value).toInt)
    ret
  }
}

class ScaleDownFilter[A](value: Double, average: Seq[A] => A) extends ScaleFilter {

  if(value > 1 || value <= 0)
    throw new IllegalArgumentException(s"scaling up needs a value (0 - 1] , got $value")

  override def filter[T: ClassTag](arr: Array[Array[T]]): Array[Array[T]] = {
    if(arr.length == 0 || arr(0).isEmpty)
      return arr

    val width = arr.length
    if(arr.exists(row => row.length != width))
      throw new IllegalArgumentException("not all rows have the same length")

    val newHeight = (width * value).toInt
    val newWidth = (arr(0).length * value).toInt
    val ret = Array.ofDim[T](newHeight, newWidth)

    val h = arr.length / newHeight
    val w = arr(0).length / newWidth

    for (i <- 0 until newHeight; j <- 0 until newWidth) {
      val list :Seq[A] = for(ii <- i*h until (i+1)*h; jj <- j*w until (j+1)*w) yield arr(ii)(jj).asInstanceOf[A]

      ret(i)(j) = average(list).asInstanceOf[T]
    }
    ret
  }
}
