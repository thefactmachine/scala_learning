# If Else
The following is a simple example:

## If statement
```
object Demo {
   def main(args: Array[String]) {
      var x = 10;

      if( x < 20 ){
         println("This is if statement");
      }
   }
}

```

## If Else Statement
The else statement executes if the Boolean expression is false.

```
object Demo {
   def main(args: Array[String]) {
      var x = 30;

      if( x < 20 ){
         println("This is if statement");
      } else {
         println("This is else statement");
      }
   }
}

```
## If-else-if-else
There is nothing really that surprising here.

```
if(Boolean_expression 1){
   //Executes when the Boolean expression 1 is true
} else if(Boolean_expression 2){
   //Executes when the Boolean expression 2 is true
} else if(Boolean_expression 3){
   //Executes when the Boolean expression 3 is true
} else {
   //Executes when the none of the above condition is true.
}

```
## Nested if-else
Nothing surprising here:

```
object Demo {
   def main(args: Array[String]) {
      var x = 30;
      var y = 10;
      
      if( x == 30 ){
         if( y == 10 ){
            println("X = 30 and Y = 10");
         }
      }
   }
}

```




