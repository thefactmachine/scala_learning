# Syntax
## Interactive Mode
Type in "scala" in the terminal to setup an interactive session. You can type: "println("Hello Scala!")" 
## Script Mode
Create a code block such as: (notice the backticks for markdown underneath the tilda key)

```
object HelloWorld {
   /* This is my first java program.   
   * This will print 'Hello World' as the output
   */
   def main(args: Array[String]) {  
      println("Hello, world!") // prints Hello World
   }
}
```
So to actually run this. We first need to compile it.  "scalac HelloWorld.scala" and then this will generate a few class files.  We then need to run "HelloWorld.class" and this is run using the scala command "scala HelloWorld".

## Basic Syntax
**Class Names** The first letter should be capitalised

**Method Names** Camel case with the initial letter being lower case

**File name** This should match the object name  .scala should be appended to the end.

**def main(args: Array[String])** Scala processing starts from the main() method which is mandatory for each Scala program.

## Comments
These are // for single line multiline are the same as java.

## Scala Packages
This is a named module of code.  The pakcage declaration is the first non-comment line in the source file. Such as:

package com.liftcode.stuff

### Importing Packages
THe following imports the contents of the scala.xml package.

```
import scala.xml._
```

The following imports a **single object** HashMap from the scala.collection.mutable package:

```
import scala.collection.mutable.HashMap
```
You can import more than one class or object using the following:

```
import scala.collection.immutable.{TreeMap, TreeSet}
```

## Apply Dynamic
This has not been done <span style="color:red">This is a bit tricky and needs to be done</span>.






