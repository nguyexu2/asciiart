package UI

import Parameters._

import scala.collection.mutable.ListBuffer

class InputParser(val arg: Array[String]) {

  /**
   * parses keywords and transform them to list of tokens(parameters)
   * @throws IllegalArgumentException when input contained not recognized keywords
   * @return sequence of parameters that were parsed
   */
  @throws [IllegalArgumentException]
  def Parse(): Seq[Parameter] = {
    i = 0
    params = new ListBuffer[Parameter]()
    while (!isEnd) {
      curToken match {
        case "--flip" => ParseFlip()
        case "--invert" => ParseInvert()
        case "--rotate" => ParseRotate()
        case "--scale" => ParseScale()
        case "--brightness" => ParseBrightness()
        case "--image" => ParseInput()
        case "--output-file" => ParseOutput()
        case "--output-console" => ParseOutput()
        case _ => throw new IllegalArgumentException(s"unknown parameter $curToken")
      }
    }

    params.toList
  }

  private var i = 0
  private var params = new ListBuffer[Parameter]()

  private def isEnd = i >= arg.length

  private def curToken =
    if (!isEnd) arg(i)
    else ""

  private def consumeToken(): Unit =
    if (!isEnd)
      i = i + 1

  private def ParseFlip(): Unit = {
    assert(curToken == "--flip")
    consumeToken()
    curToken match {
      case "x" => params = params.appended(new FlipX)
      case "y" => params = params.appended(new FlipY)
      case _ => throw new IllegalArgumentException(s"flip $curToken not supported")
    }
    consumeToken()
  }

  private def ParseInvert(): Unit = {
    assert(curToken == "--invert")
    params = params.appended(new Invert)
    consumeToken()
    //theres no 2nd param
  }

  private def ParseRotate(): Unit = {
    assert(curToken == "--rotate")
    consumeToken()

    params = params.appended(new Rotate(curToken.toInt))
    consumeToken()
  }

  private def ParseScale(): Unit = {
    assert(curToken == "--scale")
    consumeToken()

    params = params.appended(new Scale(curToken.toDouble))
    consumeToken()
  }

  private def ParseBrightness(): Unit = {
    assert(curToken == "--brightness")
    consumeToken()

    params = params.appended(new Brightness(curToken.toInt))
    consumeToken()
  }

  private def ParseInput(): Unit = {
    assert(curToken == "--image")
    consumeToken()

    params = params.appended(new InputLocation(curToken))
    consumeToken()
  }


  private def ParseOutput(): Unit = {
    assert(curToken == "--output-file" || curToken == "--output-console")
    curToken match {
      case "--output-file" =>
        consumeToken()
        params = params.appended(new OutputLocation(curToken))
      case "--output-console" => params = params.appended(new OutputConsole)
    }
    consumeToken()
  }
}
