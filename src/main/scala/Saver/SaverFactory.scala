package Saver

import Image.Image
import Parameters._

object SaverFactory {
  def get(seq: Seq[Parameter]): Image[_] => Unit = {
    var list = List[OutputSaver]()
    for (param <- seq) {
      param match {
        case _: OutputConsole => list = list.appended(ConsolePrint)
        case x: OutputLocation => list = list.appended(new FileSaver(x.path))
        case _: OutputParam => throw new IllegalArgumentException("output param was not implemented yet")
        case _ =>
      }
    }
    val saver = new SaverList(list)
    (img:Image[_]) => saver.save(img)
  }
}
