import Image.Image
import ImageConversion.ConverterFactory
import ImageFilter.ArrayFilters.RotateFilter
import ImageFilter.FilterFactory
import Loader.LoaderFactory
import Saver.{ConsolePrint, SaverFactory}
import UI.InputParser

object Main extends App {
  val paramList = new InputParser(args).Parse()

  val loader = LoaderFactory.get(paramList)
  if (loader.isEmpty) {
    println("couldn't fetch image, input uses --image file_path")
    sys.exit(1)
  }


  val image = loader.get.getImage
  val newImage = ConverterFactory.RGBImageToCharImage(image)

  val filter = FilterFactory.get(paramList)

  val newFilteredImage = new Image(filter.filter(newImage.getGrid))
  val saverFunc = SaverFactory.get(paramList)
  saverFunc(newFilteredImage)
}