# Partially Applied Functions
If you pass all the expected arguments, this is called a **fully applied** function.  If you send less than all arguments, you have a partially applied function.

You can bind some arguments and then fill in the rest later.

```
import java.util.Date
 
def log(date: Date, message: String) = {
      println(date + "----" + message)
}

// date receives the current time it was declared. 
val date = new Date
 
// so now logWithDateBound is a function with the
// date bound...but the second paramter is an unbound String.
val logWithDateBound = log(date, _ : String)
 
//now we can call this function with one argument...
 
logWithDateBound("message1" )

```
