package Saver

import Image.Image

class SaverList(seq: Seq[OutputSaver]) extends OutputSaver {
  override def save(image: Image[_]): Unit = {
      for(saver <- seq)
        saver.save(image)
  }
}
