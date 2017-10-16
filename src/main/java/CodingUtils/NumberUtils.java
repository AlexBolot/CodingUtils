package CodingUtils;

import static CodingUtils.AssertUtils.assertNotEmpty;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NumberUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/10/17 16:42
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class NumberUtils
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
     @return The Integer value of [string] if parsable.<br>(if not, IAE has already been thrown)
     @throws IllegalArgumentException If [string] is null or empty
     */
    public static int tryParseInt (String string) throws IllegalArgumentException
    {
        if (!isInteger(string)) throw new IllegalArgumentException(string + " can't be parsed into an int");

        return Integer.parseInt(string);
    }

}
