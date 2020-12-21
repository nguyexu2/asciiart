package Saver

import Image.Image

trait OutputSaver {
  def save(image: Image[_]): Unit
}
