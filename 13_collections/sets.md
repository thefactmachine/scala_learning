# Sets
This is collection of the same type that contains no duplicate elements.  By default, Scala uses the immutable Set.  If you want to use the mutable Set, you need to import the scala.collection.mutable.Set class explicitly.

Here is how to define Sets:

```
// Empty set
var s : Set[Int] = Set()

// Set of integer type
var s : Set[Int] = Set(1,3,5,7)

```

The basic operations on a set are **head** and **tail** and **isEmpty**.

## Concatenating Sets
You can use the ++ operator of Set.++() method to concatenate two or more sets.  But concatenating sets will remove duplicate elements.

```
val fruit1 = Set("apples", "oranges", "pears")
val fruit2 = Set("mangoes", "banana", "pears")
var fruit = fruit1 ++ fruit2
// Set(banana, apples, mangoes, pears, oranges)
```

## Finding minimum and maximum values.
These can be found by the Set.min and Set.max methods.

```
val numb = Set[Int](14, 12, 23, 5)
numb.max

```

## Finding Intersections
There are two methods:

```
val num1 = Set(5,6,9,20,30,45)
val num2 = Set(50,60,9,20,35,55)
// method 1
num1.&(num2)
// method 2
num1.intersect(num2)

```

