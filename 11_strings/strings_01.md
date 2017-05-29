#Strings
The following are important methods of the **java.lang.String** class.

A string can be declared in two ways:

```
var greeting = "Hello World!";

var greeting:String = "Hello world!"

```
## Immutable Strings
The String class is immutable.  A String object once created cannot be changed. If there is a necessity to make a lot of modifications then use **String Builder Class** available in Scala.

## Accessor Methods
Methods used to obtain information about an object are known as accessor methods.  One accessor method that can be used is **length()**.  This is shown below:

### String Length

```
var testString:String = "Mark";
var len:Int = testString.length()

```

### String Concatenation
The String class includes a method for concatenating strings. b

```
string1.concat(string2);
"mark ".concat("Hatcher");

```

There is also the following method:

```
"Hello " + "World" + "!"
```

## Creating Format Strings
There is the printf() and format() methods to print output with formatted numbers.  The following shows how to use the printf() method.

See online example.

## String Interpolation
This feature is supported in versions of Scala 2.10 and later.  There are three types of interpolators.

### The 's' String Interpolator
Here is the most basic example:

```
val mark:String = "My Name";
println(s"Hi there $mark");

```
Prints "Hi there My Name"

---

Here is an example with calculation:

```
println(s"1 + 1 = ${1 + 1}") 

```
The above prints "1 + 1 = 2"

### The 'f' Interpolator
When using the 'f' interpolator, all variable references should be followed by the **printf** style format specifiers such as %d %i %f.

The following is an example:

```
// set to a double
val height = 1.9d
val name = "James"
println(f"$name%s is $height%2.3f metres tall")

```
The above prints "James is 1.900 metres tall"


The 'f' interpolator makes use of the String format utilities available in Java.  If there is no % character after variable reference, it will assume as %s String.

### The raw interpolator

```
println(raw"Result = \n a \n b")

```
The above will print:  "\n a \n b"

The following will print new lines:

```
println("Result = \n a \n b")
```













