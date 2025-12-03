package exercises;

import edu.touro.mcon264.apps.collections.CollectionInterface;

/**
 * Advance Set Interface
 * @param <T>
 */
public interface AdvanceSetInterface <T> extends CollectionInterface<T> {
/*
 Starter code the exercise 6
 Desig signatures for the following methods:
    union()
    intersection()
    difference()
 */

    /**
     * Returns a new set representing the union of this set and the other set.
     */
    AdvanceSetInterface<T> union(AdvanceSetInterface<T> other);

    /**
     * Returns a new set containing only elements found in both sets.
     */
    AdvanceSetInterface<T> intersection(AdvanceSetInterface<T> other);

    /**
     * Returns a new set containing elements in this set but not in the other.
     */
    AdvanceSetInterface<T> difference(AdvanceSetInterface<T> other);

}
