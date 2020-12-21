package ImageFilter


import Image.CharPixel
import ImageFilter.ArrayFilters.{ChangeBrightnessFilter, FlipXFilter, FlipYFilter, InvertFilter, RotateFilter, ScaleFilter}
import Parameters.{Brightness, FlipX, FlipY, Invert, Parameter, Rotate, Scale}

object FilterFactory {
  def get(seq: Seq[Parameter]): Filter = {
    var ret = List[Filter]()
    for (param <- seq) {
      param match {
        case _: FlipX => ret = ret.appended(new FlipXFilter)
        case _: FlipY => ret = ret.appended(new FlipYFilter)
        case _: Invert => ret = ret.appended(new InvertFilter(
          (e: CharPixel) => e
          //TODO
        ))
        case x: Rotate => ret = ret.appended(new RotateFilter(x.degree))
        case x: Scale => ret = ret.appended(new ScaleFilter(x.value,
          (l: Seq[CharPixel]) => l.head
          //TODO
        ))
        case x:Brightness => ret = ret.appended(new ChangeBrightnessFilter(
          //TODO
          (e:CharPixel) => e
        ))
        case _ =>
      }

    }
    new FilterList(ret)
  }
}
