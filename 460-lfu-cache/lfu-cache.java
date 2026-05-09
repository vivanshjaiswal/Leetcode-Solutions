import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;

        int size;

        DoublyLinkedList() {

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void addFirst(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size > 0) {

                Node node = tail.prev;

                remove(node);

                return node;
            }

            return null;
        }
    }

    int capacity;
    int minFreq;

    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // key already exists
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            updateFreq(node);

            return;
        }

        // cache full
        if (keyMap.size() == capacity) {

            DoublyLinkedList minList = freqMap.get(minFreq);

            Node nodeToRemove = minList.removeLast();

            keyMap.remove(nodeToRemove.key);
        }

        Node newNode = new Node(key, value);

        minFreq = 1;

        DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());

        list.addFirst(newNode);

        freqMap.put(1, list);

        keyMap.put(key, newNode);
    }

    private void updateFreq(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        // if this was minimum frequency and list became empty
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DoublyLinkedList newList =
                freqMap.getOrDefault(node.freq, new DoublyLinkedList());

        newList.addFirst(node);

        freqMap.put(node.freq, newList);
    }
}