package com.rohit.ds_algo;

/**
 * The use of a linked list is important because of collisions: you could have two 
 * different keys with the same hash code or two different hash codes that map to the same index.
 * 
 * In case of collision
 * List[index]: <k,v> -> <k,v> -> <k,v>
 * 
 * 
 * 
	Time Complexity
	Since different keys can be mapped to the same index, there is a chance of collision.
	If the number of collisions is very high, the worst case runtime is O(n), where n is the number of keys.
	However, we generally assume a good implementation that keeps collisions to a minimum, in which case the
	lookup time is O(1).
 * @author 2714rohit
 * @param <K>
 * @param <V>
 */
public class MapImplimentationMain{
	
	public static void main(String[] args) {
		testMyMap();
	}
	public static void testMyMap() {
	    MyMap<String, String> myMap = new MyMap<>();
	    myMap.put("USA", "Washington DC");
	    myMap.put("Nepal", "Kathmandu");
	    myMap.put("India", "New Delhi");
	    myMap.put("Australia", "Sydney");
	    
	    System.out.println(myMap.get("India"));
	}
}

class MyMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 1 << 4; // 16

    private int size = 0;

    public MyMap() {
        this(INITIAL_CAPACITY);
        //this.buckets = new Entry[INITIAL_CAPACITY];
    }

    public MyMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);

        int bucket = getHash(key) % getBucketSize();

        Entry<K, V> existing = buckets[bucket];
        if (existing == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            // compare the keys see if key already exists
            while (existing.next != null) {
                if (existing.key.equals(key)) {
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }

            if (existing.key.equals(key)) {
                existing.value = value;
            } else {
                existing.next = entry;
                size++;
            }
        }
    }
    
    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                return bucket.value;
            }
            bucket = bucket.next;
        }
        return null;
    }
    
    public int getBucketSize() {
    	return buckets.length;
    }
    
    public int getHash(K key) {
    	return key.hashCode();
    }
}

class Entry<K, V> {
    final K key;
    V value;
    Entry<K, V> next;

    public Entry(K key, V value, Entry<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}


