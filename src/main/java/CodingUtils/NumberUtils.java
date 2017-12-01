package CodingUtils;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NumberUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 02/12/17 00:31
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"ResultOfMethodCallIgnored", "unchecked"})
public class NumberUtils
{
    //region ============ is parsable (x3) ===========

    /**
     <hr>
     <h2>Tests if [string] can be parsed into an Integer</h2>
     <hr>

     @param string String to test
     @return True if [string] can be parsed into an Integer
     */
    public static boolean isInteger (String string)
    {
        Objects.requireNonNull(string, "String param is null");

        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");

        try
        {
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
     <h2>Tests if [string] can be parsed into a Float</h2>
     <hr>

     @param string String to test
     @return True if [string] can be parsed into a Float
     */
    public static boolean isFloat (String string)
    {
        Objects.requireNonNull(string, "String param is null");

        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");

        try
        {
            Float.parseFloat(string);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     <hr>
     <h2>Tests if [string] can be parsed into a Double</h2>
     <hr>

     @param string String to test
     @return True if [string] can be parsed into a Double
     */
    public static boolean isDouble (String string)
    {
        Objects.requireNonNull(string, "String param is null");

        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");

        try
        {
            Double.parseDouble(string);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    //endregion

    //region ============ try parse (x3) =============

    /**
     <hr>
     <h2>Tries to parse [string] into an Integer</h2>
     <h3>If not possible —>  IllegalArgumentException. <br>
     Note : see {@link NumberUtils#isInteger(String)}.</h3>
     <br>
     <hr>

     @param string String to parse
     @return The Integer value of [string] if parsable.<br>(if not, IAE has already been thrown)
     */
    public static int tryParseInt (String string)
    {
        if (!isInteger(string)) throw new IllegalArgumentException(string + " can't be parsed into an int");

        return Integer.parseInt(string);
    }

    /**
     <hr>
     <h2>Tries to parse [string] into a Float</h2>
     <h3>If not possible —>  IllegalArgumentException</h3>
     Note 1 : see {@link NumberUtils#isFloat(String)}.<br>
     <br>
     Note 2 : asserts [string] isn't null.<br>
     <br>
     <hr>

     @param string String to parse
     @return The Float value of [string] if parsable.<br>(if not, IAE has already been thrown)
     */
    public static float tryParseFloat (String string)
    {
        if (!isFloat(string)) throw new IllegalArgumentException(string + " can't be parsed into a float");

        return Float.parseFloat(string);
    }

    /**
     <hr>
     <h2>Tries to parse [string] into a Double</h2>
     <h3>If not possible —>  IllegalArgumentException</h3>
     Note 1 : see {@link NumberUtils#isDouble(String)}.<br>
     <br>
     Note 2 : asserts [string] isn't null.<br>
     <br>
     <hr>

     @param string String to parse
     @return The Double value of [string] if parsable.<br>(if not, IAE has already been thrown)
     */
    public static double tryParseDouble (String string)
    {
        if (!isDouble(string)) throw new IllegalArgumentException(string + " can't be parsed into a double");

        return Double.parseDouble(string);
    }
    //endregion

    //region ============ is in bounds (x3) ==========

    /**
     <hr>
     <h2>Checks if [value] is between [minBound] and [maxBound]</h2>
     <h3><i>How it checks : </i><pre>[minBound] < [value] < [maxBound]</pre></h3>
     <hr>

     @param minBound the excluded lower bound
     @param value    the value to be tested
     @param maxBound the excluded upper bound
     */
    public static boolean isInBounds (double minBound, double value, double maxBound)
    {
        if (maxBound < minBound) throw new IllegalArgumentException("maxBound < minBound");

        return minBound < value && value > maxBound;
    }

    /**
     <hr>
     <h2>Checks if [value] is between [minBound] and [maxBound]</h2>
     <h3><i>How it checks : </i><pre>[minBound] < [value] < [maxBound] using [comparator]</pre></h3>
     <hr>

     @param minBound the excluded lower bound
     @param value    the value to be tested
     @param maxBound the excluded upper bound
     */
    public static <T> boolean isInBounds (T minBound, T value, T maxBound, Comparator<T> comparator)
    {
        Objects.requireNonNull(value, "value is null");
        Objects.requireNonNull(minBound, "minBound is null");
        Objects.requireNonNull(maxBound, "maxBound is null");

        if (comparator.compare(maxBound, minBound) < 0) throw new IllegalArgumentException("maxBound < minBound");

        return comparator.compare(value, minBound) > 0 && comparator.compare(value, maxBound) < 0;
    }

    /**
     <hr>
     <h2>Checks if [value] is between [minBound] and [maxBound]</h2>
     <h3><i>How it checks : </i><pre>[minBound] < [value] < [maxBound]</pre></h3>
     <hr>

     @param minBound the excluded lower bound
     @param value    the value to be tested
     @param maxBound the excluded upper bound
     */
    public static <T extends Comparable<T>> boolean isInBounds (T minBound, T value, T maxBound)
    {
        Objects.requireNonNull(value, "value is null");
        Objects.requireNonNull(minBound, "minBound is null");
        Objects.requireNonNull(maxBound, "maxBound is null");

        if (maxBound.compareTo(minBound) < 0) throw new IllegalArgumentException("maxBound < minBound");

        return value.compareTo(minBound) > 0 && value.compareTo(maxBound) < 0;
    }
    //endregion

    //region ============ min (x7) ===================
    public static int min (int[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        int min = Integer.MAX_VALUE;

        for (int i : tab)
        {
            if (i < min) min = i;
        }

        return min;
    }

    public static float min (float[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        float min = Float.MAX_VALUE;

        for (Float i : tab)
        {
            if (i < min) min = i;
        }

        return min;
    }

    public static double min (double[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        double min = Double.MAX_VALUE;

        for (double i : tab)
        {
            if (i < min) min = i;
        }

        return min;
    }

    public static <T> T min (T[] tab, Comparator<T> comparator)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        T min = tab[0];

        for (T t : tab)
        {
            if (comparator.compare(t, min) < 0) min = t;
        }

        return min;
    }

    public static <T> T min (Collection<T> collection, Comparator<T> comparator)
    {
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        if (collection.size() == 1) return (T) collection.toArray()[0];

        T min = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (comparator.compare(t, min) < 0) min = t;
        }

        return min;
    }

    public static <T extends Comparable<T>> T min (T[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        T min = tab[0];

        for (T t : tab)
        {
            if (t.compareTo(min) < 0) min = t;
        }

        return min;
    }

    public static <T extends Comparable<T>> T min (Collection<T> collection)
    {
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        if (collection.size() == 1) return (T) collection.toArray()[0];

        T min = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (t.compareTo(min) < 0) min = t;
        }

        return min;
    }
    //endregion

    //region ============ max (x7) ===================
    public static int max (int[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");

        int max = Integer.MIN_VALUE;

        for (int i : tab)
        {
            if (i > max) max = i;
        }

        return max;
    }

    public static float max (float[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");

        float max = Integer.MIN_VALUE;

        for (float i : tab)
        {
            if (i > max) max = i;
        }

        return max;
    }

    public static double max (double[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");

        double max = Integer.MIN_VALUE;

        for (double i : tab)
        {
            if (i > max) max = i;
        }

        return max;
    }

    public static <T> T max (T[] tab, Comparator<T> comparator)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        T max = tab[0];

        for (T t : tab)
        {
            if (comparator.compare(t, max) > 0) max = t;
        }

        return max;
    }

    public static <T> T max (Collection<T> collection, Comparator<T> comparator)
    {
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        if (collection.size() == 1) return (T) collection.toArray()[0];

        T max = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (comparator.compare(t, max) > 0) max = t;
        }

        return max;
    }

    public static <T extends Comparable<T>> T max (T[] tab)
    {
        if (tab.length == 0) throw new IllegalArgumentException("Array is empty");
        if (tab.length == 1) return tab[0];

        T max = tab[0];

        for (T t : tab)
        {
            if (t.compareTo(max) > 0) max = t;
        }

        return max;
    }

    public static <T extends Comparable<T>> T max (Collection<T> collection)
    {
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        if (collection.size() == 1) return (T) collection.toArray()[0];

        T max = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (t.compareTo(max) > 0) max = t;
        }

        return max;
    }
    //endregion
}
