# Maps
A Scala map is a collection of key / value pairs. Any value can be retrieved based on its key.  Maps are also called Hash tables. Scala has mutable and immutable Maps, the default is immutable.

```
// Empty hash table whose keys are strings and values are integers:
var A:Map[Char,Int] = Map()

// A map with keys and values.
val colors = Map("red" -> "#FF0000", "azure" -> "#F0FFFF")

```

When defining an empty map, the type annotation is necessary as the system needs to assign a concrete type to the variable.

If we want to add a key-value pair, we can use the operator + as follows:

```
var A:Map[Char,Int] = Map()
A += ('I' -> 1)
A += ('Z' -> 12)

```

## Consolidated Map Example Code
```
// one way of declaring a map
var mapAge:Map[String, Int] = Map()
mapAge = Map("mark" -> 30, "susan" -> 35, "fred" -> 5)

// another way of declaring a Map
var mapAgeA = Map("fred" -> 23, "michelle" -> 13)
 
 // adding an element to an array
mapAge += ("newbie" -> 45)
 
// concatenate two maps (method 1)
var mapBigMap = mapAge ++ mapAgeA

// concatenate two maps (method 2)
var mapBigMapA = mapAge.++(mapAgeA)
 
// iterate through a map
mapAge.keys.foreach{n => println(n + " " + mapAge(n))}

// using contains
println("this should be true " + mapAge.contains("mark"))

```
