# Lists
Lists are similar to arrays insofar that all elements have the same type.  But unlike arrays, lists have immutable elements.

The type of list has elements of type T and is written as List[T].

```
val fruit: List[String] = List("apples", "oranges", "pears");

```

## Understanding Cons
In Scala everything is a function call.  In Scala there are no primative types, So 5 is nothing buy Int(5) and 3 is stored as Int(3).  So, when we call 5 + 3, internally (5).+(3) is called.  The "+" is a method of Int(5).

### What above the : operator.
While the "+" method above is applied to the left operand. But in cases whose method ends with a colon (ie. :). In those cases, the method is invoked on the right operand.

This is shown below:

```
var names = List ("Roy","Randy","Amit")
var newNames = "Cindy" :: names
// the above is interpreted as names.::"Cindy"
println(newNames)
// results in: List(Cindy, Roy, Randy, Amit)
```

A more nested example is shown below:

```
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
// results in
List(apples, oranges, pears)

```

### Basic Operations on Lists
**head** is the first element.  **tail** are all elements except for the first.

### Concatenate a list (3 methods)


```
val fruit1 = "apples" :: ("oranges" :: ("pears" :: Nil))
val fruit2 = "mangoes" :: ("banana" :: Nil)

// method 1
var fruit_a = fruit1 ::: fruit2

// method 2 (Cant get this to work..??)
var fruit_b = fruit1.::: fruit2

// method 3 
var fruit_c = List.concat(fruit1, fruit2)

// List[String] = List(apples, oranges, pears, mangoes, banana)
```

## Uniform Lists
The following creates a list with with 3 "applies"
And using the **same** syntax, the number 2 is repeated 10 times.

```
val fruit = List.fill(3)("apples")
val num = List.fill(10)(2)

```

## Tabulate
```
val squares = List.tabulate(6)(n => n)
// squares: List[Int] = List(0, 1, 2, 3, 4, 5)

// n has no meaning...could be m
val squares = List.tabulate(6)(n => n * 2)
// squares: List[Int] = List(0, 2, 4, 6, 8, 10)

// not sure about this construct
val mul = List.tabulate( 2,3 )( _ * _ )   

```

## Reverse List Order
Just use **List.reverse** method.



