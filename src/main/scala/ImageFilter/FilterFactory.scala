package ImageFilter


import Image.CharPixel
import ImageConversion.ConverterFactory
import ImageFilter.ArrayFilters.{ChangeBrightnessFilter, FlipXFilter, FlipYFilter, InvertFilter, RotateFilter, ScaleFilter}
import Parameters.{Brightness, FilterParam, FlipX, FlipY, Invert, Parameter, Rotate, Scale}

object FilterFactory {
  def get(seq: Seq[Parameter]): Filter = {
    var ret = List[Filter]()
    for (param <- seq) {
      param match {
        case _: FlipX => ret = ret.appended(new FlipXFilter)
        case _: FlipY => ret = ret.appended(new FlipYFilter)
        case _: Invert =>
          val invert = ConverterFactory.CharInverter
          ret = ret.appended(new InvertFilter(
            (e: CharPixel) => invert(e)
          ))
        case x: Rotate => ret = ret.appended(new RotateFilter(x.degree))
        case x: Scale => ret = ret.appended(new ScaleFilter(x.value,
          (l: Seq[CharPixel]) => l.head
          //TODO
        ))
        case x: Brightness =>
          val brightnessChanger = ConverterFactory.ChangeBrightness(x.value)
          ret = ret.appended(new ChangeBrightnessFilter(
            (e: CharPixel) => brightnessChanger(e)
          ))
        case _: FilterParam => throw new IllegalArgumentException("missing implementation for filter")
        case _ =>
      }

    }
    new FilterList(ret)
  }
}
