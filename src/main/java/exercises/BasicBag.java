package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;
import java.util.Random;

public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {
    private final Random rand = new Random();
    @Override
    public T grab() {
        if (numElements == 0) {
            return null;
        }

        int index = rand.nextInt(numElements);
        T result = elements[index];

        elements[index] = elements[numElements-1];
        elements[numElements-1] = null;
        numElements--;

        return result;
    }

    @Override
    public int count(T target) {
        int count = 0;
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int removeAll(T target) {
        int removed = 0;
        int i = 0;

        while (i < numElements) {
            if (elements[i].equals(target)) {
                // overwrite with last element
                elements[i] = elements[numElements - 1];
                elements[numElements - 1] = null;
                numElements--;
                removed++;
                // do not advance i – we need to re-check the new element at i
            } else {
                i++;
            }
        }

        return removed;
    }

    @Override
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            elements[i] = null;
        }
        numElements = 0;
    }

    }

    // TODO: implement the methods in the BagInterface using an array as the underlying data structure
    // consider extending ArrayCollection<T>
    // put in the JavaDoc comments as specified in the BagInterface.
    // Which SOLID principles is being applied here?
