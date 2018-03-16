package CodingUtils;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FormatUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 20/02/18 23:11
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ("ConstantConditions")
public class FormatUtilsTest
{
    //region --------------- Attributes --------------------------
    private String string;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    //endregion

    //region --------------- SetUp - TearDown --------------------
    private void setUp_OutputStream ()
    {
        System.setOut(new PrintStream(outputStream));
    }

    private void clear_OutputStream ()
    {
        System.setOut(null);
    }
    //endregion

    //region --------------- toFirstUpperCase (x2) ---------------

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

    //region --------------- printList (x4) ----------------------

    @Test
    public void printList_Right ()
    {
        setUp_OutputStream();

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        List<Object> objects = Arrays.asList(o1, o2, o3);

        String start = "{";
        String separator = ",";
        String end = "}";

        FormatUtils.printListFancy(objects, start, separator, end);

        assertEquals(start + o1.toString() + separator + o2.toString() + separator + o3.toString() + end, outputStream.toString());

        clear_OutputStream();
    }

    @Test
    public void printList_Empty ()
    {
        setUp_OutputStream();

        ArrayList<Object> objects = new ArrayList<>();

        String start = "{";
        String separator = ",";
        String end = "}";

        FormatUtils.printListFancy(objects, start, separator, end);

        assertEquals(start + end, outputStream.toString());

        clear_OutputStream();
    }

    @Test (expected = IllegalArgumentException.class)
    public void printList_Null ()
    {
        List<Object> objects = null;

        String start = "{";
        String separator = ",";
        String end = "}";

        FormatUtils.printListFancy(objects, start, separator, end);
    }

    @Test (expected = IllegalArgumentException.class)
    public void printList_NullParams ()
    {
        setUp_OutputStream();

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        List<Object> objects = Arrays.asList(o1, o2, o3);

        String start = null;
        String separator = null;
        String end = null;

        FormatUtils.printListFancy(objects, start, separator, end);

        assertEquals(o1.toString() + o2.toString() + o3.toString(), outputStream.toString());

        clear_OutputStream();
    }

    //endregion

    //region --------------- printArray (x4) ---------------------

    @Test
    public void printArray_Right ()
    {
        setUp_OutputStream();

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        Object[] objects = {o1, o2, o3};

        String start = "{";
        String separator = ",";
        String end = "}";

        FormatUtils.printArrayFancy(objects, start, separator, end);

        assertEquals(start + o1.toString() + separator + o2.toString() + separator + o3.toString() + end, outputStream.toString());

        clear_OutputStream();
    }

    @Test
    public void printArray_Empty ()
    {
        setUp_OutputStream();

        Object[] objects = new Object[]{};

        String start = "{";
        String separator = ",";
        String end = "}";

        FormatUtils.printArrayFancy(objects, start, separator, end);

        assertEquals(start + end, outputStream.toString());

        clear_OutputStream();
    }

    @Test (expected = IllegalArgumentException.class)
    public void printArray_Null ()
    {
        Object[] objects = null;

        String start = "{";
        String separator = ",";
        String end = "}";

        FormatUtils.printArrayFancy(objects, start, separator, end);
    }


    @Test (expected = IllegalArgumentException.class)
    public void printArray_NullParams ()
    {
        setUp_OutputStream();

        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        Object[] objects = {o1, o2, o3};

        String start = null;
        String separator = null;
        String end = null;

        FormatUtils.printArrayFancy(objects, start, separator, end);

        assertEquals(o1.toString() + o2.toString() + o3.toString(), outputStream.toString());

        clear_OutputStream();
    }

    //endregion
}