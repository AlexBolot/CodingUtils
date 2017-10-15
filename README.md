<h1>Coding Utils :</h1>

<h3>1. AssertUtils</h3>

This class contains methods used to test values.<br>
When calling those asserting methods :<br>
- if assertion is true, nothing happens, process goes on.
- if assertion is false, throws <b>IllegalArgumentException</b> with a custom message.<br>
It can be usefull as feedback for the user (ex : "Name is empty"). 

Exemple :
<pre>
public void assertNotEmpty (List list)
public void assertNotEmpty (String string)
public void assertNotNull (Object... objects)
</pre>

<hr>

<h3>2. FormatUtils</h3> 

This class contains mehtods used to format or print things.<br>

Exemple : 
<pre>
public int tryParseInt (String string)
public boolean isInteger (String string)
public String toFirstUpperCase (String string)
</pre> 
