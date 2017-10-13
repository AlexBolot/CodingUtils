package CodingUtils;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The AssertUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 13/10/17 14:51
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ("ConstantConditions")
public class AssertUtilsTest
{
    //region ==================== assert not null (2 -> 5) ==============================

    //region ========== using 1 parameter ============
    @Test
    public void assertNotNull_1Param_Right ()
    {
        Object o = new Object();

        AssertUtils.assertNotNull(o);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotNull_1Param_Null ()
    {
        Object o = null;
        AssertUtils.assertNotNull(o);
    }
    //endregion

    //region ========== using n parameters ===========
    @Test
    public void assertNotNull_2Param_Right ()
    {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        AssertUtils.assertNotNull(o1, o2, o3);
    }

    @Test
    public void assertNotNull_2Param_OneIsNull ()
    {
        try
        {
            AssertUtils.assertNotNull(new Object(), null, new Object());
            Assert.fail("IllegalArgumentException wasn't thrown...");
        }
        catch (IllegalArgumentException iae)
        {
            Assert.assertEquals("Object at index 1 is null", iae.getMessage());
        }
    }

    @Test
    public void assertNotNull_2Param_ListNull ()
    {
        try
        {
            AssertUtils.assertNotNull((Object[]) null);
            Assert.fail("IllegalArgumentException wasn't thrown...");
        }
        catch (IllegalArgumentException iae)
        {
            Assert.assertEquals("List of Objects is null", iae.getMessage());
        }
    }
    //endregion

    //endregion

    //region ==================== assert not empty (6 -> 18) ============================

    //region ========== String -> 1 param ============
    @Test
    public void assertNotEmpty_AnonymousString_Right ()
    {
        String string = "This String is not empty nor null";
        AssertUtils.assertNotEmpty(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_AnonymousString_Empty ()
    {
        String string = "";
        AssertUtils.assertNotEmpty(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_AnonymousString_Null ()
    {
        String string = null;
        AssertUtils.assertNotEmpty(string);
    }
    //endregion

    //region ========== String -> 2 params ===========
    @Test
    public void assertNotEmpty_NamedString_Right ()
    {
        String string = "This String is not empty nor null";
        AssertUtils.assertNotEmpty(string, "TestString");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_NamedString_Empty ()
    {
        String string = "";
        AssertUtils.assertNotEmpty(string, "TestString");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_NamedString_Null ()
    {
        String string = null;
        AssertUtils.assertNotEmpty(string, "TestString");
    }
    //endregion

    //region ========== List -> 1 param ==============
    @Test
    public void assertNotEmpty_AnonymousList_Right ()
    {
        List<Object> objectList = Arrays.asList(new Object(), new Object(), new Object());

        AssertUtils.assertNotEmpty(objectList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_AnonymousList_Empty ()
    {
        List<Object> objectList = Collections.emptyList();

        AssertUtils.assertNotEmpty(objectList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_AnonymousList_Null ()
    {
        List<Object> objectList = null;

        AssertUtils.assertNotEmpty(objectList);
    }
    //endregion

    //region ========== List -> 2 params =============
    @Test
    public void assertNotEmpty_NamedList_Right ()
    {
        List<Object> objectList = Arrays.asList(new Object(), new Object(), new Object());

        AssertUtils.assertNotEmpty(objectList, "TestingList");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_NamedList_Empty ()
    {
        List<Object> objectList = Collections.emptyList();

        AssertUtils.assertNotEmpty(objectList, "TestingList");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_NamedList_Null ()
    {
        List<Object> objectList = null;

        AssertUtils.assertNotEmpty(objectList, "TestingList");
    }
    //endregion

    //region ========== Map -> 1 param ===============
    @Test
    public void assertNotEmpty_AnonymousMap_Right ()
    {
        Map<Object, Object> objectMap = new HashMap<>();
        objectMap.put(new Object(), new Object());
        objectMap.put(new Object(), new Object());
        objectMap.put(new Object(), new Object());

        AssertUtils.assertNotEmpty(objectMap);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_AnonymousMap_Empty ()
    {
        Map<Object, Object> objectMap = new HashMap<>();

        AssertUtils.assertNotEmpty(objectMap);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_AnonymousMap_Null ()
    {
        Map<Object, Object> objectMap = null;

        AssertUtils.assertNotEmpty(objectMap);
    }
    //endregion

    //region ========== Map -> 2 params ==============
    @Test
    public void assertNotEmpty_NamedMap_Right ()
    {
        Map<Object, Object> objectMap = new HashMap<>();
        objectMap.put(new Object(), new Object());
        objectMap.put(new Object(), new Object());
        objectMap.put(new Object(), new Object());

        AssertUtils.assertNotEmpty(objectMap, "TestingList");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_NamedMap_Empty ()
    {
        Map<Object, Object> objectMap = new HashMap<>();

        AssertUtils.assertNotEmpty(objectMap, "TestingList");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertNotEmpty_NamedMap_Null ()
    {
        Map<Object, Object> objectMap = null;

        AssertUtils.assertNotEmpty(objectMap, "TestingList");
    }
    //endregion

    //endregion

    //region ==================== assert strictly positive (4 -> 12) ====================

    //region ========== int -> 1 param ===============
    @Test
    public void assertStrictlyPositive_AnonymInt_Right ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a positive number
            int value = Math.abs(random.nextInt()) + 1;
            AssertUtils.assertStrictlyPositive(value);
        }

        AssertUtils.assertStrictlyPositive(1);
        AssertUtils.assertStrictlyPositive(Integer.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_AnonymInt_Zero ()
    {
        int val = 0;

        AssertUtils.assertStrictlyPositive(val);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_AnonymInt_Negative ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a negative number
            int value = -Math.abs(random.nextInt()) - 1;
            AssertUtils.assertStrictlyPositive(value);
        }

        AssertUtils.assertStrictlyPositive(-1);
        AssertUtils.assertStrictlyPositive(Integer.MIN_VALUE);
    }
    //endregion

    //region ========== int -> 2 params ==============
    @Test
    public void assertStrictlyPositive_NamesInt_Right ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a positive number
            int value = Math.abs(random.nextInt()) + 1;
            AssertUtils.assertStrictlyPositive(value, "TestValue");
        }

        AssertUtils.assertStrictlyPositive(1, "TestValue");
        AssertUtils.assertStrictlyPositive(Integer.MAX_VALUE, "TestValue");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_NamedInt_Zero ()
    {
        int val = 0;

        AssertUtils.assertStrictlyPositive(val, "TestValue");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_NamedInt_Negative ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a negative number
            int value = -Math.abs(random.nextInt()) - 1;
            AssertUtils.assertStrictlyPositive(value, "TestValue");
        }

        AssertUtils.assertStrictlyPositive(-1, "TestValue");
        AssertUtils.assertStrictlyPositive(Integer.MIN_VALUE, "TestValue");
    }
    //endregion

    //region ========== float -> 1 param =============
    @Test
    public void assertStrictlyPositive_AnonymFloat_Right ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a positive number
            float value = Math.abs(random.nextFloat()) + 1;
            AssertUtils.assertStrictlyPositive(value);
        }

        AssertUtils.assertStrictlyPositive(1f);
        AssertUtils.assertStrictlyPositive(Float.MAX_VALUE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_AnonymFloat_Zero ()
    {
        float val = 0;

        AssertUtils.assertStrictlyPositive(val);
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_AnonymFloat_Negative ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a negative number
            float value = -Math.abs(random.nextFloat()) - 1;
            AssertUtils.assertStrictlyPositive(value);
        }

        AssertUtils.assertStrictlyPositive(-1f);
        AssertUtils.assertStrictlyPositive(Float.MIN_VALUE);
    }
    //endregion

    //region ========== float -> 2 params ============
    @Test
    public void assertStrictlyPositive_NamedFloat_Right ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a positive number
            float value = Math.abs(random.nextFloat()) + 1;
            AssertUtils.assertStrictlyPositive(value, "TestValue");
        }

        AssertUtils.assertStrictlyPositive(1f, "TestValue");
        AssertUtils.assertStrictlyPositive(Float.MAX_VALUE, "TestValue");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_NamedFloat_Zero ()
    {
        float val = 0;

        AssertUtils.assertStrictlyPositive(val, "TestValue");
    }

    @Test (expected = IllegalArgumentException.class)
    public void assertStrictlyPositive_NamedFloat_Negative ()
    {
        Random random = new Random();

        for (int i = 0; i < 50000; i++)
        {
            //Making sure we have a negative number
            float value = -Math.abs(random.nextFloat()) - 1;
            AssertUtils.assertStrictlyPositive(value, "TestValue");
        }

        AssertUtils.assertStrictlyPositive(-1f, "TestValue");
        AssertUtils.assertStrictlyPositive(Float.MIN_VALUE, "TestValue");
    }
    //endregion

    //endregion
}