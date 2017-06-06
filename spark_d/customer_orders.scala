// spark-shell -i customer_orders.scala

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._


// Set the log level to only print errors
Logger.getLogger("org").setLevel(Level.ERROR)


def fn_parse_csv_line(line:String)= {
	// fields is a List of strings
	val fields = line.split(",")
	// return a tuple
	(fields(0).toInt, fields(2).toFloat)
}


val input = sc.textFile("/Users/markhatcher/transferred_from_5_tb_disk/scala_learning/spark_d/customer-orders.csv")

val parsed_lines = input.map(fn_parse_csv_line)

// count for lines_map is 10,000
val lines_map = parsed_lines.mapValues(x => x)

// count for key_totals = 100
val key_totals = lines_map.reduceByKey((x,y) => x + y)

val key_totals_sort = key_totals.sortBy(pair => pair._1)

// back to scala
val results = key_totals_sort.collect()

for (result <- results) {
    val shop_number = result._1
    val shop_total = result._2
    println(s"Shop number: \t $shop_number is equal to: \t $shop_total")
}


