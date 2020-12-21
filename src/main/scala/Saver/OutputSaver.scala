package Saver

import Image.{Image, Pixel}

trait OutputSaver {
  def save(image: Image[_]): Unit
}
