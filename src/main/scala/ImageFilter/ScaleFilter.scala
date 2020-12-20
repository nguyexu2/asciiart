package ImageFilter
import Image.Image

import scala.reflect.ClassTag

class ScaleFilter(value:Double) extends Filter {
  override def filter[T:ClassTag](arr:Array[Array[T]]) :Array[Array[T]] = {

    arr
  }
}
