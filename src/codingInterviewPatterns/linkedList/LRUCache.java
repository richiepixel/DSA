package codingInterviewPatterns.linkedList;

import java.util.HashMap;

public class LRUCache {
  class Node{
    int key, value;
    Node prev, next;

    Node(int k, int v){
      key = k;
      value = v;
    }
  }
  private int capacity;
  private HashMap<Integer, Node> cache;
  private Node head, tail;

  public LRUCache(int capacity){
    this.capacity = capacity;
    cache = new HashMap<>();
    head = new Node(0,0);
    tail = new Node(0,0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key){
    if(cache.containsKey(key)){
      Node node = cache.get(key);

    }
    return 0;
  }

  private void remove(Node node){
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
