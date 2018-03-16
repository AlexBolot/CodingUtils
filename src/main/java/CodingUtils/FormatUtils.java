package CodingUtils;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FormatUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 20/02/18 23:18
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"WeakerAccess", "unused", "ConstantConditions"})
public class FormatUtils
{
    //region --------------- toFirstUpperCase (x1) ---------------

    /**
     <hr>
     <h2>Formats [string] with FirstUpperCase format</h2>
     <hr>

     @param string String to format
     @return A formatted version of [string]
     */
    public static String toFirstUpperCase (@NotNull String string)
    {
        if (string.isEmpty()) return string;
        if (string.length() == 1) return string.toUpperCase();

        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }
    //endregion

    //region --------------- print fancy (x2) --------------------

    /**
     <hr>
     <h2>Prints all elements of the [objects] list</h2>
     <hr>

     @param objects List of T objects to be printed
     */
    public static <T> void printListFancy (@NotNull List<T> objects, @NotNull String start, @NotNull String separator, @NotNull String end)
    {
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
     <hr>

     @param objects Array of T objects to be printed
     */
    public static <T> void printArrayFancy (@NotNull T[] objects, @NotNull String start, @NotNull String separator, @NotNull String end)
    {
        printListFancy(Arrays.asList(objects), start, separator, end);
    }
    //endregion
}
