package ImageConversion

import Image.{Image, Pixel, PixelGrid}

import scala.reflect.ClassTag

class ConvertImage[A <: Pixel, B <:Pixel :ClassTag ](convert: A => B) {
  def convert(image: Image[A]): Image[B] = {
    val arr = Array.ofDim[B](image.height, image.width)

    for (i <- 0 until image.height; j <- 0 until image.width)
      arr(i)(j) = convert(image.getPixel(j, i))
    new Image[B](arr)
  }

}