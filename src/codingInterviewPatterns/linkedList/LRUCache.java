package codingInterviewPatterns.linkedList;

import java.util.HashMap;

public class LRUCache {
  private class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity;
  private HashMap<Integer, Node> cache;
  private Node head, tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    cache = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null) return -1;
    removeNode(node);
    addNodeToTail(node);
    return node.value;
  }

  public void put(int key, int value){
    Node node = cache.get(key);

    if(node != null){
      node.value = value;
      removeNode(node);
      addNodeToTail(node);
      return;
    }

    if(cache.size() >= capacity){
      Node lru = head.next;
      cache.remove(lru.key);
      removeNode(lru);
    }
    node = new Node(key,value);
    addNodeToTail(node);
    cache.put(key,node);
  }

  public void removeNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public void addNodeToTail(Node node) {
    Node prev_node = tail.prev;
    node.prev = prev_node;
    node.next = tail;
    prev_node.next = node;
    tail.prev = node;
  }
  public static void main(String[] args) {
    LRUCache cache = new LRUCache(2);
    System.out.println(cache.get(1)); // -1 (not found)

    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1)); // 1

    cache.put(3, 3); // evicts key 2
    System.out.println(cache.get(2)); // -1

    cache.put(4, 4); // evicts key 1
    System.out.println(cache.get(1)); // -1
    System.out.println(cache.get(3)); // 3
    System.out.println(cache.get(4)); // 4
  }
}
