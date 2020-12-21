import Image.Image
import ImageConversion.ConverterFactory
import ImageFilter.ArrayFilters.RotateFilter
import ImageFilter.FilterFactory
import Loader.LoaderFactory
import Saver.ConsolePrint
import UI.InputParser

object Main extends App {
  val paramList = new InputParser(args).Parse()

  val loader = LoaderFactory.get(paramList)
  val image = loader.getImage
  val newImage = ConverterFactory.RGBImageToCharImage(image)

  val filter = FilterFactory.get(paramList)

  val newFilteredImage = new Image(filter.filter(newImage.getGrid))

  //save image
  ConsolePrint.printToConsole(newFilteredImage)
}