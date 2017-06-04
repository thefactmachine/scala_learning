# Tuple
Unlike an array or a list, a tuple can hold objects with a different type.
But the objects are not mutable.

## Upper limit on number of fields
This is 22.

## How to declar a tuple
The following shows two methods:

```
val test_tuple = (1, "hello", Console)

// you actually need to put in the 3
val new_tuple = new Tuple3(1, "hello", 54)

```

## How to access a tuple element
The following is quite weird syntax:

```
println(new_tuple._2)
```

## How to iterate over a tuple
The following will print out 1, hello and 54 on a separate line.

```
val new_tuple = new Tuple3(1, "hello", 54)
new_tuple.productIterator.foreach{ i => println(i)}
```