public interface MyHashMapInterface<K,V> {

    public  void put(K key, V value);
    public MyHashMap.Node<K,V> getNode(K key);

}
