import java.util.*;
public class HashMap<K, V> {

	K key;
	V value;
	int capacity = 1000;// Default Capacity
	V[] map = (V[])new Object[capacity];
	int w;
	
	
	public HashMap() {
		
	}
	
	public HashMap(int j) {
		this.capacity = j;
		//this.key = key;
		//this.value = value;
	}
	
	public void put(K k, V v) {
		V temp = v;
		if(k == null) {
			System.out.println("Nothing for k was entered ");
		}
		int x = Math.abs((k.hashCode()) % capacity);
		//map[x] = temp;
		
		if(map[x] == null) {
			map[x] = temp;
		}
		else
			x+=1;
			map[x] = temp;
		
		
	}
	
	public V get(K k) {
		int j = Math.abs(k.hashCode() % capacity);
		V velvet = (V)map[j];
		return velvet;
		
		
	}
	
	public V linearProbing(K k) {
		int x = (k.hashCode()) % capacity;
		return map[x + 1];
	}
	
	
	public boolean contains(K k) {
		int x = Math.abs((k.hashCode()) % capacity);
		return(map[x] != null);
	}
	
	
	public void setLoadSize(int p) {
		this.w = p;
	}
	
	public float getLoadSize() {
		return (float) w / capacity;
	}
	
	
	
	
	
	
}
