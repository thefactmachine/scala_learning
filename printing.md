# Printing
```
val pi : Double = 3.14159265 
println(f"Pi is about $pi%.3f") 
```
This prints "Pi is about 3.142"

## Padding with leading zeros
```
val numberOne : Int = 10  
println(f"Zero padding on the left: $numberOne%05d")
```

## Variable Substitution
```
println(s"I can use the s prefix to use variables like $numberOne")
```
The above will print:

"I can use the s prefix to use variables like 10"

## Printing Expressions
```
println(s"The s prefix isn't limited to variables  ${1+2}")
// prints: "The s prefix isn't limited to variables  3"

// you can also include variables. Like the one below:
println(s"The s prefix isn't limited to variables  ${1+ numberOne}")
```

