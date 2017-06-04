# Functions as parameters

We first define a very simple function:

```
def squareIt(x: Int) : Int = x * x

```

We now define a function that accepts another function is an input.
In the following,  the function "f" is defined.  It accepts an integer and returns an integer.

Notice that the body of the function below is a single line and therefore does
not require curly braces.

The "transformInt" function simply calls the second argument (i.e. a function) and passes in the first argument (i.e. x).

```
def transformInt(x: Int, f: Int => Int) : Int = f(x)

```

So, now we have set things up.  So, in the following we call transformInt().

```
// this returns 8
transformInt(2, cubeIt) 
```

## Declaring with an Anonymous Function

```
// the following prints out 5
transformInt(10, x => x / 2) 

```

The following is a little bit more tricky....

The portion **val y = x * 2**  gets x which is 2, then this is multiplied 
by 2 and stored in y - the value for y is 4. Then y is squared.

```
transformInt(2, x => {val y = x * 2; y * y}) 

```






