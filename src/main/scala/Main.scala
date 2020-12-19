package Main

import Loader.{InputParser, LoaderFactory}

object Main extends App {
  val paramList = new InputParser(args).Parse()

  val loader = new LoaderFactory(paramList).get()
  val image = loader.getImage()
  //convert to ascii
  //create filter creator
  //build filter depending on arguments
  //apply filter on images
  //create output depending on param
  //save image


  println("Hello there")
}

object Foos {
  def Foo() : Boolean = true
}