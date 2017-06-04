# Option
A Scala Option[T] is a container for zero or one element of a given type.

An Optio[T] can be either Some[T] or None object.

The None can be compared to Java's null.

```
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

// this returns: Some(Paris)
println(capitals.get("France"))

// this returns: None
println(capitals.get("NoWhere"))

```

## Using Pattern Matching
```
val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

def show(x: Option[String]) = x match {
      case Some(s) => s
      case None => "Not found mate"
  }

// returns "Tokyo"
println(show(capitals.get("Japan")))

// returns "Not found mate"
println(show(capitals.get("India")))

```

## Using getOrElse() Method
This shows how to do it:

```
val option_mit_value:Option[Int] = Some(5)
val option_ohne_value:Option[Int] = None 

// prints 5
println(option_mit_value.getOrElse(99))

// prints 5564
println(option_ohne_value.getOrElse(5564))

```

## isEmpty() Method
This follows from the previous data set.

```
// following is true
option_ohne_value.isEmpty
// following is false
option_mit_value.isEmpty
```





