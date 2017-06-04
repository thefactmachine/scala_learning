# Anonymous Functions
Anonymous functions in source code are called function literals. And at run time these are instanciated into objects called function values.

```
var inc = (x:Int) => x+1
println(inc(8))
 
//Its possible to have multiple parameters
var mul = (x: Int, y: Int) => x*y
 
// its also possible to have no arguments. 
var userDir = () => { System.getProperty("user.dir") }

```