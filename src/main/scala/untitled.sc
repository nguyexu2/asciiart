
val numberString = "- 3 + 4 - 1 + 1 + 12 - 5  + 6"

val abc: List[String] = numberString.split("\\s+").toList

var temp = 0


for (i <- abc.indices) {
  abc(i) match {
    case "+" => temp += abc(i + 1).toInt
    case "-" => temp -= abc(i + 1).toInt
    case x if x.forall(_.isDigit) => println("im a number ")

    case _ => throw new Exception("wrong opperator")
  }
}

print(temp)
