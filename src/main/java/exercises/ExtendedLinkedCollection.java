package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {
    @Override
    public String toString() {
      //ТОDO: implement this method. Use StringBuider. Create Javadoc.

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        LLNode<T> current = head;
        boolean first = true;

        while (current != null) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(current.getInfo());
            first = false;
            current = current.getLink();
        }

        sb.append("]");
        return sb.toString();
    }


    public int count(T target) {
      //ТОDO: implement this method. Count the number of times target appears in the collection. Create Javadoc.

        int count = 0;
        LLNode<T> current = head;
        while (current != null) {
            if (current.getInfo().equals(target)) {
                count++;
            }
            current = current.getLink();
        }
        return count;
    }

    public void removeAll(T target) {
      //ТОDO: implement this method. Remove all occurrences of target from the collection and return the number of elements removed. Create Javadoc.

        while (head != null && head.getInfo().equals(target)) {
            head = head.getLink();
            numElements--;
        }

        // now head is either null or not equal to target
        LLNode<T> previous = head;
        LLNode<T> current = (head == null) ? null : head.getLink();

        while (current != null) {
            if (current.getInfo().equals(target)) {
                // bypass current
                previous.setLink(current.getLink());
                numElements--;
                current = previous.getLink();
            } else {
                previous = current;
                current = current.getLink();
            }
        }
    }
}
