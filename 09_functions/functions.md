# Functions
Scala has both functions and methods and there is only a small difference between the two. A Scala method is a part of class; while a function in Scala is a complete object which can be assigned to a variable.

A function can appear anywhere in a source file and Scala permits nested function definitions.

## Defining and calling a function

Notice in the code below, how a return type is defined in the function definition. 

```
object Demo {
   def main(args: Array[String]) {
      println( "Returned Value : " + addInt(5,7) );
   }
   
   def addInt( a:Int, b:Int ) : Int = {
      var sum:Int = 0
      sum = a + b

      return sum
   }
}
```

## Functions that do not return anything
Functions that do not return anything are declared with the **Unit** keyword.  This is shown below:

```
object Hello{
   def printMe( ) : Unit = {
      println("Hello, Scala!")
   }
}

```

