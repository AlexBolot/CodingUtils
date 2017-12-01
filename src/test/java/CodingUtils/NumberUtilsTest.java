package CodingUtils;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NumberUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 02/12/17 00:31
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ("ConstantConditions")
public class NumberUtilsTest
{
    private Random random = new Random();
    private String string;
    private double delta = 0.001;

    //region ==================== isParseable (3 -> 12) ====================

    //region ========== isInteger ==========
    @Test
    public void isInteger_Right ()
    {
        int maxIndex = random.nextInt(5000);

        for (int i = 0; i < maxIndex; i++)
        {
            string = String.valueOf(random.nextInt());
            assertTrue(NumberUtils.isInteger(string));
        }
    }

    @Test
    public void isInteger_NotParsable ()
    {
        string = "This can not be parsed into an int";

        assertFalse(NumberUtils.isInteger(string));
    }

    @Test (expected = NullPointerException.class)
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

    //region ========== isFloat ============
    @Test
    public void isFloat_Right ()
    {
        int maxIndex = random.nextInt(5000);

        for (int i = 0; i < maxIndex; i++)
        {
            string = String.valueOf(random.nextFloat() + random.nextInt());
            assertTrue(NumberUtils.isFloat(string));
        }
    }

    @Test
    public void isFloat_NotParsable ()
    {
        string = "This can not be parsed into a float";

        assertFalse(NumberUtils.isFloat(string));
    }

    @Test (expected = NullPointerException.class)
    public void isFloat_Null ()
    {
        string = null;

        NumberUtils.isFloat(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isFloat_Empty ()
    {
        string = "";

        NumberUtils.isFloat(string);
    }
    //endregion

    //region ========== isDouble ===========
    @Test
    public void isDouble_Right ()
    {
        int maxIndex = random.nextInt(5000);

        for (int i = 0; i < maxIndex; i++)
        {
            string = String.valueOf(random.nextDouble() + random.nextInt());
            assertTrue(NumberUtils.isDouble(string));
        }
    }

    @Test
    public void isDouble_NotParsable ()
    {
        string = "This can not be parsed into a double";

        assertFalse(NumberUtils.isDouble(string));
    }

    @Test (expected = NullPointerException.class)
    public void isDouble_Null ()
    {
        string = null;

        NumberUtils.isDouble(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isDouble_Empty ()
    {
        string = "";

        NumberUtils.isDouble(string);
    }
    //endregion

    //endregion

    //region ==================== tryParse (3 -> 12) =======================

    //region ========== tryParseInt =============
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

    @Test (expected = NullPointerException.class)
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

    //region ========== tryParseFloat ===========
    @Test
    public void tryParseFloat_Right ()
    {
        float value = random.nextFloat();
        string = String.valueOf(value);

        assertEquals(value, NumberUtils.tryParseFloat(string), delta);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseFloat_NotParsable ()
    {
        string = "This can not be parsed into a float";

        NumberUtils.tryParseFloat(string);
    }

    @Test (expected = NullPointerException.class)
    public void tryParseFloat_Null ()
    {
        string = null;
        NumberUtils.tryParseFloat(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseFloat_Empty ()
    {
        string = "";

        NumberUtils.tryParseFloat(string);
    }
    //endregion

    //region ========== tryParseDouble ==========
    @Test
    public void tryParseDouble_Right ()
    {
        double value = random.nextDouble();
        string = String.valueOf(value);

        assertEquals(value, NumberUtils.tryParseDouble(string), delta);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseDouble_NotParsable ()
    {
        string = "This can not be parsed into a double";

        NumberUtils.tryParseDouble(string);
    }

    @Test (expected = NullPointerException.class)
    public void tryParseDouble_Null ()
    {
        string = null;
        NumberUtils.tryParseDouble(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseDouble_Empty ()
    {
        string = "";

        NumberUtils.tryParseDouble(string);
    }
    //endregion

    //endregion

    //region ==================== tryParse (3 -> 12) =======================

    //endregion
}