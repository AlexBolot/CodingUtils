package CodingUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;

/*................................................................................................................................
 . Copyright (c)
 .
 . The HashMap8	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 17/11/2018 21:49
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

public class HashMap8<A, B> extends HashMap<A, B> {

    public HashMap8() {
        super();
    }

    public HashMap8(Map<? extends A, ? extends B> map) {
        super(map);
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    public void putOrReplace(A key, B value) {
        if (this.containsKey(key))
            this.replace(key, value);
        else
            this.put(key, value);
    }

    public boolean notContainsKey(A key) {
        return !this.containsKey(key);
    }

    public boolean notContainsValue(B value) {
        return !this.containsValue(value);
    }

    public void update(A key, Function<B, B> modifier) {

        if (this.notContainsKey(key))
            throw new IllegalArgumentException("Key " + key + " does not exist in this Map");

        B oldValue = this.get(key);

        this.replace(key, modifier.apply(oldValue));
    }

    public B getRandom() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("Map is empty");

        int item = new Random().nextInt(this.size()); // In real life, the Random object should be rather more shared than this

        int i = 0;
        for (B value : values()) {
            if (i == item)
                return value;
            i++;
        }

        return null;
    }

    public HashMap8<A, B> whereKey(Predicate<A> filter) {
        HashMap8<A, B> res = new HashMap8<>();

        this.forEach((key, value) -> {
            if (filter.test(key)) res.put(key, value);
        });

        return res;
    }

    public HashMap8<A, B> whereValue(Predicate<B> filter) {
        HashMap8<A, B> res = new HashMap8<>();

        this.forEach((key, value) -> {
            if (filter.test(value)) res.put(key, value);
        });

        return res;
    }

    public HashMap8<A, B> whereEntry(Predicate<A> keyFilter, Predicate<B> valueFilter) {
        HashMap8<A, B> res = new HashMap8<>();

        this.forEach((key, value) -> {
            if (keyFilter.test(key) && valueFilter.test(value)) res.put(key, value);
        });

        return res;
    }
}