package Saver

import Image.{Pixel, Image}

object ConsolePrint {
  def printToConsole[T<:Pixel](image: Image[T]):Unit = {
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        print(image.getPixel(j, i))
      }
      println()
    }
  }
}