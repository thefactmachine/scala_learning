# Basic Scala Idioms
# mapvalues (to create key values)
We create an array of tuples and store this in an RDD. 

The first element of the tuple is the key and the remaining elements are values.

This is relected in the first example below

### To do
Map values only seems to work on arrays of paired tuples.  If I tried to extend this for a 3 value tuple it would fail ("maths", 50, 60)

(52,(3747,11))

```
// create an array or tuples
val inputrdd = sc.parallelize(Seq(("maths", 50), ("maths", 60), ("english", 65)))

val test_mapped_a = inputrdd.mapValues(mark => mark);
// results in:  (maths,50), (english,65), (maths,60)

val test_mapped_b = inputrdd.mapValues(mark => None);
// results in:  (maths, None), (english, None), (maths, None)

val test_mapped_c = inputrdd.mapValues(mark => 1);
// results in: (maths,1), (english,1), (maths,1)
```
## More than a two element tuple
```
val ina = sc.parallelize(Seq(("maths", (50, 40)), ("maths", (12, 30)), ("english", (50, 12))))

val test_mapped_a = ina.mapValues(mark => mark)
// (english,(50,12)), (maths,(12,30)), (maths,(50,40))

```



## reduceByKey (to create aggregates by key)
Firstly we use **map values** to create a tuple of (value, 1) pairs. 
Then we use **reduce by key** to aggregate the values by key value.

```
val mapped = inputrdd.mapValues(mark => (mark, 1));
// returns  (english,(65,1)), (maths,(60,1)), (maths,(50,1))

val reduced = mapped.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))
// results in: (english,(65,1); (maths,(110,2))

```

### reduceByKey (find the minimum and maximum values)
```
val minTempsByStation = stationTemps.reduceByKey( (x,y) => min(x,y))

```


## map (applying a function to values)
```
// We started with (english,(65,1); (maths,(110,2))
val tt_1 = reduced.map(x => (x._1, x._2._1 / x._2._2)) 

// the above results in: (maths, 55); (english, 65)
```

### Rewriting map more elegantly
```
val ave = reduced.map{x => 
	val result = x._1; 
	val tot = x._2._1; 
	val count = x._2._2; 
	(result, tot / count)}
```
### Applying map to a text file
The following extracts every 2nd element of a tabb delimited text file

```
val ratings = lines.map(x => x.toString().split("\t")(2))

```
### Applying map to restrict columns
The following returns two columns

```
val stationTemps = minTemps.map(x => (x._1, x._3.toFloat))

```
### Reversing columns

```
val wordCountsSorted = wordCounts.map( x => (x._2, x._1))
```
## filter
The following fiters all rows that are equal to "TMIN"

```
val minTemps = parsedLines.filter(x => x._2 == "TMIN")

```


## countByValue (frequency tabulation)
```
// we have ratings which is a list of numbers:
// such as 1, 2, 2, 2, 2, 3, 4, 4, 5.......
ratings.countByValue.foreach(println)
// this produces (1, 22332), (2, 33233)...(5, 494494)

```

## flatMap
The following receives paragraphs of words and then splits them up into individual words.  The resulting length of the data structure is equal to the total number of non-unique words.

```
val words = input.flatMap(x => x.split("\\W+"))

```

## sortByKey
The following flips around the columns and then sorts them by key.
```
val wordCountsSorted = wordCounts.map( x => (x._2, x._1)).sortByKey()
```

## sortBy (non key)
The following sorts by a non-key:

```
val key_totals_sort = key_totals.sortBy(pair => pair._1)
```

