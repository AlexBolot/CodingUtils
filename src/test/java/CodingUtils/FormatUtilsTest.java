package CodingUtils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FormatUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 13/10/17 16:12
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ("ConstantConditions")
public class FormatUtilsTest
{
    private Random random = new Random();
    private String string;

    @Test
    public void isInteger_Right ()
    {
        string = String.valueOf(random.nextInt());

        assertTrue(FormatUtils.isInteger(string));
    }

    @Test
    public void isInteger_NotParsable ()
    {
        string = "This can not be parsed into an int";

        assertFalse(FormatUtils.isInteger(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInteger_Null ()
    {
        string = null;

        FormatUtils.isInteger(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInteger_Empty ()
    {
        string = "";

        FormatUtils.isInteger(string);
    }

    @Test
    public void tryParseInt_Right ()
    {
        int value = random.nextInt();
        string = String.valueOf(value);

        assertEquals(value, FormatUtils.tryParseInt(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_NotParsable ()
    {
        string = "This can not be parsed into an int";

        FormatUtils.tryParseInt(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_Null ()
    {
        string = null;

        FormatUtils.tryParseInt(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_Empty ()
    {
        string = "";

        FormatUtils.tryParseInt(string);
    }

    @Test
    public void toFirstUpperCase_Right ()
    {
        string = "ALL UPPER CASE";
        assertEquals("All upper case", FormatUtils.toFirstUpperCase(string));

        string = "all lower case";
        assertEquals("All lower case", FormatUtils.toFirstUpperCase(string));

        string = "MiX oF CaSeS";
        assertEquals("Mix of cases", FormatUtils.toFirstUpperCase(string));

        string = "Ab";
        assertEquals("Ab", FormatUtils.toFirstUpperCase(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void toFirstUpperCase_Null ()
    {
        string = null;

        FormatUtils.toFirstUpperCase(string);
    }

    @Test
    public void printList_Right ()
    {
        //TODO : find a better way to test this method...

        //should not trigger any Exception
        List<Object> objects = Arrays.asList(new Object(), new Object(), new Object());
        FormatUtils.printArray(objects);

        //should not trigger any Exception
        objects = Collections.emptyList();
        FormatUtils.printArray(objects);
    }

    @Test (expected = IllegalArgumentException.class)
    public void printList_Null ()
    {
        List<Object> objectList = null;

        FormatUtils.printList(objectList);
    }

    @Test
    public void printArray_Right ()
    {
        //TODO : find a better way to test this method...

        //should not trigger any Exception
        Object[] objects = new Object[]{new Object(), new Object(), new Object()};
        FormatUtils.printArray(objects);


        //should not trigger any Exception
        objects = new Object[]{};
        FormatUtils.printArray(objects);
    }

    @Test (expected = IllegalArgumentException.class)
    public void printArray_Null ()
    {
        FormatUtils.printArray((Object[]) null);
    }
}