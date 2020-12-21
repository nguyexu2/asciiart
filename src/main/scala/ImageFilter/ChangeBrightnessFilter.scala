package ImageFilter

import scala.reflect.ClassTag

class ChangeBrightnessFilter[A](f: A => A) extends Filter {

  override def filter[T: ClassTag](arr: Array[Array[T]]): Array[Array[T]] = {
    if (!arr.isEmpty && !arr(0)(0).isInstanceOf[A])
      throw new IllegalArgumentException("type do not match")

    arr.map(_.map(x => {
      f(x.asInstanceOf[A]).asInstanceOf[T]
    }))
  }
}
