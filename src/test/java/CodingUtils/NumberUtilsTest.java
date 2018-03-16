package CodingUtils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static CodingUtils.NumberUtils.*;
import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NumberUtilsTest	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 20/02/18 23:11
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"ConstantConditions", "ResultOfMethodCallIgnored"})
public class NumberUtilsTest
{
    //region --------------- Attributes -------------------------
    private Random random = new Random();
    private String string;
    private double delta = 0.001;

    private Comparator<NotComparable> comparator = (nc1, nc2) -> {
        if (nc1.val3 > nc2.val3) return 1;
        if (nc1.val3 < nc2.val3) return -1;

        if (nc1.val2 > nc2.val2) return 1;
        if (nc1.val2 < nc2.val2) return -1;

        return Integer.compare(nc1.val1, nc2.val1);
    };

    private Comparable MIN_COMPARABLE = new Comparable(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    private Comparable MAX_COMPARABLE = new Comparable(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    private NotComparable MIN_NOT_COMPARABLE = new NotComparable(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    private NotComparable MAX_NOT_COMPARABLE = new NotComparable(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    //endregion

    //region --------------- Private Methods --------------------
    @NotNull
    private Comparable randComparable ()
    {
        int valDay = ThreadLocalRandom.current().nextInt();
        int valMonth = ThreadLocalRandom.current().nextInt();
        int valYear = ThreadLocalRandom.current().nextInt();

        return new Comparable(valDay, valMonth, valYear);
    }

    @NotNull
    private NotComparable randNotComparable ()
    {
        int valDay = ThreadLocalRandom.current().nextInt();
        int valMonth = ThreadLocalRandom.current().nextInt();
        int valYear = ThreadLocalRandom.current().nextInt();

        return new NotComparable(valDay, valMonth, valYear);
    }

    @Contract (pure = true)
    private int negativeOf (int val) { return (val >= 0) ? -val : val; }
    //endregion

    //region --------------- isParseable (x3 x12) ---------------

    //region ---------- isInteger ---------------------------
    @Test
    public void isInteger_Right ()
    {
        int maxIndex = ThreadLocalRandom.current().nextInt(2000);

        for (int i = 0; i < maxIndex; i++)
        {
            string = String.valueOf(ThreadLocalRandom.current().nextInt());
            assertTrue(isInteger(string));
        }
    }

    @Test
    public void isInteger_NotParsable ()
    {
        string = "This can not be parsed into an int";

        assertFalse(isInteger(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInteger_Null ()
    {
        string = null;

        isInteger(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInteger_Empty ()
    {
        string = "";

        isInteger(string);
    }
    //endregion

    //region ---------- isFloat -----------------------------
    @Test
    public void isFloat_Right ()
    {
        int maxIndex = ThreadLocalRandom.current().nextInt(2000);

        for (int i = 0; i < maxIndex; i++)
        {
            string = String.valueOf(ThreadLocalRandom.current().nextFloat() + ThreadLocalRandom.current().nextInt());
            assertTrue(isFloat(string));
        }
    }

    @Test
    public void isFloat_NotParsable ()
    {
        string = "This can not be parsed into a float";

        assertFalse(isFloat(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isFloat_Null ()
    {
        string = null;

        isFloat(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isFloat_Empty ()
    {
        string = "";

        isFloat(string);
    }
    //endregion

    //region ---------- isDouble ----------------------------
    @Test
    public void isDouble_Right ()
    {
        int maxIndex = ThreadLocalRandom.current().nextInt(2000);

        for (int i = 0; i < maxIndex; i++)
        {
            string = String.valueOf(ThreadLocalRandom.current().nextDouble() + ThreadLocalRandom.current().nextInt());
            assertTrue(isDouble(string));
        }
    }

    @Test
    public void isDouble_NotParsable ()
    {
        string = "This can not be parsed into a double";

        assertFalse(isDouble(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isDouble_Null ()
    {
        string = null;

        isDouble(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void isDouble_Empty ()
    {
        string = "";

        isDouble(string);
    }
    //endregion

    //endregion

    //region --------------- tryParse (x3 x12) ------------------

    //region ---------- tryParseInt -------------------------
    @Test
    public void tryParseInt_Right ()
    {
        int value = ThreadLocalRandom.current().nextInt();
        string = String.valueOf(value);

        assertEquals(value, tryParseInt(string));
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_NotParsable ()
    {
        string = "This can not be parsed into an int";

        tryParseInt(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_Null ()
    {
        string = null;
        tryParseInt(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseInt_Empty ()
    {
        string = "";

        tryParseInt(string);
    }
    //endregion

    //region ---------- tryParseFloat -----------------------
    @Test
    public void tryParseFloat_Right ()
    {
        float value = ThreadLocalRandom.current().nextFloat();
        string = String.valueOf(value);

        assertEquals(value, tryParseFloat(string), delta);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseFloat_NotParsable ()
    {
        string = "This can not be parsed into a float";

        tryParseFloat(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseFloat_Null ()
    {
        string = null;
        tryParseFloat(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseFloat_Empty ()
    {
        string = "";

        tryParseFloat(string);
    }
    //endregion

    //region ---------- tryParseDouble ----------------------
    @Test
    public void tryParseDouble_Right ()
    {
        double value = ThreadLocalRandom.current().nextDouble();
        string = String.valueOf(value);

        assertEquals(value, tryParseDouble(string), delta);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseDouble_NotParsable ()
    {
        string = "This can not be parsed into a double";

        tryParseDouble(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseDouble_Null ()
    {
        string = null;
        tryParseDouble(string);
    }

    @Test (expected = IllegalArgumentException.class)
    public void tryParseDouble_Empty ()
    {
        string = "";

        tryParseDouble(string);
    }
    //endregion

    //endregion

    //region --------------- isInBounds (x3 x12) ----------------

    //region ---------- isInBoundsDouble --------------------
    @Test
    public void isInBound_Double_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int value = ThreadLocalRandom.current().nextInt();
            int min = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, value);
            int max = ThreadLocalRandom.current().nextInt(value, Integer.MAX_VALUE);

            assertTrue(isInBounds(min, value, max));
            assertFalse(isInBounds(value, min, max));
            assertFalse(isInBounds(min, max, value));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInBound_Double_BadBounds ()
    {
        int value = ThreadLocalRandom.current().nextInt();
        int min = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, value);
        int max = ThreadLocalRandom.current().nextInt(value, Integer.MAX_VALUE);

        isInBounds(max, value, min);
    }
    //endregion

    //region ---------- isInBoundsNotComparable -------------
    @Test
    public void isInBound_NotComparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int maxVal = Integer.MAX_VALUE;
            int minVal = Integer.MIN_VALUE;

            int valDay = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valMonth = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valYear = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            NotComparable val = new NotComparable(valDay, valMonth, valYear);

            int minDay = ThreadLocalRandom.current().nextInt(minVal, valDay);
            int minYear = ThreadLocalRandom.current().nextInt(minVal, valYear);
            int minMonth = ThreadLocalRandom.current().nextInt(minVal, valMonth);
            NotComparable min = new NotComparable(minDay, minMonth, minYear);

            int maxDay = ThreadLocalRandom.current().nextInt(valDay + 1, maxVal);
            int maxMonth = ThreadLocalRandom.current().nextInt(valMonth + 1, maxVal);
            int maxYear = ThreadLocalRandom.current().nextInt(valYear + 1, maxVal);
            NotComparable max = new NotComparable(maxDay, maxMonth, maxYear);

            assertTrue(isInBounds(min, val, max, comparator));
            assertFalse(isInBounds(val, min, max, comparator));
            assertFalse(isInBounds(min, max, val, comparator));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInBound_NotComparable_Null ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int count = 0;

            int maxVal = Integer.MAX_VALUE;
            int minVal = Integer.MIN_VALUE;

            int valDay = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valMonth = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valYear = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            NotComparable val = new NotComparable(valDay, valMonth, valYear);

            int minDay = ThreadLocalRandom.current().nextInt(minVal, valDay);
            int minYear = ThreadLocalRandom.current().nextInt(minVal, valYear);
            int minMonth = ThreadLocalRandom.current().nextInt(minVal, valMonth);
            NotComparable min = new NotComparable(minDay, minMonth, minYear);

            int maxDay = ThreadLocalRandom.current().nextInt(valDay + 1, maxVal);
            int maxMonth = ThreadLocalRandom.current().nextInt(valMonth + 1, maxVal);
            int maxYear = ThreadLocalRandom.current().nextInt(valYear + 1, maxVal);
            NotComparable max = new NotComparable(maxDay, maxMonth, maxYear);

            //region min null
            try
            {
                isInBounds(null, val, max, comparator);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion
            //region val null
            try
            {
                isInBounds(min, null, max, comparator);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion
            //region max null
            try
            {
                isInBounds(min, val, null, comparator);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion
            //region cmp null
            try
            {
                isInBounds(min, val, max, null);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion

            assertEquals(4, count);
        }
    }
    //endregion

    //region ---------- isInBoundsComparable ----------------
    @Test
    public void isInBound_Comparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int maxVal = Integer.MAX_VALUE;
            int minVal = Integer.MIN_VALUE;

            int valDay = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valMonth = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valYear = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            Comparable val = new Comparable(valDay, valMonth, valYear);

            int minDay = ThreadLocalRandom.current().nextInt(minVal, valDay);
            int minYear = ThreadLocalRandom.current().nextInt(minVal, valYear);
            int minMonth = ThreadLocalRandom.current().nextInt(minVal, valMonth);
            Comparable min = new Comparable(minDay, minMonth, minYear);

            int maxDay = ThreadLocalRandom.current().nextInt(valDay + 1, maxVal);
            int maxMonth = ThreadLocalRandom.current().nextInt(valMonth + 1, maxVal);
            int maxYear = ThreadLocalRandom.current().nextInt(valYear + 1, maxVal);
            Comparable max = new Comparable(maxDay, maxMonth, maxYear);

            assertTrue(isInBounds(min, val, max));
            assertFalse(isInBounds(val, min, max));
            assertFalse(isInBounds(min, max, val));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void isInBound_Comparable_Null ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int count = 0;

            int maxVal = Integer.MAX_VALUE;
            int minVal = Integer.MIN_VALUE;

            int valDay = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valMonth = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            int valYear = ThreadLocalRandom.current().nextInt(minVal + 1, maxVal - 1);
            Comparable val = new Comparable(valDay, valMonth, valYear);

            int minDay = ThreadLocalRandom.current().nextInt(minVal, valDay);
            int minYear = ThreadLocalRandom.current().nextInt(minVal, valYear);
            int minMonth = ThreadLocalRandom.current().nextInt(minVal, valMonth);
            Comparable min = new Comparable(minDay, minMonth, minYear);

            int maxDay = ThreadLocalRandom.current().nextInt(valDay + 1, maxVal);
            int maxMonth = ThreadLocalRandom.current().nextInt(valMonth + 1, maxVal);
            int maxYear = ThreadLocalRandom.current().nextInt(valYear + 1, maxVal);
            Comparable max = new Comparable(maxDay, maxMonth, maxYear);

            //region min null
            try
            {
                isInBounds(null, val, max);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion
            //region val null
            try
            {
                isInBounds(min, null, max);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion
            //region max null
            try
            {
                isInBounds(min, val, null);
            }
            catch (NullPointerException ignored)
            {
                count++;
            }
            //endregion

            assertEquals(3, count);
        }
    }
    //endregion

    //endregion

    //region --------------- min (x5 x15) -----------------------

    //region ---------- minArrayDouble ----------------------
    @Test
    public void min_Array_Double_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            int min = Integer.MAX_VALUE;
            double[] array = new double[size];

            for (int j = 0; j < size; j++)
            {
                int val = ThreadLocalRandom.current().nextInt();
                array[j] = val;

                if (val < min) min = val;
            }

            assertEquals(min, min(array), 0.001);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Array_Double_Null ()
    {
        double[] array = null;
        min(array);
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Array_Double_Empty ()
    {
        double[] array = new double[]{};
        min(array);
    }
    //endregion

    //region ---------- minArrayNotComparable ---------------
    @Test
    public void min_Array_NotComparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            NotComparable min = MIN_NOT_COMPARABLE;
            NotComparable[] array = new NotComparable[size];

            for (int j = 0; j < size; j++)
            {
                NotComparable val = randNotComparable();

                array[j] = val;

                if (comparator.compare(min, val) > 0) min = val;
            }

            assertEquals(min, min(array, comparator));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Array_NotComparable_Null ()
    {
        NotComparable[] array = null;
        min(array, comparator);
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Array_NotComparable_Empty ()
    {
        NotComparable[] array = new NotComparable[]{};
        min(array, comparator);
    }
    //endregion

    //region ---------- minArrayComparable ------------------
    @Test
    public void min_Array_Comparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            Comparable min = MIN_COMPARABLE;
            Comparable[] array = new Comparable[size];

            for (int j = 0; j < size; j++)
            {
                Comparable val = randComparable();

                array[j] = val;

                if (min.compareTo(val) > 0) min = val;
            }

            assertEquals(min, min(array));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Array_Comparable_Null ()
    {
        Comparable[] array = null;
        min(array);
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Array_Comparable_Empty ()
    {
        Comparable[] array = new Comparable[]{};
        min(array);
    }
    //endregion

    //region ---------- minCollectionNotComparable ----------
    @Test
    public void min_Collection_NotComparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            NotComparable min = MIN_NOT_COMPARABLE;
            ArrayList<NotComparable> arrayList = new ArrayList<>();

            for (int j = 0; j < size; j++)
            {
                NotComparable val = randNotComparable();

                arrayList.add(val);

                if (comparator.compare(min, val) > 0) min = val;
            }

            assertEquals(min, min(arrayList, comparator));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Collection_NotComparable_Null ()
    {
        ArrayList<NotComparable> arrayList = null;
        min(arrayList, comparator);
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Collection_NotComparable_Empty ()
    {
        ArrayList<NotComparable> arrayList = new ArrayList<>();
        min(arrayList, comparator);
    }
    //endregion

    //region ---------- minCollectionComparable -------------
    @Test
    public void min_Collection_Comparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            Comparable min = MIN_COMPARABLE;
            ArrayList<Comparable> arrayList = new ArrayList<>();

            for (int j = 0; j < size; j++)
            {
                Comparable val = randComparable();

                arrayList.add(val);

                if (min.compareTo(val) > 0) min = val;
            }

            assertEquals(min, min(arrayList));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Collection_Comparable_Null ()
    {
        ArrayList<Comparable> arrayList = null;
        min(arrayList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void min_Collection_Comparable_Empty ()
    {
        ArrayList<Comparable> arrayList = new ArrayList<>();
        min(arrayList);
    }
    //endregion

    //endregion

    //region --------------- max (x5 x15) -----------------------

    //region ---------- maxArrayDouble ----------------------
    @Test
    public void max_Array_Double_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            int max = Integer.MIN_VALUE;
            double[] array = new double[size];

            for (int j = 0; j < size; j++)
            {
                int val = ThreadLocalRandom.current().nextInt();
                array[j] = val;

                if (val > max) max = val;
            }

            assertEquals(max, max(array), delta);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Array_Double_Null ()
    {
        double[] array = null;
        max(array);
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Array_Double_Empty ()
    {
        double[] array = new double[]{};
        max(array);
    }
    //endregion

    //region ---------- maxArrayNotComparable ---------------
    @Test
    public void max_Array_NotComparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            NotComparable max = MAX_NOT_COMPARABLE;
            NotComparable[] array = new NotComparable[size];

            for (int j = 0; j < size; j++)
            {
                NotComparable val = randNotComparable();

                array[j] = val;

                if (comparator.compare(val, max) > 0) max = val;
            }

            assertEquals(max, max(array, comparator));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Array_NotComparable_Null ()
    {
        NotComparable[] array = null;
        max(array, comparator);
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Array_NotComparable_Empty ()
    {
        NotComparable[] array = new NotComparable[]{};
        max(array, comparator);
    }
    //endregion

    //region ---------- maxArrayComparable ------------------
    @Test
    public void max_Array_Comparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            Comparable max = MAX_COMPARABLE;
            Comparable[] array = new Comparable[size];

            for (int j = 0; j < size; j++)
            {
                Comparable val = randComparable();

                array[j] = val;

                if (val.compareTo(max) > 0) max = val;
            }

            assertEquals(max, max(array));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Array_Comparable_Null ()
    {
        Comparable[] array = null;
        max(array);
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Array_Comparable_Empty ()
    {
        Comparable[] array = new Comparable[]{};
        max(array);
    }
    //endregion

    //region ---------- maxCollectionNotComparable ----------
    @Test
    public void max_Collection_NotComparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            NotComparable max = MAX_NOT_COMPARABLE;
            ArrayList<NotComparable> arrayList = new ArrayList<>();

            for (int j = 0; j < size; j++)
            {
                NotComparable val = randNotComparable();

                arrayList.add(val);

                if (comparator.compare(val, max) > 0) max = val;
            }

            assertEquals(max, max(arrayList, comparator));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Collection_NotComparable_Null ()
    {
        ArrayList<NotComparable> arrayList = null;
        max(arrayList, comparator);
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Collection_NotComparable_Empty ()
    {
        ArrayList<NotComparable> arrayList = new ArrayList<>();
        max(arrayList, comparator);
    }
    //endregion

    //region ---------- maxCollectionComparable -------------
    @Test
    public void max_Collection_Comparable_Right ()
    {
        for (int i = 0; i < 2000; i++)
        {
            int size = ThreadLocalRandom.current().nextInt(500) + 1;
            Comparable max = MAX_COMPARABLE;
            ArrayList<Comparable> arrayList = new ArrayList<>();

            for (int j = 0; j < size; j++)
            {
                Comparable val = randComparable();

                arrayList.add(val);

                if (val.compareTo(max) > 0) max = val;
            }

            assertEquals(max, max(arrayList));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Collection_Comparable_Null ()
    {
        ArrayList<Comparable> arrayList = null;
        max(arrayList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void max_Collection_Comparable_Empty ()
    {
        ArrayList<Comparable> arrayList = new ArrayList<>();
        max(arrayList);
    }
    //endregion

    //endregion

    //region --------------- randBetween (x3) -------------------
    @Test
    public void randBetween_Right ()
    {
        for (int i = 0; i < 1000; i++)
        {
            int minBound = random.nextInt() / 3;
            int maxBound = random.nextInt() / 3;

            while (maxBound <= minBound) maxBound = random.nextInt() / 3;

            int randVal = randBetween(minBound, maxBound);

            assertTrue(minBound <= randVal);
            assertTrue(randVal < maxBound);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void randBetween_InvertedBounds ()
    {
        for (int i = 0; i < 1000; i++)
        {
            int minBound = random.nextInt() / 3;
            int maxBound = random.nextInt() / 3;

            while (maxBound >= minBound) maxBound = random.nextInt() / 3;

            randBetween(minBound, maxBound);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void randBetween_EqualsBounds ()
    {
        for (int i = 0; i < 1000; i++)
        {
            int minBound = random.nextInt() / 3;
            randBetween(minBound, minBound);
        }
    }
    //endregion

    //region --------------- randDelta (x3) ---------------------
    @Test
    public void randDelta_Right ()
    {
        for (int i = 0; i < 1000; i++)
        {
            int center = random.nextInt() / 3;
            int delta = Math.abs(random.nextInt() / 3);

            int randVal = randDelta(center, delta);

            assertTrue(center - delta <= randVal);
            assertTrue(randVal < center + delta);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void randDelta_NegativeDelta ()
    {
        for (int i = 0; i < 1000; i++)
        {
            int center = random.nextInt() / 3;
            int delta = negativeOf(random.nextInt() / 3);

            randDelta(center, delta);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void randDelta_ZeroCenterAndDelta ()
    {
        int center = 0;
        int delta = 0;

        randDelta(center, delta);
    }
    //endregion

    //region --------------- Private classes --------------------
    private class NotComparable
    {
        int val1;
        int val2;
        int val3;

        NotComparable (int val1, int val2, int val3)
        {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
        }
    }

    private class Comparable implements java.lang.Comparable<Comparable>
    {
        int val1;
        int val2;
        int val3;

        Comparable (int val1, int val2, int val3)
        {
            this.val1 = val1;
            this.val2 = val2;
            this.val3 = val3;
        }

        @Override
        public int compareTo (@NotNull NumberUtilsTest.Comparable comparable)
        {
            if (val3 > comparable.val3) return 1;
            if (val3 < comparable.val3) return -1;

            if (val2 > comparable.val2) return 1;
            if (val2 < comparable.val2) return -1;

            return Integer.compare(val1, comparable.val1);
        }
    }
    //endregion
}