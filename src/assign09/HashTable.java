package assign09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K,V> implements Map{
    K k;
    V v;
    private int size=10;
    private int mappings=0;

    ArrayList<LinkedList<MapEntry<K,V>>> backingArr = new ArrayList(size);
    public HashTable(){
        for(int i=0;i<size;i++){
            backingArr.add(new LinkedList<MapEntry<K,V>>());
        }
    }
    /**
     * Removes all mappings from this map.
     * <p>
     * O(table length) for quadratic probing or separate chaining
     */
    @Override
    public void clear() {
        //backingArr.clear();
        size = 10;
        mappings=0;
        backingArr= new ArrayList<>(size);
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
        return get(key) != null;
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
        for (List<MapEntry<K,V>> m: backingArr) {
            for(MapEntry me: m)
                if(me.getValue().equals(value)){
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
    public List<MapEntry<K,V>> entries() {
        ArrayList<MapEntry<K,V>> ret = new ArrayList();
        for (LinkedList<MapEntry<K,V>> m: backingArr) {
            for (MapEntry<K,V> me : m){
                if (me.getValue() != null) {
                    ret.add(me);
                }
        }
        }
        return ret;
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
        int index = compressor(key.hashCode());
        var temp = backingArr.get(index);
        for(MapEntry mp: temp)
            if(mp.getKey().equals(key))
                return mp.getValue();
        return null;
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
        var val=getLoad();
        return val==(float)0.0;
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
        if(getLoad()>2.5){
            reHash();
        }
        Object retVal=null;
        int index=compressor(key.hashCode());
        var temp=backingArr.get(index);
        MapEntry<K,V> add = new MapEntry<>((K)key,(V)value);
        //linked list at spot is empty
        if(temp.isEmpty()) {
            var tempList = new LinkedList<MapEntry<K,V>>();
            tempList.add(add);
            mappings++;
            backingArr.set(index,tempList);
        }
        else {// linked list already there
            for(MapEntry mp: temp){
                if (mp.getKey().equals(key)) {
                    retVal = mp.getValue();
                    mp.setValue(add.getValue());

                    return retVal;
                }
            }
            temp.add(add);
            mappings++;
        }
        return retVal;
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
        int index = compressor(key.hashCode());
        LinkedList<MapEntry<K,V>> temp=backingArr.get(index);
        for(MapEntry m:temp){
            if(m.getKey().equals(key)){
                var retVal = m.getValue();
                temp.remove(m);
                mappings--;
                return retVal;
            }

        }
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
        return mappings;
    }

    private void reHash(){
        var temp=this.entries();
        size*=2;
        this.backingArr = new ArrayList<LinkedList<MapEntry<K,V>>>(size);
        for(int i=0;i<size;i++){
            this.backingArr.add(new LinkedList<>());
        }
        mappings=0;
        for(MapEntry m:temp){
            put(m.getKey(),m.getValue());
        }
    }
    private int compressor(int hashCode){
        return Math.abs(hashCode%size);
    }
    public float getLoad(){
        return ((float)mappings/(float)size);
    }

}
