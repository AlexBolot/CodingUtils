package CodingUtils;

import java.util.*;
import java.util.function.Predicate;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ArrayList8	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 01/12/17 17:04
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class ArrayList8<E> extends ArrayList<E>
{
    private Random random = new Random();

    public E getRandom ()
    {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("List is empty");

        return get(random.nextInt(this.size()));
    }

    public E removeRandom ()
    {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("List is empty");

        return remove(random.nextInt(this.size()));
    }

    public boolean addIf (E value, Predicate<? super E> filter)
    {
        return filter.test(value) && add(value);
    }

    public boolean addAllIf (Collection<? extends E> c, Predicate<? super E> filter)
    {
        for (E e : c)
        {
            if (!addIf(e, filter)) return false;
        }

        return true;
    }

    public int countIf (Predicate<? super E> filter)
    {
        int count = 0;

        for (E e : this)
        {
            if (filter.test(e)) count++;
        }

        return count;
    }

    public ArrayList8<E> subList (Predicate<? super E> filter)
    {
        if (this.isEmpty()) return this;

        ArrayList8<E> newList = new ArrayList8<>();

        newList.addAllIf(this, filter);

        return newList;
    }

    public Optional<E> findAny (Predicate<? super E> filter)
    {
        return this.isEmpty() ? Optional.empty() : subList(filter).stream().findAny();
    }

    public Optional<E> findFirst (Predicate<? super E> filter)
    {
        for (E e : this)
        {
            if (filter.test(e)) return Optional.of(e);
        }

        return Optional.empty();
    }

    public Optional<E> max (Comparator<? super E> comparator)
    {
        if (this.isEmpty()) return Optional.empty();

        E max = this.getRandom();

        for (E e : this)
        {
            if (comparator.compare(max, e) > 0) max = e;
        }

        return Optional.of(max);
    }

    public Optional<E> min (Comparator<? super E> comparator)
    {
        if (this.isEmpty()) return Optional.empty();

        E min = this.get(0);

        for (E e : this)
        {
            if (comparator.compare(min, e) < 0) min = e;
        }

        return Optional.of(min);
    }
}
