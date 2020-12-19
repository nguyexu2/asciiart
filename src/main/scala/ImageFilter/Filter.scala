package ImageFilter

import Image.Image

trait Filter {
  def filter(img: Image) :Image
}
