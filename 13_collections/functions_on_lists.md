# List Functions

## Using Map
The following reverses each string in the list.

```
val shipList = List("Enterprise", "Defiant", "Voyager", "Deep Space Nine")
val backwardShips = shipList.map( (ship: String) => {ship.reverse})
for (ship <- backwardShips) {println(ship)}  

```

The above prints:

esirpretnE
tnaifeD
regayoV
eniN ecapS peeD

## Using Reduce
Reduce iterates though the list.  The following adds: 1 + 2; then the result 3 is added to the next element 3 and then result is 6; then 6 is added to 4 and the result is 10 and finally 10 is added to 5 and the result is 15.

```
val numberList = List(1, 2, 3, 4, 5) 
val sum = numberList.reduce( (x: Int, y: Int) => x + y)
```

## Using Filter
Filter() can remove stuff that you don't want.  Firstly we remove 5 and then we remove 3 using a short-hand syntax.

```
val iHateFives = numberList.filter( (x: Int) => x != 5)
val iHateThrees = numberList.filter(_ != 3)
```

## Other Functions

```
val numberList = List(11, 9, 3, 14, 1) 
numberList.sorted
// List(1, 3, 9, 11, 14)

numberList.reverse
// List[Int] = List(1, 14, 3, 9, 11)

val dupList = List(3, 12, 3, 10, 12)
dupList.distinct
// List(3, 12, 10)

// min and max
numberList.max
numberList.min

dupList.contains(99)
// Boolean = false

```







