package crystal.client.utils.collections;

import java.util.*;

public class DistinctArrayList<E> implements Iterable<E> {

    private List<E> list;

    public DistinctArrayList() {
        list = new ArrayList<>();
    }

    public boolean add(E element) {
        if (!list.contains(element)) {
            return list.add(element);
        }
        return false;
    }

    public boolean remove(E element) {
        return list.remove(element);
    }

    public int size() {
        return list.size();
    }

    public boolean contains(E element) {
        return list.contains(element);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}

