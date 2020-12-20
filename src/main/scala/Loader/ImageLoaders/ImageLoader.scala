package Loader.ImageLoaders

import Image.{Image, RGBPixel}

trait ImageLoader {
  def getImage: Image[RGBPixel]
}
