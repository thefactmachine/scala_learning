# Loop Statements
Loop control statements change execution from the normal sequence. When execution leaves a scope, all automatic objects that were created in that scope are destroyed.

## The Infinite Loop (While)
This is best implemented using the **while** statement.

```
object Demo {
   def main(args: Array[String]) {
      var a = 10;
      
      // An infinite loop.
      while( true ){
         println( "Value of a: " + a );
      }
   }
}
```

## do while loop
This runs at least once.

```
object Demo {
   def main(args: Array[String]) {
      // Local variable declaration:
      var a = 10;

      // do loop execution
      do {
         println( "Value of a: " + a );
         a = a + 1;
      }
      while( a < 20 )
   }
}

```

## for loop
This executes a specific number of times.  The left-arrow operator is called a generator.

```
object Demo {
   def main(args: Array[String]) {
      var a = 0;
      
      // for loop execution with a range
      for( a <- 1 to 10){
         println( "Value of a: " + a );
      }
   }
}
```

The above prints 1 through to 10  (inclusive).

### until keyword
```
object Demo {
   def main(args: Array[String]) {
      var a = 0;
      
      // for loop execution with a range
      for( a <- 1 until 10){
         println( "Value of a: " + a );
      }
   }
}
```
The above will print 1 to 9 (inclusive).

### multiple ranges - semi colon
The following shows how this works. 

```
object Demo {
   def main(args: Array[String]) {
      var a = 0;
      var b = 0;
      
      // for loop execution with a range
      for( a <- 1 to 3; b <- 1 to 3){
         println( "Value of a: " + a );
         println( "Value of b: " + b );
      }
   }
}

```
So when this runs it first runs with a = 1 and cycles through the values for b (1 to 3). So there are 3 iterations here.  Then we move to a = 2 and then b = 3.  So, there are a total of 3 * 3 = 9 iterations.  Within the body of the loop each value is printed out twice.  So there will be 9 * 2 = 18 lines printed. 


### for loop with collections
The following is pretty obvious:

```
object Demo {
   def main(args: Array[String]) {
      var a = 0;
      val numList = List(1,2,3,4,5,6);

      // for loop execution with a collection
      for( a <- numList ){
         println( "Value of a: " + a );
      }
   }
}
```
### for loop with filters
Scala's for loop allows you to filter out some elements using one or more if statements.  To add more than one filter to a 'for' expression, separate the filters with semicolons(;).  And 'and' conjunction is put in the place of expressions.

```
object Demo {
   def main(args: Array[String]) {
      var a = 0;
      val numList = List(1,2,3,4,5,6,7,8,9,10);

      // for loop execution with multiple filters
      for( a <- numList
           if a != 3; if a < 8 ){
         println( "Value of a: " + a );
      }
   }
}
```

The above produces 1, 2, 4, 5, 6, 7

### yield and for loops
This really is nice litte piece of code.

```
object Demo {
   def main(args: Array[String]) {
      var a = 0;
      val numList = List(1,2,3,4,5,6,7,8,9,10);

      // for loop execution with a yield
      var retVal = for{ a <- numList if a != 3; if a < 8 }yield a

      // Now print returned values using another loop.
      for( a <- retVal){
         println( "Value of a: " + a );
      }
   }
}

```














