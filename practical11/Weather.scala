import scala.io.Source

object Weather  {
    def main(args : Array[String]) : Unit = {
        val filename = "weatherHistory.csv"

        val lines = Source.fromFile(filename).getLines()

        //map

        val data = lines.map(line => {
            val fields = line.split(",")
            val temparature  = fields(3).toDouble,
            val dewPoint = fields(4).toDouble
            val windSpeed = fields(6).toDouble
            (temperature, dewPoint, windSpeed)
        })

        //reduce

        val (tempSum, dewPointSum, windSpeedSum, count) = data.foldLeft((0.0, 0.0,0.0, 0)) {
            case ((tempAcc, dewPointAcc, windSpeedAcc, countAcc), (temperature, dewPoint, windSpeed)) => (tempAcc + temperature, dewPointAcc + dewPoint, windSpeedAcc + windSpeed, countAcc + 1)
        }

        val avgTemp = tempSum / count
        val avgDewPoint = dewPointSum / count
        val avgWindSpeed = windSpeedSum / count

        println(s"Avg temp : $avgTemp")
        println(s"Avg temp : $avgDewPoint")
        println(s"Avg temp : $avgWindSpeed")

    }
}