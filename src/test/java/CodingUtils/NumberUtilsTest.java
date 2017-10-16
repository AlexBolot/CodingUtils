package CodingUtils;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NumberUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 16/10/17 16:42
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class NumberUtilsTest
{
    private Random random = new Random();
    private String string;

    //region ==================== isInteger (x4) ===================================

    @Test
    public void isInteger_Right ()
    {
        string = String.valueOf(random.nextInt());

        assertTrue(NumberUtils.isInteger(string));
    }

    @Test
    public void isInteger_NotParsable ()
    {
        string = "This can not be parsed into an int";

        assertFalse(NumberUtils.isInteger(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInteger_Null ()
    {
        string = null;

        NumberUtils.isInteger(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInteger_Empty ()
    {
        string = "";

        NumberUtils.isInteger(string);
    }

    //endregion

    //region ==================== tryParseInt (x4) =================================

    @Test
    public void tryParseInt_Right ()
    {
        int value = random.nextInt();
        string = String.valueOf(value);

        assertEquals(value, NumberUtils.tryParseInt(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_NotParsable ()
    {
        string = "This can not be parsed into an int";

        NumberUtils.tryParseInt(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_Null ()
    {
        string = null;

        NumberUtils.tryParseInt(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_Empty ()
    {
        string = "";

        NumberUtils.tryParseInt(string);
    }

    //endregion
}