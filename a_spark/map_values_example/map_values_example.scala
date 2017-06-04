# 



val inputrdd = sc.parallelize(Seq(("maths", 50), ("maths", 60), ("english", 65)))


val mapped = inputrdd.mapValues(mark => (mark, 1));


val reduced = mapped.reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2))


scala> val average = reduced.map { x =>
     |                      val temp = x._2
     |                      val total = temp._1
     |                      val count = temp._2
     |                      (x._1, total / count)
     |                      }


average.collect()


