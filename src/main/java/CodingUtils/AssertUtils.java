package CodingUtils;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AssertUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 07/10/17 01:51
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import java.util.List;
import java.util.Map;

@SuppressWarnings ({"WeakerAccess", "unused"})
public class AssertUtils
{
    //region ==================== assert not null (x2) =============================

    /**
     <hr>
     <h2>Tests if the parameters are null</h2>
     <h3>If one of them is —> throws IllegalArgumentException.</h3>
     Note : <i>getMessage()</i> of the IAE contains the index of the first null object found.<br>
     <br>
     <hr>

     @param objects List of Objects to test for null value
     */
    public static void assertNotNull (Object... objects) throws IllegalArgumentException
    {
        for (int i = 0; i < objects.length; i++)
        {
            Object obj = objects[i];
            if (obj == null) throw new IllegalArgumentException("Object at index " + i + " is null");
        }
    }

    /**
     <hr>
     <h2>Tests if [object] is null</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note 1 : <i>getMessage()</i> of the IAE contains [objectName].<br>
     Usefull to show as feedback for the user.<br>
     <br>
     Note 2 : already asserts [objectName] isn't null.<br>
     <br>
     <hr>

     @param object     The object to test for null value
     @param objectName Name of the object, used in the IllegalArgumentException
     */
    public static void assertNotNull (Object object, String objectName) throws IllegalArgumentException
    {
        assertNotEmpty(objectName, objectName);

        if (object == null) throw new IllegalArgumentException(objectName + " is null");
    }
    //endregion

    //region ==================== assert not empty (x6) ============================

    /**
     <hr>
     <h2>Tests if [string] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note : already asserts [string] isn't null.<br>
     <br>
     <hr>

     @param string The String to test for empty value
     */
    public static void assertNotEmpty (String string) throws IllegalArgumentException
    {
        assertNotNull(string, "string");

        if (string.isEmpty()) throw new IllegalArgumentException("String is empty");
    }

    /**
     <hr>
     <h2>Tests if [string] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note 1 : <i>getMessage()</i> of the IAE contains [stringName].<br>
     Usefull to show as feedback for the user.<br>
     <br>
     Note 2 : already asserts [string] and [stringName] aren't null.<br>
     <br>
     <hr>

     @param string     The String to test for empty value
     @param stringName The name of the String, used in the IllegalArgumentException
     */
    public static void assertNotEmpty (String string, String stringName) throws IllegalArgumentException
    {
        assertNotNull(stringName, "stringName");
        assertNotNull(string, stringName);

        if (string.isEmpty()) throw new IllegalArgumentException(stringName + " is empty");
    }

    /**
     <hr>
     <h2>Tests if [list] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note : already asserts [list] isn't null.<br>
     <br>
     <hr>

     @param list The List to test for empty value
     */
    public static void assertNotEmpty (List list) throws IllegalArgumentException
    {
        assertNotNull(list, "list");

        if (list.isEmpty()) throw new IllegalArgumentException("List is empty");
    }

    /**
     <hr>
     <h2>Tests if [list] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note 1 : <i>getMessage()</i> of the IAE contains [listName].<br>
     Usefull to show as feedback for the user.<br>
     <br>
     Note 2 : already asserts [list] and [listName] aren't null.<br>
     <br>
     <hr>

     @param list     The List to test for empty value
     @param listName The name of the List, used in the IllegalArgumentException
     */
    public static void assertNotEmpty (List list, String listName) throws IllegalArgumentException
    {
        assertNotNull(listName, "listName");
        assertNotNull(list, listName);

        if (list.isEmpty()) throw new IllegalArgumentException(listName + " is empty");
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
    public static void assertNotEmpty (Map map) throws IllegalArgumentException
    {
        assertNotNull(map, "map");

        if (map.isEmpty()) throw new IllegalArgumentException("Map is empty");
    }

    /**
     <hr>
     <h2>Tests if [map] is empty</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note 1 : <i>getMessage()</i> of the IAE contains [mapName].<br>
     Usefull to show as feedback for the user.<br>
     <br>
     Note 2 : already asserts [map] and [mapName] aren't null.<br>
     <br>
     <hr>

     @param map     The Map to test for empty value
     @param mapName The name of the Map, used in the IllegalArgumentException
     */
    public static void assertNotEmpty (Map map, String mapName) throws IllegalArgumentException
    {
        assertNotNull(mapName, "mapName");
        assertNotNull(map, mapName);

        if (map.isEmpty()) throw new IllegalArgumentException(mapName + " is empty");
    }
    //endregion

    //region ==================== assert strictly positive (x4) ====================

    /**
     <hr>
     <h2>Tests if [val] is > 0</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     <hr>

     @param val The value to test for strict positivity
     */
    public static void assertStrictlyPositive (int val) throws IllegalArgumentException
    {
        if (val <= 0) throw new IllegalArgumentException("Value is not strictly positive");
    }

    /**
     <hr>
     <h2>Tests if [val] is > 0</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note 1 : <i>getMessage()</i> of the IAE contains [valueName].<br>
     Usefull to show as feedback for the user.<br>
     <br>
     Note 2 : already asserts [valueName] isn't null or empty.<br>
     <br>
     <hr>

     @param val       The value to test for strict positivity
     @param valueName The name of the value, used in the IllegalArgumentException
     */
    public static void assertStrictlyPositive (int val, String valueName) throws IllegalArgumentException
    {
        assertNotEmpty(valueName, "valueName");

        if (val <= 0) throw new IllegalArgumentException(valueName + " is not strictly positive");
    }

    /**
     <hr>
     <h2>Tests if [val] is > 0</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     <hr>

     @param val The value to test for strict positivity
     */
    public static void assertStrictlyPositive (float val) throws IllegalArgumentException
    {
        if (val <= 0) throw new IllegalArgumentException("Value is not strictly positive");
    }

    /**
     <hr>
     <h2>Tests if [val] is > 0</h2>
     <h3>If it is —> throws IllegalArgumentException.</h3>
     Note 1 : <i>getMessage()</i> of the IAE contains [valueName].<br>
     Usefull to show as feedback for the user.<br>
     <br>
     Note 2 : already asserts [valueName] isn't null or empty.<br>
     <br>
     <hr>

     @param val       The value to test for strict positivity
     @param valueName The name of the value, used in the IllegalArgumentException
     */
    public static void assertStrictlyPositive (float val, String valueName) throws IllegalArgumentException
    {
        assertNotEmpty(valueName, "valueName");

        if (val <= 0) throw new IllegalArgumentException(valueName + " is not strictly positive");
    }
    //endregion
}