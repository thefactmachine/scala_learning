def addInt(a: Int = 5, b: Int = 7): Int = {
  var sum: Int = 0
  sum = a + b
  return sum
}


var inc = (x: Int) => x + 1
var x = inc(7) - 1
var mul = (x: Int, y: Int) => x * y
println(mul(3, 4))
var userDir = () => { System.getProperty("user.dir") }
println(userDir()




def apply(f: Int => String, v: Int) = f(v)
def layout[A](x: A) = "[" + x.toString() + "]"
println(apply(layout, 10))


println(s"1 + 1 = ${1 + 1}") 


object Demo {
   def main(args: Array[String]) {
      println(s"Result = \n a \n b")
   }
}


object Demo {
   def main(args: Array[String]) {
      println(raw"Result = \n a \n b")
   }
}