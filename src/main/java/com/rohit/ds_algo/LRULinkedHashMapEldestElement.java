package com.rohit.ds_algo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMapEldestElement {
	
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		cache.put(1);
		cache.put(2);
		cache.put(3);
		System.out.println(cache.get(1));
		cache.put(4);
		cache.put(5);
		System.out.println(cache.get(2));
	}
}

class LRUCache{
	Map<Integer, Integer> lru = null;
	int capacity = 0;
	LRUCache(int capacity){
		this.capacity = capacity;
		lru = new LinkedHashMap<Integer, Integer>(capacity) {
			@Override
			public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return size()>capacity;
			}
		};
	}
	
	public int get(int val) {
		if(lru.containsKey(val)) {
			lru.remove(val);
			lru.put(val, val);
			return val;
		}else return -1;
	}
	
	public void put(int val) {
		if(lru.containsKey(val)) {
			lru.remove(val);
			lru.put(val,  val);
		}else lru.put(val,  val);
	}
}
