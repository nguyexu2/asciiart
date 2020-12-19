package Loader.ImageLoaders

import java.awt.Color
import java.io.File

import Image.{GridImage, Image, Pixel, PixelGrid, RGBPixel}
import javax.imageio.ImageIO

class FileImageLoader(val path: File) extends ImageLoader {
  override def getImage(): Image = {
    val buffer = ImageIO.read(path)

    val height = buffer.getHeight
    val width = buffer.getWidth
    val pixelArr = Array.ofDim[RGBPixel](height, width)

    for (y <- 0 until height; x <- 0 until width) {
        pixelArr(y)(x) = new RGBPixel(new Color(buffer.getRGB(x, y)))
    }

    new GridImage(new PixelGrid(pixelArr))
  }
}
