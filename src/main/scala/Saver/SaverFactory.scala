package Saver

import Image.Image
import Parameters.{OutputConsole, OutputLocation, OutputParam, Parameter}

object SaverFactory {
  def get(seq: Seq[Parameter]): Option[Image[_] => Unit] = {
    for (param <- seq) {
      param match {
        case _: OutputConsole => return Some((img: Image[_]) => ConsolePrint.save(img))
        case x: OutputLocation =>
          val fileSaver = new FileSaver(x.path)
          return Some((img: Image[_]) => fileSaver.save(img))
        case _: OutputParam => throw new IllegalArgumentException("output param was not implemented yet")
        case _ =>
      }
    }
    None
  }
}
