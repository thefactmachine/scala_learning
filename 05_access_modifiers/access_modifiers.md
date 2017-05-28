# Access Modifiers
Members of *packages, classes or objects* can be labeled with the access modifiers **private** and **protected**.  If these keywords are not used then **public** is assumed. 

## Private Members
A private member is visible only inside the class or object that contains the member definition.

The following shows an example:

```
class Outer {
   class Inner {
      private def f() { println("f") }
      
      class InnerMost {
         f() // OK can call outer from inner
      } // innerMost 
   } // inner
   (new Inner).f() // Error: cannot call inner from outer
} // outer

```

## Protected
A protected member is only accessible from subclasses of the class in which the member is defined.

```
package p {
   class Super {
      protected def f() { println("f") }
   }
   
   class Sub extends Super {
      f() // okay because Sub is a subclass of Super
   }
   
   class Other {
      (new Super).f() // Error: f is not accessible Other is not a subclass
   }
}

```


## Public Members
It is not required to specify the **Public** keyword for **Public** members.

```
class Outer {
   class Inner {
      def f() { println("f") }
      
      class InnerMost {
         f() // OK
      } // InnerMost
   } // innner
   (new Inner).f() // OK because now f() is public -- if private das ist nicht moglich
} // outer

```

## Scope of Protection
Access modifiers in Scala can be augmented with qualifiers.  A modifier of the form **private[X]** or **protected[X]** means that access is private or protected up to X.  Where X designates some enclosing package, class or singleton object.

```
package society {
   package professional {
      class Executive {
         private[professional] var workDetails = null
         private[society] var friends = null
         private[this] var secrets = null

         def help(another : Executive) {
            println(another.workDetails)
            println(another.secrets) //ERROR
         } // help
      } // executive
   } // professional
} // society
```

* The variable **workDetails** will be accessible to any class within the enclosing package professional.
* The variable **friends** will be accessible to any class within the enclosing package society.
* The variable **secrets** will be accessible only on the implicit object within instance methods (this).



















