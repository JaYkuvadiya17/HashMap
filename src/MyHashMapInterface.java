public interface MyHashMapInterface<K,V> {

    int size();
    void put(K key, V value);

    interface Node <K, V>{}

    Node<K,V> getNode(K key);
    V get(K key);
    boolean isEmpty();

    boolean containsKey(K key);
    boolean containsValue(V value);
    V remove(K key);

    void clear();
    int hash(K key);






}
