// run this from command line
//  spark-shell -i map_values_example.scala

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

// here we show Seq
// Seq gets these tuples and converts them into a list of tuples.

val lst_tuple_test = Seq(("maths", 50), ("maths", 60), ("english", 65))


// print the first element...expect ("maths", 50)
println(lst_tuple_test(0))

// print the second tuple element of third list item...expect 65
println(lst_tuple_test(2)._2)


// now we enter spark land
val inputrdd = sc.parallelize(Seq(("maths", 50), ("maths", 60), ("english", 65)))


// inputrdd is essentially an array of tuples.

// get the first two tuples and stor2 them into an array
val arr_test = inputrdd.take(2)

// print the second tuple...expect "("maths", 60)"
println(arr_test(1))


// this is inputrdd (inputrdd.foreach(println))

inputrdd.foreach(println)
// outputs the following
// (maths,50)
// (maths,60)
// (english,65)


val test_mapped_a = inputrdd.mapValues(mark => mark);
// results in:  (maths,50), (english,65), (maths,60)


val test_mapped_b = inputrdd.mapValues(mark => None);
// results in:  (maths, None), (english, None), (maths, None)


val test_mapped_c = inputrdd.mapValues(mark => 1);
// results in: (maths,1), (english,1), (maths,1)


// So this is what we know about mapValues()...
// it works on an array of tuples.  It returns an array of tuples.
// the first element of the input tuple is the key and this returned as the key
// the value to the right of => is returned as a value...

val mapped = inputrdd.mapValues(mark => (mark, 1));
// returns  (english,(65,1)), (maths,(60,1)), (maths,(50,1))


// x = Tuple(t),  y = Tuple(t + 1)...so this means that no matter how many elements in the input tuple
// reduceByKey will always only have x and y

// at the intial iteration x._1 = 65;  y._1 = 50.  And y._2 = 1
// the following adds the value tuple and groups the results by key...  
val reduced = mapped.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
// results in: (english,(65,1); (maths,(110,2))

val tt_1 = reduced.map(x => (x._1, x._2._1 / x._2._2)) 
// results in:  (maths, 55); (english, 65)
// note in maths...110 / 2 == 55

// this is the same as the above..but maybe more readable:
val average = reduced.map{x => val result = x._1; val tot = x._2._1; val count = x._2._2; (result, tot / count)}

// should be able to reformat the above as:
val ave = reduced.map{x => 
	val result = x._1; 
	val tot = x._2._1; 
	val count = x._2._2; 
	(result, tot / count)}

// converts back to Scala.  Array of tuples
val arr_result = average.collect()
