package CodingUtils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AssertUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 20/01/18 00:24
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"WeakerAccess", "unused", "ConstantConditions"})
public class AssertUtils
{
    //region --------------- assert not null (x2) ------------------------

    /**
     <hr>
     <h2>Tests if the parameters are null</h2>
     <h3>If one of them is —> throws IllegalArgumentException, with index of first null object as message.</h3>
     <br>
     Note : asserts [array] isn't null.<br>
     <br>
     <hr>

     @param array Array of T objects to test for null value
     */
    @Contract ("null -> fail")
    @SafeVarargs
    public static <T> void assertNotNull (T... array)
    {
        if (array == null) throw new IllegalArgumentException("List of Objects is null");

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == null) throw new IllegalArgumentException("Element at index " + i + " is null");
        }
    }

    /**
     <hr>
     <h2>Tests if param is null</h2>
     <h3>If it is —> throws IllegalArgumentException<br></h3>
     <hr>

     @param t The ‹T› object to test for null value
     */
    @Contract ("null-> fail")
    public static <T> void assertNotNull (T t)
    {
        if (t == null) throw new IllegalArgumentException("Param is null");
    }
    //endregion

    //region --------------- assert not empty (x3) -----------------------

    /**
     <hr>
     <h2>Tests if [string] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note : already asserts [string] isn't null.<br>
     <br>
     <hr>

     @param string The String to test for empty value
     */
    public static void assertNotEmpty (@NotNull String string)
    {
        if (string == null) throw new IllegalArgumentException("String is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String is empty");
    }

    /**
     <hr>
     <h2>Tests if [list] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note : already asserts [list] isn't null.<br>
     <br>
     <hr>

     @param collection The List to test for empty value
     */
    public static void assertNotEmpty (@NotNull Collection collection)
    {
        if (collection == null) throw new IllegalArgumentException("Collection is null");
        if (collection.isEmpty()) throw new IllegalArgumentException("List is empty");
    }

    /**
     <hr>
     <h2>Tests if [map] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note : already asserts [map] isn't null.<br>
     <br>
     <hr>

     @param map The Map to test for empty value
     */
    public static void assertNotEmpty (@NotNull Map map)
    {
        if (map == null) throw new IllegalArgumentException("Map is null");
        if (map.isEmpty()) throw new IllegalArgumentException("Map is empty");
    }
    //endregion

    //region --------------- assert strictly positive (x1) ---------------

    /**
     <hr>
     <h2>Tests if [val] is > 0</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     <hr>

     @param val The value to test for strict positivity
     */
    public static void assertStrictlyPositive (double val)
    {
        if (val <= 0) throw new IllegalArgumentException("Value is not strictly positive");
    }
    //endregion
}