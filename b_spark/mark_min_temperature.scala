// spark-shell -i mark_min_temperature.scala
import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
import scala.math.min


def parseLine(line:String)= {
	// fields is a List of strings
	val fields = line.split(",")
	val stationID = fields(0)
	val entryType = fields(2)
	// convert from string to float...then convert to fahrenheight
	val temperature = fields(3).toFloat * 0.1f * (9.0f / 5.0f) + 32.0f
	// return a tuple
	(stationID, entryType, temperature)
}


// set logging to errors only
Logger.getLogger("org").setLevel(Level.ERROR)

// Read each line of input data
val lines = sc.textFile("/Users/markhatcher/transferred_from_5_tb_disk/scala_learning/b_spark/1800.csv")

// Convert to (stationID, entryType, temperature) tuples
val parsedLines = lines.map(parseLine)

// Filter out all but TMIN entries
// this is collection of tuples...example tuple:
// (ITE00100554,TMIN,5.3600006)
val minTemps = parsedLines.filter(x => x._2 == "TMIN")


// Convert to (stationID, temperature)
// this returns a tuple in the format: (ITE00100554,5.3600006)
// length of stationTemps = 730
val stationTemps = minTemps.map(x => (x._1, x._3.toFloat))


// Reduce by stationID retaining the minimum temperature found
// We spin through all keys and get the minimum for each key
// there are only two keys (station ids) so we get only two entries here
// minTempsByStation.count == 2
val minTempsByStation = stationTemps.reduceByKey( (x,y) => min(x,y))

// Collect, format, and print the results
val results = minTempsByStation.collect()

for (result <- results.sorted) {
   val station = result._1
   val temp = result._2
   val formattedTemp = f"$temp%.2f F"
   println(s"$station minimum temperature: $formattedTemp") 
}

