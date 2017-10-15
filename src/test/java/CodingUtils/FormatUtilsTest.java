package CodingUtils;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FormatUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 15/10/17 23:06
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ("ConstantConditions")
public class FormatUtilsTest
{
    private Random random = new Random();
    private String string;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private void setUp_OutputStream ()
    {
        System.setOut(new PrintStream(outputStream));
    }

    private void clear_OutputStream ()
    {
        System.setOut(null);
    }

    //region ==================== isInteger (x4) ===================================

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

    //endregion

    //region ==================== tryParseInt (x4) =================================

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

    //endregion

    //region ==================== toFirstUpperCase (x2) ============================

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

        string = "A";
        assertEquals("A", FormatUtils.toFirstUpperCase(string));

        string = "a";
        assertEquals("A", FormatUtils.toFirstUpperCase(string));

        string = "";
        assertEquals("", FormatUtils.toFirstUpperCase(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void toFirstUpperCase_Null ()
    {
        string = null;

        FormatUtils.toFirstUpperCase(string);
    }

    //endregion

    //region ==================== printList (x2) ===================================

    @Test
    public void printList_Right ()
    {
        setUp_OutputStream();

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        List<Object> objects = Arrays.asList(o1, o2, o3);
        FormatUtils.printList(objects);

        assertEquals(o1.toString() + "\n" + o2.toString() + "\n" + o3.toString(), outputStream.toString());

        clear_OutputStream();
    }

    @Test
    public void printList_Empty ()
    {
        setUp_OutputStream();

        ArrayList<Object> objects = new ArrayList<>();
        FormatUtils.printList(objects);

        assertEquals("", outputStream.toString());

        clear_OutputStream();
    }

    @Test (expected = IllegalArgumentException.class)
    public void printList_Null ()
    {
        List<Object> objectList = null;

        FormatUtils.printList(objectList);
    }

    //endregion

    //region ==================== printArray (x2) ==================================

    @Test
    public void printArray_Right ()
    {
        setUp_OutputStream();

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        Object[] objects = {o1, o2, o3};
        FormatUtils.printArray(objects);

        assertEquals(o1.toString() + "\n" + o2.toString() + "\n" + o3.toString(), outputStream.toString());

        clear_OutputStream();
    }

    @Test
    public void printArray_Empty ()
    {
        setUp_OutputStream();

        Object[] objects = new Object[]{};
        FormatUtils.printArray(objects);

        assertEquals("", outputStream.toString());

        clear_OutputStream();
    }

    @Test (expected = IllegalArgumentException.class)
    public void printArray_Null ()
    {
        FormatUtils.printArray((Object[]) null);
    }

    //endregion
}