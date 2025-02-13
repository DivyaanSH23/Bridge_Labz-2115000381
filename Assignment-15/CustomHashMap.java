import java.util.LinkedList;

class CustomHashMap {
    private class HashMapNode {
        int key;
        int value;

        HashMapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<HashMapNode>[] table;
    private int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<HashMapNode> bucket = table[index];
        for (HashMapNode node : bucket) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        bucket.add(new HashMapNode(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        LinkedList<HashMapNode> bucket = table[index];
        for (HashMapNode node : bucket) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        LinkedList<HashMapNode> bucket = table[index];
        for (HashMapNode node : bucket) {
            if (node.key == key) {
                bucket.remove(node);
                return;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(10);
        map.put(1, 10);
        map.put(2, 20);
        map.put(11, 30);  
        System.out.println("Value for key 1: " + map.get(1)); 
        System.out.println("Value for key 2: " + map.get(2)); 
        System.out.println("Value for key 11: " + map.get(11)); 
        map.remove(1);
        System.out.println("Value for key 1 after removal: " + map.get(1)); 
    }
}
