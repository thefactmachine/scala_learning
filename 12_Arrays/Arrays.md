# Arrays
Arrays are a collection of variables of the same type.

The following declares an array of 3 strings:

```
var z:Array[String] = new Array[String](3)

// or

var z = new Array[String](3)


```

## Assigning Values
The following shows that values can be assigned using an expression:

```
z(0) = "Zara"; 
z(1) = "Nuha"; 
z(4/2) = "Ayan"
```

## Shorthand Declaring and Assigning

```
var z = Array("Zara", "Nuha", "Ayan")
```

## Processing Arrays
Here are some examples:

### Print all the elements
```
var myList = Array(1.9, 2.9, 3.4, 3.5)
// Print all the array elements
for ( x <- myList ) {
	println( x )
}
```
+64212671788
### Summing the elements
```
var myList = Array(1.9,2.9,3.4,3.5)
var total = 0.0;

for( i<- 0 to (myList.length-1)){
	total+=myList(i);
}

```

### Find the largest element
Insert this snippet to the above:

```
if (myList(i) > max) max = myList(i);

```

## Multidimensional Arrays
These are arrays whose elements are arrays.

Here is how to define a multi-dimensional array. The following is a 3 by 3 array of integers.

```
// declare
var myMatrix = ofDim[Int](3,3)
// assign
myMatrix(0,1) = 3;

```

## Concatenate Arrays
As follows:

```
var myList1 = Array(1.9, 2.9, 3.4, 3.5)
var myList2 = Array(8.9, 7.9, 0.4, 1.5)
var myList3 =  concat( myList1, myList2)
```

## Create Array with Range
The following creates an array that starts with 10 and finishes at 20 with a step of 2. So the elements will be 10, 12...18.  This uses **range(10,20,2)**.  If you want to go with 10 to 20 with a range of 1, then use **range(10, 20)**.







