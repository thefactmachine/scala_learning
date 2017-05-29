# Closures
A closure is a function whose return value depends on the value of one or more variables declared outside this function.

This is shown in the following code:

```
object Demo {
   def main(args: Array[String]) {
      println( "multiplier(1) value = " +  multiplier(1) )
      println( "multiplier(2) value = " +  multiplier(2) )
   }
   var factor = 3
   val multiplier = (i:Int) => i * factor
}

```

## Running this code within command line Scala
Run the Scala command line by typing in **scala**  Then type in **:paste** Then paste the first block of code above.

Now to run the mulitiplier method within the singleton object Demo, type the following:

```
Demo.multiplier(2)
```
And the answer is 6.



