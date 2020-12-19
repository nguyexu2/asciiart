package Loader

import java.io.File
import Loader.ImageLoaders.FileImageLoader

class LoaderFactory(var args: Seq[Parameter]) {
  final val supportedFormats = Array("png", "jpg")

  def get() : FileImageLoader = {
    for (param <- args) {
      param match {
        case x: InputLocation =>
          val format = x.path.substring(x.path.lastIndexOf('.') + 1)
          if(! supportedFormats.contains(format))
            throw new IllegalArgumentException(s"file of $format format not supported")

          return new FileImageLoader(new File(x.path))
      }
    }

    throw new IllegalArgumentException("missing input")
  }

}
