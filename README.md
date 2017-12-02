<h1>Coding Utils : 
<a href="https://www.codefactor.io/repository/github/alexbolot/codingutils"><img src="https://www.codefactor.io/repository/github/alexbolot/codingutils/badge" /></a>
</h1> 

<h3>1. ArrayList8 (extends java.util.ArrayList)</h3>

This class extends java.util.ArrayList. <br>
Its name is due to the methods it add : suiting Java8 <br>
It allows easier list management using Predicates and Comparators (replacing .filter and .collect) <br> 
The main goal here is to make the code clearer by replacing heavy lines like <br>
`myList.stream().filter(...).collect(...)` <br>
by <br>
`myList.subList(...)`

<b>Exemple :</b>
```
public E min (Comparator‹E› comparator)
public E max (Comparator‹E› comparator)
public E findFirst (Predicate‹E› filter)
public int countIf (Predicate‹E› filter)
public ArrayList8 subList (Predicate‹E› filter)
public boolean addIf (E value, Predicate‹E› filter)
```
<hr>
<br>

<h3>2. AssertUtils</h3>

This class contains methods used to test values.<br>
When calling those asserting methods :<br>
- if assertion is true, nothing happens, process goes on.
- if assertion is false, throws <b>IllegalArgumentException</b> with a custom message.<br>
Note : it can be usefull as feedback for the user (ex : "Name is empty"). 

<b>Exemple :</b>
```
public void assertNotEmpty (List list)
public void assertNotEmpty (String string)
public void assertNotNull (Object... objects)
public void assertStrictlyPositive (double value)
```

<hr>
<br>

<h3>3. FormatUtils</h3>

<b>Exemple :</b>
```
public String toFirstUpperCase (String string)
public ‹T› void printArrayFancy (T[] array, String start, String separator, String end)
public ‹T› void printListFancy (List‹T› list, String start, String separator, String end)
    
    exemple : list       = {a, b, c}
              start      = "(("
              separator  = " - "
              end        = "))"
                
    result :  ((a - b - c))

```

<hr>
<br>

<h3>4. NumberUtils</h3> 

This class contains mehtods used to parse strings or get min/max from Collections.<br>

<b>Find if value is parseable or directly parse it</b>
```
public int tryParseInt (String string)      //Also exists for float and double
public boolean isInteger (String string)    //Also exists for float and double
```

<b>Find if a value is between a min and a max</b> (both excluded)
```
public boolean isInBounds (double min, double value, double max)
public boolean isInBounds (T min, T value, T max)   //with ‹T extends Comparator‹T››
public boolean isInBounds (T min, T value, T max, Comparator‹T› comparator)
```

<b>Find min value of an Array or Collection</b>
```
public int min (int[] array)    //Also exists for float and double
public T min (T[] array)        //with ‹T extends Comparator‹T››
public T min (T[] array, Comparator‹T› comparator)
public T min (Collection‹T› collection) //with ‹T extends Comparator‹T››
public T min (Collection‹T› collection, Comparator‹T› comparator)
``` 

<b>Find max value of an Array or Collection</b>
```
public int max (int[] array)    // Also exists for float and double
public T max (T[] array)        // with ‹T extends Comparator‹T››
public T max (T[] array, Comparator‹T› comparator)
public T max (Collection‹T› collection) // with ‹T extends Comparator‹T››
public T max (Collection‹T› collection, Comparator‹T› comparator)
```