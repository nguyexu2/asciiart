package Saver

import java.io.{File, PrintWriter}

import Image.Image

class FileSaver(path: String) extends OutputSaver {
  override def save(image: Image[_]): Unit = {
    val pw = new PrintWriter(new File(path))
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        pw.write(image.getPixel(j, i).toString)
      }
      pw.write("\n")
    }
    pw.close()
  }
}
