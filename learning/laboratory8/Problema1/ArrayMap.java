import java.util.*;

public class ArrayMap<K, V> extends AbstractMap<K, V> {

    private static class ArrayMapEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        ArrayMapEntry(K key, V value) {
            this.value = value;
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V old = value;
            this.value = value;
            return old;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;

            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue());
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

    private final List<ArrayMapEntry<K, V>> entries = new ArrayList<>();

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new AbstractSet<Map.Entry<K, V>>() {
            public Iterator<Map.Entry<K, V>> iterator() {
                return new ArrayList<Map.Entry<K, V>>(entries).iterator(); // sau un iterator propriu
            }

            public int size() {
                return entries.size();
            }
        };
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public V put(K key, V value) {
        for (ArrayMapEntry<K, V> e : entries)
            if (Objects.equals(e.getKey(), key))
                return e.setValue(value);
        entries.add(new ArrayMapEntry<>(key, value));
        return null;
    }
}
