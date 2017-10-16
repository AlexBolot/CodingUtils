package CodingUtils;

import java.util.Arrays;
import java.util.List;

import static CodingUtils.AssertUtils.assertNotNull;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FormatUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/10/17 16:42
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"unused", "WeakerAccess"})
public class FormatUtils
{

    /**
     <hr>
     <h2>Formats [string] with FirstUpperCase format</h2>
     Note : already asserts [string] isn't null or empty.<br>
     <br>
     <hr>

     @param string String to format
     @return A formatted version of [string]
     @throws IllegalArgumentException If [string] is null or empty
     */
    public static String toFirstUpperCase (String string) throws IllegalArgumentException
    {
        assertNotNull(string);

        if (string.isEmpty()) return string;
        if (string.length() == 1) return string.toUpperCase();

        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    /**
     <hr>
     <h2>Prints all elements of the [objects] list</h2>
     Note : already asserts [objects] isn't null or empty.<br>
     <br>
     <hr>

     @param objects List of Objects to be printed
     @throws IllegalArgumentException If [objects] is null or empty
     */
    public static void printList (List<Object> objects) throws IllegalArgumentException
    {
        assertNotNull(objects);

        StringBuilder str = new StringBuilder();

        for (Object object : objects)
        {
            str.append(object).append("\n");
        }

        if (str.length() > 0) str.deleteCharAt(str.length() - 1);

        System.out.print(str.toString());
    }

    /**
     <hr>
     <h2>Prints all elements of the [objects] array</h2>
     Note 1 : see {@link FormatUtils#printList(List)}.<br>
     <br>
     Note 2 : already asserts [objects] isn't null or empty.<br>
     <br>
     <hr>

     @param objects List of Objects to be printed
     @throws IllegalArgumentException If [objects] is null or empty
     */
    public static void printArray (Object... objects)
    {
        assertNotNull(objects);

        printList(Arrays.asList(objects));
    }
}
