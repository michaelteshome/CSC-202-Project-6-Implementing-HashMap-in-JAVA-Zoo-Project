
public class MapEntry<K, V> {

	protected K key;
	protected V value;
	
	public MapEntry(K k, V v) {
		key = k;
		value = v;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K keyu) {
		this.key = keyu;
	}
	
	public V getValue() {
		return value;
	}
	
	public void setValue(V v) {
		this.value = v;
	}
	
	
}
