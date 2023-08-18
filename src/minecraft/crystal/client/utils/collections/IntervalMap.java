package crystal.client.utils.collections;

import java.util.*;

public class IntervalMap<K extends Comparable<K>, V> {

    private TreeMap<K, V> intervalMap;

    public IntervalMap() {
        intervalMap = new TreeMap<>();
    }

    public void put(K start, K end, V value) {
        intervalMap.put(start, value);
        intervalMap.put(end, value);
    }

    public V get(K key) {
        Map.Entry<K, V> entry = intervalMap.floorEntry(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public void remove(K key) {
        intervalMap.remove(key);
    }

    public boolean containsKey(K key) {
        return intervalMap.containsKey(key);
    }

    public void clear() {
        intervalMap.clear();
    }

    public List<V> values() {
        return new ArrayList<>(intervalMap.values());
    }
}
