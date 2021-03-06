package CodingUtils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ArrayList8	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 18/10/2019 10:20
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

@SuppressWarnings({"UnusedReturnValue", "ConstantConditions", "unchecked"})
public class ArrayList8<E> extends ArrayList<E> {
    //region --------------- Constructors --------------------
    public ArrayList8() {
        super();
    }

    public ArrayList8(@NotNull Collection<? extends E> c) {
        super(c);
    }

    public ArrayList8(@NotNull E[] array) {
        this(Arrays.asList(array));
    }
    //endregion

    //region --------------- Methods -------------------------
    @NotNull
    public E getRandom() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("List is empty");

        return get(new Random().nextInt(this.size()));
    }

    @NotNull
    public E removeRandom() {
        if (this.isEmpty()) throw new IndexOutOfBoundsException("List is empty");

        return remove(new Random().nextInt(this.size()));
    }

    @NotNull
    public ArrayList8<E> merge(@NotNull Collection<? extends E> collection) {
        this.addAll(collection);
        return this;
    }

    public boolean addIf(E value, @NotNull Predicate<? super E> filter) {
        return value != null && filter.test(value) && add(value);
    }

    public int addAllIf(@NotNull Collection<? extends E> collection, @NotNull Predicate<? super E> filter) {
        ArrayList8<E> paramList = new ArrayList8<>();
        paramList.addAll(collection);

        ArrayList8<E> sublist = paramList.where(filter);

        this.addAll(sublist);

        return sublist.size();
    }

    @Contract(pure = true)
    public boolean contains(@NotNull Predicate<? super E> filter) {
        return this.stream().anyMatch(filter::test);
    }

    @Contract(pure = true)
    public boolean containsAny(@NotNull E... items) {
        return Arrays.stream(items).anyMatch(this::contains);
    }

    public boolean containsAll(@NotNull E... items) {
        return Arrays.stream(items).allMatch(this::contains);
    }

    public int countWhere(@NotNull Predicate<? super E> filter) {
        return (int) this.stream().filter(filter::test).count();
    }

    @NotNull
    public ArrayList8<E> where(@NotNull Predicate<? super E> filter) {
        ArrayList8<E> res = new ArrayList8<>();

        this.forEach(e -> res.addIf(e, filter));

        return res;
    }

    public Optional<E> findAny(@NotNull Predicate<? super E> filter) {
        return this.isEmpty() ? Optional.empty() : where(filter).stream().findAny();
    }

    public Optional<E> findFirst(@NotNull Predicate<? super E> filter) {
        for (E e : this) {
            if (filter.test(e)) return Optional.of(e);
        }

        return Optional.empty();
    }

    public Optional<E> max(@NotNull Comparator<? super E> comparator) {
        if (this.isEmpty()) return Optional.empty();

        E max = this.getRandom();

        for (E e : this) {
            if (comparator.compare(e, max) > 0) max = e;
        }

        return Optional.of(max);
    }

    public Optional<E> min(@NotNull Comparator<? super E> comparator) {
        if (this.isEmpty()) return Optional.empty();

        E min = this.get(0);

        for (E e : this) {
            if (comparator.compare(e, min) < 0) min = e;
        }

        return Optional.of(min);
    }

    public Optional<E> reduce(@NotNull BinaryOperator<E> accumulator) {
        return this.stream().reduce(accumulator);
    }

    public <R> Stream<R> map(@NotNull Function<? super E, ? extends R> mapper) {
        return this.stream().map(mapper);
    }

    public <R> ArrayList8<R> mapAndCollect(@NotNull Function<? super E, ? extends R> mapper) {
        return this.stream().map(mapper).collect(Collectors.toCollection(ArrayList8<R>::new));
    }
    //endregion
}
