import scala.io.Source

object Weather {
    def main(args : Array[String]) : Unit = {
        val file = "wea.csv"

        val lines = Source.fromFile(file).getLines()
    

    val data = lines.map(line => {
        val fields = line.split(",")
        val temp = fields(3).toDouble
        val dew = fields(4).toDouble
        val wind = fields(6).toDouble

        (temp, dew, wind)
    })

    val (tempSum, dewSum, windSum, count) = data.foldLeft((0.0, 0.0, 0.0, 0)) {
        case ((tempAcc, dewAcc, windAcc, countAcc), (temp, dew, wind)) =>
        (tempAcc + temp, dewAcc + dew, windAcc + wind, countAcc+1)
    }

    val avgTemp = tempSum / count

    println(s"Avg temp $avgTemp")

    }
}