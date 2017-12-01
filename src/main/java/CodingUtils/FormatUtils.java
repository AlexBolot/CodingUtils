package CodingUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FormatUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 02/12/17 00:11
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"WeakerAccess", "unused"})
public class FormatUtils
{
    /**
     <hr>
     <h2>Formats [string] with FirstUpperCase format</h2>
     Note : asserts [string] param isn't null.<br>
     <br>
     <hr>

     @param string String to format
     @return A formatted version of [string]
     */
    public static String toFirstUpperCase (String string)
    {
        Objects.requireNonNull(string, "String param is null");

        if (string.isEmpty()) return string;
        if (string.length() == 1) return string.toUpperCase();

        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    /**
     <hr>
     <h2>Prints all elements of the [objects] list</h2>
     Note : asserts [objects] param isn't null.<br>
     <br>
     <hr>

     @param objects List of T objects to be printed
     */
    public static <T> void printListFancy (List<T> objects, String start, String separator, String end)
    {
        Objects.requireNonNull(objects, "List param is null");

        if (objects.isEmpty())
        {
            System.out.print(start + end);
            return;
        }

        StringBuilder str = new StringBuilder();

        str.append(start == null ? "" : start);

        objects.forEach(o -> str.append(o).append(separator == null ? "" : separator));

        if (separator != null) str.deleteCharAt(str.length() - separator.length());

        str.append(end == null ? "" : end);

        System.out.print(str.toString());
    }

    /**
     <hr>
     <h2>Prints all elements of the [objects] array</h2>
     Note : asserts [objects] param isn't null.<br>
     <br>
     <hr>

     @param objects Array of T objects to be printed
     */
    public static <T> void printArrayFancy (T[] objects, String start, String separator, String end)
    {
        Objects.requireNonNull(objects, "Array param is null");

        if (objects.length == 0)
        {
            System.out.print(start + end);
            return;
        }

        StringBuilder str = new StringBuilder();

        str.append(start == null ? "" : start);

        Arrays.asList(objects).forEach(o -> str.append(o).append(separator == null ? "" : separator));

        if (separator != null) str.deleteCharAt(str.length() - separator.length());

        str.append(end == null ? "" : end);

        System.out.print(str.toString());
    }
}
