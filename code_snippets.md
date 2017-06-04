# Code Snippets

## Manipulating collections with a parameterized data type
In the following we have two lists. The first list is of type string and the second list is of type integer.  We can find the first element with a generic function that accepts either strings or integers.

```
def firstElementInList[T](l: List[T]): T = l.head
 
val fruit: List[String] = List("apples", "oranges", "pears")
val numbers: List[Int] = List(10, 20, 30, 40)
 
println("first piece of fruit  " + firstElementInList(fruit))
println("first number  " + firstElementInList(numbers))

```

## Code Block
The following will print 30

```
println({val x = 10; x + 20}) 
```


