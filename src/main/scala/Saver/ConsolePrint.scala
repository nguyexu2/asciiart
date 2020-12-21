package Saver

import Image.{Pixel, Image}

object ConsolePrint extends OutputSaver {
  override def save(image: Image[_]):Unit = {
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        print(image.getPixel(j, i))
      }
      println()
    }
  }
}