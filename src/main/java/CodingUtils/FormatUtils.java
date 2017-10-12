package CodingUtils;

import java.util.Arrays;
import java.util.List;

import static CodingUtils.AssertUtils.assertNotEmpty;

@SuppressWarnings ({"unused", "WeakerAccess"})
public class FormatUtils
{
    /**
     <hr>
     <h2>Tests if [string] can be parsed into an Integer</h2>
     Note : already asserts [string] isn't null or empty.<br>
     <br>
     <hr>

     @param string String to test
     @return True if [string] can be parsed into an Integer
     @throws IllegalArgumentException If [string] is null or empty
     */
    public static boolean isInteger (String string) throws IllegalArgumentException
    {
        assertNotEmpty(string);

        try
        {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     <hr>
     <h2>Tries to parse [string] into an Integer</h2>
     <h3>If not possible —> throws IllegalArgumentException</h3>
     Note 1 : see {@link FormatUtils#isInteger(String)}.<br>
     <br>
     Note 2 : already asserts [string] isn't null or empty.<br>
     <br>
     <hr>

     @param string String to parse
     @return The Integer value of [string] if parsable, otherwise Integer.MIN_VALUE
     @throws IllegalArgumentException If [string] is null or empty
     */
    public static int tryParseInt (String string) throws IllegalArgumentException
    {
        return isInteger(string) ? Integer.parseInt(string) : Integer.MIN_VALUE;
    }

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
        assertNotEmpty(string);

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
        assertNotEmpty(objects);

        for (Object object : objects)
        {
            System.out.println(object);
        }
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
        printList(Arrays.asList(objects));
    }
}
