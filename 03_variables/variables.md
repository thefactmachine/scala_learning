# Variables
Scala can define variables as values, constants or variables. Variables can change value and this is termed mutable. Imutable variables are declared with the keyword val.  Variables can be assigned an initial value but this is not mandatory.

```
// mutable
var myVar : String = "Foo"

// immutable
val myVal : String = "Foo"

```

## Variable Type Inference
The Scala compiler can determine the type of data.

```
var myVar = 10;
val myVal = "Hello, Scala!";

```

## Multiple Assignment
Here we are.  Not sure what the Pair function does.

```
val (myVar1: Int, myVar2: String) = Pair(40, "Foo")

```
## Variable Scope
Variables can exist as fields, method parameters and as local variables.

### Fields
These are variables that belong to an object.  The fields are accessible from inside every method in the object.  Fields can also be accessible outside the object dependingo on what access modifiers the field is declared with.

### Method Parameters
These are only accessible from inside the method but the objects passed in may be accessible from the outside, if you have a reference to the object from outside the method.  Method parameters are always immutable which are defined by the val keyword.

### Local Variables
These are variables defined in a method.  They are not visible outside the method unless they are returned. 



