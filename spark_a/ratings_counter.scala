import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

// run this from command line
//  spark-shell -i ratings_counter.scala

// Ratings Histogram walkthrough
// https://www.udemy.com/apache-spark-with-scala-hands-on-with-big-data/learn/v4/t/lecture/5364924?start=0
// data from here:  https://grouplens.org/datasets/movielens/100k/

/** Count up how many of each star rating exists in the MovieLens 100K data set. */


// format of data is four fields:
// movieID, UserID, Rating, timestamp


   
// Set the log level to only print errors
Logger.getLogger("org").setLevel(Level.ERROR)
    

// Load up each line of the ratings data into an RDD
val lines = sc.textFile("/Users/markhatcher/transferred_from_5_tb_disk/scala_learning/a_spark/u.data")
lines.count == 100000


// Convert each line to a string, split it out by tabs, and extract the third field.
// (The file format is userID, movieID, rating, timestamp)

// ratings is an RDD
val ratings = lines.map(x => x.toString().split("\t")(2))

// print the first 10
ratings.take(10).foreach(println)

// Count up how many times each value (rating) occurs
// results is a map...it has five elements.
val results = ratings.countByValue()

// Sort the resulting map of (rating, count) tuples
val sortedResults = results.toSeq.sortBy(_._1)

// Print each result on its own line.
sortedResults.foreach(println)


