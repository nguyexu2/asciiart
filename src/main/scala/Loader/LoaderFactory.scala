package Loader

import java.io.File

import Loader.ImageLoaders.FileImageLoader
import Parameters.{InputLocation, InputParam, Parameter}

object LoaderFactory {
  final val supportedFormats = Array("png", "jpg")

  def get(args: Seq[Parameter]): FileImageLoader = {
    for (param <- args) {
      param match {
        case x: InputLocation =>
          val format = x.path.substring(x.path.lastIndexOf('.') + 1)
          if (!supportedFormats.contains(format))
            throw new IllegalArgumentException(s"file of $format format not supported")
          return new FileImageLoader(new File(x.path))
        case _: InputParam => throw new IllegalArgumentException("missing implementation for input parameter")
        case _ =>
      }
    }

    throw new IllegalArgumentException("missing input")
  }
}
