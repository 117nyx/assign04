package assign09;

import java.util.ArrayList;
import java.util.List;

public class HashTable implements Map{
    ArrayList<MapEntry> backingArr = new ArrayList();
    /**
     * Removes all mappings from this map.
     * <p>
     * O(table length) for quadratic probing or separate chaining
     */
    @Override
    public void clear() {
        backingArr.clear();
    }

    /**
     * Determines whether this map contains the specified key.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @return true if this map contains the key, false otherwise
     */
    @Override
    public boolean containsKey(Object key) {
        for (MapEntry m: backingArr) {
            if(m.getKey().equals(key))
                return true;
        }
        return false;
    }

    /**
     * Determines whether this map contains the specified value.
     * <p>
     * O(table length) for quadratic probing
     * O(table length + N) for separate chaining
     *
     * @param value
     * @return true if this map contains one or more keys to the specified value,
     * false otherwise
     */
    @Override
    public boolean containsValue(Object value) {
        for (MapEntry m: backingArr) {
            if(m.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a List view of the mappings contained in this map, where the ordering of
     * mapping in the list is insignificant.
     * <p>
     * O(table length) for quadratic probing
     * O(table length + N) for separate chaining
     *
     * @return a List object containing all mapping (i.e., entries) in this map
     */
    @Override
    public List<MapEntry> entries() {
        return this.backingArr;
    }

    /**
     * Gets the value to which the specified key is mapped.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @return the value to which the specified key is mapped, or null if this map
     * contains no mapping for the key
     */
    @Override
    public Object get(Object key) {
        return
    }

    /**
     * Determines whether this map contains any mappings.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @return true if this map contains no mappings, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * (I.e., if the key already exists in this map, resets the value;
     * otherwise adds the specified key-value pair.)
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @param value
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @param key
     * @return the previous value associated with key, or null if there was no
     * mapping for key
     */
    @Override
    public Object remove(Object key) {
        return null;
    }

    /**
     * Determines the number of mappings in this map.
     * <p>
     * O(1) for quadratic probing or separate chaining
     *
     * @return the number of mappings in this map
     */
    @Override
    public int size() {
        return 0;
    }
}
