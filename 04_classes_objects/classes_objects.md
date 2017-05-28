# Classes and Objects

The following is how to define a basic class:

```
class Point(xc: Int, yc: Int) {
   var x: Int = xc
   var y: Int = yc

   def move(dx: Int, dy: Int) {
      x = x + dx
      y = y + dy
      println ("Point x location : " + x);
      println ("Point y location : " + y);
   }
}
```
You can then create an instance of the class using new. 
And then you can call a method.  This is shown below:

```
      val pt = new Point(10, 20);
       pt.move(10, 10);

```

## Extending a class
You can extend a class using the **extend** keyword.  Extend  makes the subclass inherit all non-private members from the superclass.  In Scala method overriding requires the **overide** keyword. 
In the following: Location inherits from Point.

```
import java.io._

class Point(val xc: Int, val yc: Int) {
   var x: Int = xc
   var y: Int = yc
   
   def move(dx: Int, dy: Int) {
      x = x + dx
      y = y + dy
      println ("Point x location : " + x);
      println ("Point y location : " + y);
   }
}

class Location(override val xc: Int, override val yc: Int,
   val zc :Int) extends Point(xc, yc){
   var z: Int = zc

   def move(dx: Int, dy: Int, dz: Int) {
      x = x + dx
      y = y + dy
      z = z + dz
      println ("Point x location : " + x);
      println ("Point y location : " + y);
      println ("Point z location : " + z);
   }
}

object Demo {
   def main(args: Array[String]) {
      val loc = new Location(10, 20, 15);

      // Move to a new location
      loc.move(10, 10, 5);
   }
}
```
In the above. The definition for class location uses the overide keyword to explicitly overide the superclasses constructor variables.


## Implicit Classes
Not sure about this.  Need to look example again.

## Singleton Objects
A singleton is a class that can have only one instance..i.e object.  You create a singleton using the keyword **object**. 
 







 
