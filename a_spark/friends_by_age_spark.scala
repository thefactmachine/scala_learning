// run this from command line
//  spark-shell -i friends_by_age_spark.scala 

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._
 
  /** A function that splits a line of input into (age, numFriends) tuples. */
  def parseLine(line: String) = {
      // Split by commas
      val fields = line.split(",")
      // Extract the age and numFriends fields, and convert to integers
      val age = fields(2).toInt
      val numFriends = fields(3).toInt
      // Create a tuple that is our result.
      (age, numFriends)
  }
  

   
// Set the log level to only print errors
Logger.getLogger("org").setLevel(Level.ERROR)
    
// Create a SparkContext using every core of the local machine
// val sc = new SparkContext("local[*]", "FriendsByAge")
// val sc = new SparkContext()

// Load each line of the source data into an RDD
// if a relative path is to be included, then it needs to be set from the spark context.
val lines = sc.textFile("/Users/markhatcher/transferred_from_5_tb_disk/scala_learning/a_spark/fakefriends.csv")

// can use the following... this is equal to 500
println("number of lines " + lines.count)

// Use our parseLines function to convert to (age, numFriends) tuples
// So rdd here is a big list of tuples  the first of these tuple_1 = age; tuple_2 = number of friends.
val rdd = lines.map(parseLine)

// print the first few lines of the RDD
println("Here is the first 5 lines of the RDD")
rdd.take(5).foreach(println)

// typical example output:

// (33,385), (26,2), (55,221), (40,465),  (68,21)



// Lots going on here...
// We are starting with an RDD of form (age, numFriends) where age is the KEY and numFriends is the VALUE
// We use mapValues to convert each numFriends value to a tuple of (numFriends, 1)
// Then we use reduceByKey to sum up the total numFriends and total instances for each age, by
// adding together all the numFriends values and 1's respectively.

// the mapValues phase
// typical output from:
// val totalsByAge = rdd.mapValues(x => (x, 1))
// (33,(385,1)), (26,(2,1)), (55,(221,1)), (40,(465,1)), (68,(21,1))

// the reduceByKey phase
// for each key (ie. age)...add the total friend; add the indicator variable (i.e. "1")
val totalsByAge = rdd.mapValues(x => (x, 1)).reduceByKey((x,y) => (x._1 + y._1, x._2 + y._2))


// here are some counts:
rdd.count == 500
totalsByAge.count == 52



// So now we have tuples of (age, (totalFriends, totalInstances))
// To compute the average we divide totalFriends / totalInstances for each age.
val averagesByAge = totalsByAge.mapValues(x => x._1 / x._2)
averagesByAge.count == 52

// Collect the results from the RDD (This kicks off computing the DAG and actually executes the job)
// does nothing really...just converts from RDD to Array of tuples.
val results = averagesByAge.collect()

// Sort and print the final results.
results.sorted.foreach(println)

    










  