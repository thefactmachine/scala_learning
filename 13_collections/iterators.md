# Iterators
An iterator is not a collection but a way to access the elements of a collection.

The two basic operatons are next and hasNext.

An iterator can only be traversed once.

```
val it = Iterator("a", "number", "of", "words")
while (it.hasNext){
	println(it.next())
}
```

## Finding the Min and Max Valued Element
In the following it_max and it_min perform two different operations because the iterator can only be used once.

```
val ita = Iterator(20,40,2,50,69, 90)
val itb = Iterator(20,40,2,50,69, 90)
println(ita.max)
println(itb.min)

```

## Length of the Iterator
You can use either the **it.size** or **it.length** methods to find out the number of elements in an iterator.







