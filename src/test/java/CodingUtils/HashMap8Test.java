package CodingUtils;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The HashMap8Test	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/11/2018 21:26
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings({"Duplicates", "MismatchedQueryAndUpdateOfCollection", "ResultOfMethodCallIgnored", "ConstantConditions"})
public class HashMap8Test {

    //region --------------- Attributes ----------------------
    private Predicate<TestObject> positive = testObject -> testObject.val1 > 0 && testObject.val2 > 0 && testObject.val3 > 0;

    private Comparator<TestObject> comparator = (testObject1, testObject2) -> {
        if (testObject1.val1 > testObject2.val1) return 1;
        if (testObject1.val1 < testObject2.val1) return -1;

        if (testObject1.val2 > testObject2.val2) return 1;
        if (testObject1.val2 < testObject2.val2) return -1;

        return Integer.compare(testObject1.val3, testObject2.val3);
    };
    //endregion

    //region --------------- constructors (x3) ---------------
    @Test
    public void constructor_empty() {
        HashMap8<TestObject, TestObject> map8 = new HashMap8<>();
        assertTrue(map8.isEmpty());
    }

    @Test
    public void constructor_map() {
        TestObject objKey1;
        TestObject objVal1;
        TestObject objKey2;
        TestObject objVal2;

        HashMap8<TestObject, TestObject> origin = new HashMap8<>();

        for (int i = 0; i < 2000; i++) {

            origin.clear();

            objKey1 = randTestObject();
            objVal1 = randTestObject();
            objKey2 = randTestObject();
            objVal2 = randTestObject();

            origin.put(objKey1, objVal1);
            origin.put(objKey2, objVal2);

            HashMap8<TestObject, TestObject> destination = new HashMap8<>(origin);

            assertEquals(origin.size(), destination.size());

            destination.forEach((key, value) -> {
                assertTrue(origin.containsKey(key));
                assertTrue(origin.containsValue(value));
            });
        }
    }
    //endregion

    @Test
    public void isNotEmpty() {
    }

    @Test
    public void putOrReplace() {
    }

    @Test
    public void notContainsKey() {
    }

    @Test
    public void notContainsValue() {
    }

    @Test
    public void update() {
    }

    @Test
    public void whereKey() {
    }

    @Test
    public void whereValue() {
    }

    @Test
    public void whereEntry() {
    }

    //region --------------- OtherMethods --------------------
    @NotNull
    private TestObject randTestObject() {
        int val1 = ThreadLocalRandom.current().nextInt();
        int val2 = ThreadLocalRandom.current().nextInt();
        int val3 = ThreadLocalRandom.current().nextInt();

        return new TestObject(val1, val2, val3);
    }
    //endregion

    //region --------------- Private classes -----------------
    private class TestObject {
        int val1;
        int val2;
        int val3;

        TestObject(int val1, int val2, int val3) {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
        }
    }
    //endregion
}