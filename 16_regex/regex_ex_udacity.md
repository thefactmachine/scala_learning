# Regex
Believe it or not this is the sytax

```
val theUltimateAnswer: String = "To life, the universe, and everything is 42."
val pattern = """.* ([\d]+).*""".r 

// this defines answerString
val pattern(answerString) = theUltimateAnswer

// the following prints "42"
println(answerString)

```
