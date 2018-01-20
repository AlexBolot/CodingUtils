package CodingUtils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/*................................................................................................................................
 . Copyright (c)
 .
 . The NumberUtils	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 20/01/18 00:53
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings ({"ResultOfMethodCallIgnored", "unchecked", "ConstantConditions"})
public class NumberUtils
{
    //region --------------- is parsable (x3) ----------------

    /**
     <hr>
     <h2>Tests if [string] can be parsed into an Integer</h2>
     <hr>

     @param string String to test
     @return True if [string] can be parsed into an Integer
     */
    public static boolean isInteger (@NotNull String string)
    {
        //region --> Check params
        if (string == null) throw new IllegalArgumentException("String param is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");
        //endregion

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
    public static boolean isFloat (@NotNull String string)
    {
        //region --> Check params
        if (string == null) throw new IllegalArgumentException("String param is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");
        //endregion

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
    public static boolean isDouble (@NotNull String string)
    {
        //region --> Check params
        if (string == null) throw new IllegalArgumentException("String param is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");
        //endregion

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

    //region --------------- try parse (x3) ------------------

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
    public static int tryParseInt (@NotNull String string)
    {
        //region --> Check params
        if (string == null) throw new IllegalArgumentException("String param is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");
        //endregion

        try
        {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException(string + " can't be parsed into an int");
        }
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
    public static float tryParseFloat (@NotNull String string)
    {
        //region --> Check params
        if (string == null) throw new IllegalArgumentException("String param is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");
        //endregion

        try
        {
            return Float.parseFloat(string);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException(string + " can't be parsed into a float");
        }
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
    public static double tryParseDouble (@NotNull String string)
    {
        //region --> Check params
        if (string == null) throw new IllegalArgumentException("String param is null");
        if (string.isEmpty()) throw new IllegalArgumentException("String param is empty");
        //endregion

        try
        {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException e)
        {
            throw new IllegalArgumentException(string + " can't be parsed into a double");
        }
    }
    //endregion

    //region --------------- is in bounds (x3) ---------------

    /**
     <hr>
     <h2>Checks if [value] is between [minBound] and [maxBound]</h2>
     <h3><i>How it checks : </i><pre>[minBound] < [value] < [maxBound]</pre></h3>
     <hr>

     @param minBound the excluded lower bound
     @param value    the value to be tested
     @param maxBound the excluded upper bound
     */
    @Contract (pure = true)
    public static boolean isInBounds (double minBound, double value, double maxBound)
    {
        //region --> Check params
        if (maxBound < minBound) throw new IllegalArgumentException("maxBound < minBound");
        //endregion

        return minBound < value && value < maxBound;
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
    public static <T> boolean isInBounds (@NotNull T minBound, @NotNull T value, @NotNull T maxBound, @NotNull Comparator<T> comparator)
    {
        //region --> Check params
        if (value == null) throw new IllegalArgumentException("Value param is null");
        if (minBound == null) throw new IllegalArgumentException("MinBound param is null");
        if (maxBound == null) throw new IllegalArgumentException("MaxBound param is null");
        if (comparator == null) throw new IllegalArgumentException("Comparator param is null");
        if (comparator.compare(maxBound, minBound) < 0) throw new IllegalArgumentException("maxBound < minBound");
        //endregion

        return comparator.compare(minBound, value) < 0 && comparator.compare(value, maxBound) < 0;
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
    public static <T extends Comparable<T>> boolean isInBounds (@NotNull T minBound, @NotNull T value, @NotNull T maxBound)
    {
        //region --> Check params
        if (value == null) throw new IllegalArgumentException("Value param is null");
        if (minBound == null) throw new IllegalArgumentException("MinBound param is null");
        if (maxBound == null) throw new IllegalArgumentException("MaxBound param is null");
        if (maxBound.compareTo(minBound) < 0) throw new IllegalArgumentException("maxBound < minBound");
        //endregion

        return minBound.compareTo(value) < 0 && value.compareTo(maxBound) < 0;
    }
    //endregion

    //region --------------- min (x5) ------------------------
    public static double min (@NotNull double[] array)
    {
        //region --> Check params
        if (array == null) throw new IllegalArgumentException("Array param is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        //endregion

        if (array.length == 1) return array[0];

        return Arrays.stream(array).min().orElse(Double.MAX_VALUE);
    }

    public static <T> T min (@NotNull T[] array, @NotNull Comparator<T> comparator)
    {
        //region --> Check params
        if (array == null) throw new IllegalArgumentException("Array param is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        //endregion

        if (array.length == 1) return array[0];

        T min = array[0];

        for (T t : array)
        {
            if (comparator.compare(t, min) < 0) min = t;
        }

        return min;
    }

    public static <T> T min (@NotNull Collection<T> collection, @NotNull Comparator<T> comparator)
    {
        //region --> Check params
        if (collection == null) throw new IllegalArgumentException("Collection param is null");
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        //endregion

        if (collection.size() == 1) return (T) collection.toArray()[0];

        T min = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (comparator.compare(t, min) < 0) min = t;
        }

        return min;
    }

    public static <T extends Comparable<T>> T min (@NotNull T[] array)
    {
        //region --> Check params
        if (array == null) throw new IllegalArgumentException("Array param is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        //endregion

        if (array.length == 1) return array[0];

        T min = array[0];

        for (T t : array)
        {
            if (t.compareTo(min) < 0) min = t;
        }

        return min;
    }

    public static <T extends Comparable<T>> T min (@NotNull Collection<T> collection)
    {
        //region --> Check params
        if (collection == null) throw new IllegalArgumentException("Collection param is null");
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        //endregion

        if (collection.size() == 1) return (T) collection.toArray()[0];

        T min = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (t.compareTo(min) < 0) min = t;
        }

        return min;
    }
    //endregion

    //region --------------- max (x5) ------------------------
    @Contract (pure = true)
    public static double max (@NotNull double[] array)
    {
        //region --> Check params
        if (array == null) throw new IllegalArgumentException("Array param is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        //endregion

        if (array.length == 1) return array[0];

        return Arrays.stream(array).max().orElse(Integer.MIN_VALUE);
    }

    public static <T> T max (@NotNull T[] array, @NotNull Comparator<T> comparator)
    {
        //region --> Check params
        if (array == null) throw new IllegalArgumentException("Array param is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        //endregion

        if (array.length == 1) return array[0];

        T max = array[0];

        for (T t : array)
        {
            if (comparator.compare(t, max) > 0) max = t;
        }

        return max;
    }

    public static <T> T max (@NotNull Collection<T> collection, @NotNull Comparator<T> comparator)
    {
        //region --> Check params
        if (collection == null) throw new IllegalArgumentException("Collection param is null");
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        //endregion

        if (collection.size() == 1) return (T) collection.toArray()[0];

        T max = (T) collection.toArray()[0];

        for (T t : collection)
        {
            if (comparator.compare(t, max) > 0) max = t;
        }

        return max;
    }

    public static <T extends Comparable<T>> T max (@NotNull T[] array)
    {
        //region --> Check params
        if (array == null) throw new IllegalArgumentException("Array param is null");
        if (array.length == 0) throw new IllegalArgumentException("Array is empty");
        //endregion

        if (array.length == 1) return array[0];

        T max = array[0];

        for (T t : array)
        {
            if (t.compareTo(max) > 0) max = t;
        }

        return max;
    }

    public static <T extends Comparable<T>> T max (@NotNull Collection<T> collection)
    {
        //region --> Check params
        if (collection == null) throw new IllegalArgumentException("Collection param is null");
        if (collection.size() == 0) throw new IllegalArgumentException("Collection is empty");
        //endregion

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
