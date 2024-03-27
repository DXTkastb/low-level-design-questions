package com.hashmap;
import java.util.*;

/*
	Process :
		
		1. get hashcode of key(object) and hash it is again in order to reduce collisions and increase randomness.
		2. calculate bucket(array index) to push this key to.
		3. get the linkedlist for the bucket(index) 
		4. compare each key in the linkedlist with provided key using equals and hashCode.
			4.1 if key already exists, update its value
			4.2 if not found in the entire array, insert this key as the head of the key.
		5. for remove :
			5.1 search key , if not found -> raise exception else :
				5.1.1 if its head of the linked list, make its next node entry as head, if not make its previous list node point to its next node.
		6. after each add and remove operation, check for rehashing.
		7. for get search  
*/

/*
		This HashMap is thread-UNSAFE and uses LinkedList to overcome Collisions (Collision Chaining)
		
		** Improvements ! **
			
			1. make thread safe
			2. use Red-Back tree instead of LinkedList for storing hashEntries to boost performance
*/

public class CustomHashMap<T,K> {
	private double loadFactor = 0.75;
	private int size = 16;
	private int currentSize = 0;
	private final int minSize = 16;
	private LinkedList<HashEntry<T,K>>[] entries;
	
	public CustomHashMap() {
		entries = (LinkedList<HashEntry<T,K>>[]) new LinkedList[size];
	}
	
	public CustomHashMap(int customSize) {
		this.size = customSize;
		entries = (LinkedList<HashEntry<T,K>>[]) new LinkedList[size];
	}
	
	public void put(T key, K value) {
		LinkedList<HashEntry<T,K>> list = getBucketList(key);
		HashEntry<T,K> entry = new HashEntry<>(key,value);
		updateOrAddKey(list,entry);
		currentSize++;
		reHash();
	}
	
	private void updateOrAddKey(LinkedList<HashEntry<T,K>> list, HashEntry<T,K> entry) {
		HashEntry<T,K> oldKeyValue = searchKey(list,entry.getKey());
		if(oldKeyValue == null) {
			list.add(entry);
		}
		else {
			oldKeyValue.updateEntry(entry.getKey(),entry.getValue());
		}
	}
	
	private HashEntry<T,K> searchKey(LinkedList<HashEntry<T,K>> list, T key) {
		for(HashEntry<T,K> entry : list) {
			if(entry.checkEquality(key)) return entry;
		}
		return null;
	}
	
	private LinkedList<HashEntry<T,K>> getBucketList(T key) {
		int bucket = getBucket(getHash(key));
		LinkedList<HashEntry<T,K>> list = entries[bucket];
		if(list == null) entries[bucket] = list = new LinkedList<>();
		return list;
	}
	
	public void remove(T key) {
		LinkedList<HashEntry<T,K>> list = getBucketList(key);
		HashEntry<T,K> entry = searchKey(list,key);
		HashEntry<T,K> firstEntry = list.getFirst();
		if(!(firstEntry.checkEquality(entry.getKey()))) entry.updateEntry(firstEntry.getKey(),firstEntry.getValue());
		list.removeFirst();
		currentSize--;
		reHash();
	}
	
	public K get(T key) {
		LinkedList<HashEntry<T,K>> list = getBucketList(key);
		HashEntry<T,K> entry = searchKey(list,key);
		return entry.getValue();
	}
	
	private void reHash() {
		int normalSize = (int) (loadFactor * size);
		int oldSize = (int) (loadFactor * (size >> 1));
		LinkedList<HashEntry<T,K>>[] tempList = entries;
		boolean reHashNeeded = false;
		
		if(currentSize >= normalSize) {
			size = (size << 1) ; 
			reHashNeeded = true;			
		}
		
		else if(currentSize < oldSize && size > minSize) {
			size = (size >> 1) ; 
			reHashNeeded = true;
		}
		
		if(reHashNeeded) {
			entries = (LinkedList<HashEntry<T,K>>[]) new LinkedList[size];
			for(LinkedList<HashEntry<T,K>> list : tempList) {
				if(list != null) {
					for(HashEntry<T,K> entry : list) {
						put(entry.getKey(),entry.getValue());
					}
				}
			}
		}
		 
	}
	
	private int getHash(Object object) {
		int objectHashCode = object.hashCode();
		return HashFunction.hash(objectHashCode);
	}
	
	private int getBucket(int hash) {
		return hash & (size - 1);
	}
	
}

/*
	add some hashing algo !
*/

class HashFunction {
	public static int hash(int value) {
		return value;
	}
}

class HashEntry<T,K> {
	private T t;
	private K k;
	
	public HashEntry(T key, K value) {
		this.t = key;
		this.k = value;
	}
	
	public boolean checkEquality(T key) {
		return t.hashCode() == key.hashCode() && t.equals(key);
	}
	
	public void updateEntry(T key, K value) {
		this.t = key;
		this.k = value;
	}
	
	public T getKey() {
		return t;
	}
	
	public K getValue() {
		return k;
	}
		
}
