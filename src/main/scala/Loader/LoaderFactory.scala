package Loader

import java.io.File

import Loader.ImageLoaders.FileImageLoader
import Parameters.{InputLocation, InputParam, Parameter}

object LoaderFactory {
  final val supportedFormats = Array("png", "jpg")

  /**
   * @param args: sequence of parameters, to see which are supported, check the Parameters package
   * @throws IllegalArgumentException: when format is not supported
   * @return class that can create an image, none if no inputParam was given
   */
  @throws [IllegalArgumentException]
  def get(args: Seq[Parameter]): Option[FileImageLoader] = {
    for (param <- args) {
      param match {
        case x: InputLocation =>
          val format = x.path.substring(x.path.lastIndexOf('.') + 1)
          if (!supportedFormats.contains(format))
            throw new IllegalArgumentException(s"file of $format format not supported")
          return Some(new FileImageLoader(new File(x.path)))
        case _: InputParam => throw new IllegalArgumentException("missing implementation for input parameter")
        case _ =>
      }
    }

    None
  }
}
