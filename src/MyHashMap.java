import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    public int size;
    private final Node<K, V>[] table;
    private final int capacity;

    MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    MyHashMap(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new Node[capacity];
    }

    public void put(K key, V value) {

        Node<K, V> myNode = new Node<>(key, value);

        int hash = hash(key);

        if (table[hash] == null) {
            table[hash] = myNode;
        } else {
            Node<K, V> curentNode = table[hash];
            Node<K, V> previousNode = null;

            while (curentNode != null) {
                if (curentNode.key.equals(key)) {
                    curentNode.value = myNode.value;
                    return;
                }

                previousNode = curentNode;
                curentNode = curentNode.next;

            }

//            assert previousNode != null;
            previousNode.next = myNode;

        }
        this.size++;
    }

    public Node<K, V> getNode(K key) {
        int hash = hash(key);

        if (table[hash] == null)
            return null;
        else {
            Node<K, V> currentNode = table[hash];

            while (currentNode != null) {
                if (currentNode.key != null && currentNode.key.equals(key)) {
                    return currentNode;
                } else if (currentNode.key == null && key == null) {
                    return currentNode;
                }

                currentNode = currentNode.next;
            }
        }

        return null;
    }

    public V get(K key) {
        Node<K, V> e = getNode(key);
        return e == null ? null : e.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    public V remove(K key)
    {
        int hash = hash(key);

        if(table[hash]  == null) return null;

        else
        {
            Node<K,V> currentNode = table[hash];
            Node<K,V> previousNode = null;


            while (currentNode != null)
            {
                if(currentNode.key.equals(key) && previousNode == null)
                {
                    V val = currentNode.value;
                    previousNode = currentNode.next;
                    currentNode.next = null;
                    
                    table[hash] = previousNode;
                    this.size--;
                    return val;

                } else if (currentNode.key.equals(key)) {
                    V val1 = currentNode.value;
                    previousNode.next = currentNode.next;
                    currentNode.next = null;
                    this.size--;
                    return val1;
                }

                previousNode = currentNode;
                currentNode = currentNode.next;
            }


        }

        return null;
    }


    public void clear()
    {
        Node<K,V>[] tab;

        if((tab = table) != null && this.size > 0)
        {
            size = 0;
            Arrays.fill(tab, null);
        }
    }

    private int hash(K key) {
        return key == null ? 0 : (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public static class Node<K, V> {
        private final K key;
        private V value;

        private Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }


}

