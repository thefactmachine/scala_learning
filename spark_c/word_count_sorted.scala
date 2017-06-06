// spark-shell -i word_count_sorted.scala

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._


// Set the log level to only print errors
Logger.getLogger("org").setLevel(Level.ERROR)

// Load each line of my book into an RDD
// The line is actually a paragraph.
// input.count == 926
val input = sc.textFile("/Users/markhatcher/transferred_from_5_tb_disk/scala_learning/spark_c/book.txt")

// Split using a regular expression that extracts words
// words.count == 47801
// map is 1 row (input) to 1 row (output).
// flatmap is 1 row (input) to many rows (outout)
val words = input.flatMap(x => x.split("\\W+"))

// Normalize everything to lowercase
// lowercaseWords.count == 47801
val lowercaseWords = words.map(x => x.toLowerCase())

// Count of the occurrences of each word
// The first part: val word_test = lowercaseWords.map(x => (x, 1))
// Example output: (self,1); (employment,1); (building,1); (an,1)
// reduceByKey((x,y) => x + y ) =====> count by key
val wordCounts = lowercaseWords.map(x => (x, 1)).reduceByKey((x,y) => x + y )
// example output from wordCounts: (someone,62); (offering,16); (order,32)
// wordCounts.count == 4119


// The following just flips things around...
// For example..the output of the following is: (62,someone); (32,order)
// val wordCount_test = wordCounts.map( x => (x._2, x._1))


// Flip (word, count) tuples to (count, word) and then sort by key (the counts)
val wordCountsSorted = wordCounts.map( x => (x._2, x._1)).sortByKey()

// Print the results, flipping the (count, word) results to word: count as we go.
for (result <- wordCountsSorted) {
  val count = result._1
  val word = result._2
  println(s"$word: $count")
}
