package ImageFilter

import Image.Image

trait Filter {
  def filter(arr:Array[Array[_]]) :Array[Array[_]]
}
