package ImageFilter

import scala.reflect.ClassTag

class ChangeBrightnessFilter(offset :Int) extends Filter {
  override def filter[T:ClassTag](arr:Array[Array[T]]) :Array[Array[T]] = ???
}
