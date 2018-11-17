package CodingUtils;

import org.junit.Test;

import java.util.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AssertUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/11/18 01:08
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings("ConstantConditions")
public class AssertUtilsTest {
    //region --------------- Attributes -------------------------------------
    private Random random = new Random();
    private String string;
    private List<Object> objectList;
    private Map<Object, Object> objectMap;

    //region --------------- assert not null (x2 x5) ------------------------

    //region ---------- using 1 parameter -----------
    @Test
    public void assertNotNull_1Param_Right() {
        Object o = new Object();

        AssertUtils.assertNotNull(o);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotNull_1Param_Null() {
        Object o = null;
        AssertUtils.assertNotNull(o);
    }
    //endregion

    //region ---------- using n parameters ----------
    @Test
    public void assertNotNull_nParam_Right() {
        int maxIndex = new Random().nextInt(200);
        Object[] objects = new Object[maxIndex];

        for (int i = 0; i < maxIndex; i++) {
            objects[i] = new Object();
        }

        AssertUtils.assertNotNull(objects);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotNull_nParam_OneIsNull() {
        int maxIndex = new Random().nextInt(200);
        Object[] objects = new Object[maxIndex];

        for (int i = 0; i < maxIndex; i++) {
            objects[i] = new Object();
        }

        int randIndex = new Random().nextInt(maxIndex);
        objects[randIndex] = null;

        AssertUtils.assertNotNull(objects);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotNull_nParam_ListNull() {
        Object[] objects = null;
        AssertUtils.assertNotNull(objects);
    }
    //endregion

    //endregion

    //region --------------- assert not empty (x3 x9) -----------------------

    //region ---------- String ----------------------
    @Test
    public void assertNotEmpty_String_Right() {
        string = "This String is not empty nor null";
        AssertUtils.assertNotEmpty(string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEmpty_String_Empty() {
        string = "";
        AssertUtils.assertNotEmpty(string);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEmpty_String_Null() {
        string = null;
        AssertUtils.assertNotEmpty(string);
    }
    //endregion

    //region ---------- List ------------------------
    @Test
    public void assertNotEmpty_List_Right() {
        objectList = Arrays.asList(new Object(), new Object(), new Object());

        AssertUtils.assertNotEmpty(objectList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEmpty_List_Empty() {
        objectList = Collections.emptyList();

        AssertUtils.assertNotEmpty(objectList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEmpty_List_Null() {
        objectList = null;

        AssertUtils.assertNotEmpty(objectList);
    }
    //endregion

    //region ---------- Map -------------------------
    @Test
    public void assertNotEmpty_Map_Right() {
        objectMap = new HashMap<>();
        objectMap.put(new Object(), new Object());
        objectMap.put(new Object(), new Object());
        objectMap.put(new Object(), new Object());

        AssertUtils.assertNotEmpty(objectMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEmpty_Map_Empty() {
        objectMap = new HashMap<>();

        AssertUtils.assertNotEmpty(objectMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertNotEmpty_Map_Null() {
        objectMap = null;

        AssertUtils.assertNotEmpty(objectMap);
    }
    //endregion

    //endregion

    //region --------------- assert strictly positive (x1 x3) ---------------

    @Test
    public void assertStrictlyPositive_Right() {
        for (int i = 0; i < 5000; i++) {
            //Making sure we have a positive number
            double value = Math.abs(random.nextDouble() + random.nextInt()) + 1;
            AssertUtils.assertStrictlyPositive(value);
        }

        AssertUtils.assertStrictlyPositive(1);
        AssertUtils.assertStrictlyPositive(Double.MAX_VALUE);
        AssertUtils.assertStrictlyPositive(Integer.MAX_VALUE);
        AssertUtils.assertStrictlyPositive(Float.MAX_VALUE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_Zero() {
        double val = 0;

        AssertUtils.assertStrictlyPositive(val);
    }

    @Test(expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_Negative() {
        for (int i = 0; i < 5000; i++) {
            //Making sure we have a positive number
            double value = Math.abs(random.nextDouble() + random.nextInt()) - 1;
            AssertUtils.assertStrictlyPositive(value);
        }

        AssertUtils.assertStrictlyPositive(-1);
        AssertUtils.assertStrictlyPositive(Double.MIN_VALUE);
        AssertUtils.assertStrictlyPositive(Integer.MIN_VALUE);
        AssertUtils.assertStrictlyPositive(Float.MIN_VALUE);
    }

    //endregion
}