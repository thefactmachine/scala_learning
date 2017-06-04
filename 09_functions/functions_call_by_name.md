# Functions call by name
Typically arguments to functions are by-value parameters.  That is the value of the parameter is determined before it is passed to the function.

Call-by-name enables an expression that not evaluated until it is called within the function.

This is shown as follows:

```
def time() :Long = {
	println("Getting time in nano seconds")
	return System.nanoTime
}

def delayed( t: => Long ) = {
	println("In delayed method")
	println("Param: " + t)
}

delayed(time());

```
The function time() is passed to delayed(). In the defintion for time(), it is not necessary to declare a return time.  We could have just defined:

```
def time() = {...
```

The output from this is:

* "In delayed Method"
* "Getting time in nano seconds
* Param: 29292929292



