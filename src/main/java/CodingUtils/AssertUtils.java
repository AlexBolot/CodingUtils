package CodingUtils;

import java.util.List;
import java.util.Map;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AssertUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/10/17 12:48
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

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
     Note 2 : already asserts [objects] isn't null.<br>
     <br>
     <hr>

     @param objects List of Objects to test for null value
     */
    public static void assertNotNull (Object... objects) throws IllegalArgumentException
    {
        if (objects == null) throw new IllegalArgumentException("Lost of Objects is null");

        for (int i = 0; i < objects.length; i++)
        {
            Object obj = objects[i];
            if (obj == null) throw new IllegalArgumentException(" at index " + i + " is null");
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
        if (objectName == null) throw new IllegalArgumentException("objectName is null");
        if (objectName.isEmpty()) throw new IllegalArgumentException("objectName is empty");

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
        if (string == null) throw new IllegalArgumentException("String is null");
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
        if (stringName == null) throw new IllegalArgumentException("stringName is null");
        if (stringName.isEmpty()) throw new IllegalArgumentException("stringName is empty");

        if (string == null) throw new IllegalArgumentException(stringName + " is null");
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
        if (list == null) throw new IllegalArgumentException("List is null");
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
        if (listName == null) throw new IllegalArgumentException("listName is null");
        if (listName.isEmpty()) throw new IllegalArgumentException("listName is empty");

        if (list == null) throw new IllegalArgumentException(listName + " is null");
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
        if (map == null) throw new IllegalArgumentException("Map is null");
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
        if (mapName == null) throw new IllegalArgumentException("mapName is null");
        if (mapName.isEmpty()) throw new IllegalArgumentException("mapName is empty");

        if (map == null) throw new IllegalArgumentException(mapName + " is null");
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
        if (valueName == null) throw new IllegalArgumentException("valueName is null");
        if (valueName.isEmpty()) throw new IllegalArgumentException("valueName is empty");

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
        if (valueName == null) throw new IllegalArgumentException("valueName is null");
        if (valueName.isEmpty()) throw new IllegalArgumentException("valueName is empty");

        if (val <= 0) throw new IllegalArgumentException(valueName + " is not strictly positive");
    }
    //endregion
}