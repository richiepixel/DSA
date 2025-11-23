package codingInterviewPatterns.linkedList;

public class LinkedListLoop {
  class Node{
    int value;
    Node next;

    Node(int value){
      this.value = value;
    }
  }

  public boolean isLinkedListLoop(Node head){
    if(head == null) return false;
    Node slow = head, fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast) return true;
    }
    return false;
  }

  public Node buildList(int[] values) {
    if (values.length == 0) return null;

    Node head = new Node(values[0]);
    Node current = head;

    for (int i = 1; i < values.length; i++) {
      current.next = new Node(values[i]);
      current = current.next;
    }
    return head;
  }

  public static void main(String[] args) {
    LinkedListLoop ll = new LinkedListLoop();

    // 1) No cycle: 1 → 2 → 3 → 4 → null
    Node head1 = ll.buildList(new int[]{1,2,3,4});
    System.out.println("Test 1 (no cycle): " + ll.isLinkedListLoop(head1));

    // 2) Cycle at end: 1 → 2 → 3 → 4 → 2...
    Node head2 = ll.buildList(new int[]{1,2,3,4});
    head2.next.next.next.next = head2.next;  // node 4 → node 2
    System.out.println("Test 2 (cycle at 2): " + ll.isLinkedListLoop(head2));

    // 3) Cycle in middle: 1 → 2 → 3 → 4 → 5 → 3...
    Node head3 = ll.buildList(new int[]{1,2,3,4,5});
    head3.next.next.next.next = head3.next.next; // node 5 → node 3
    System.out.println("Test 3 (cycle at 3): " + ll.isLinkedListLoop(head3));

    // 4) Self loop: 1 → 1
    Node head4 = ll.buildList(new int[]{1});
    head4.next = head4;
    System.out.println("Test 4 (self loop): " + ll.isLinkedListLoop(head4));

    // 5) Single node no cycle
    Node head5 = ll.buildList(new int[]{7});
    System.out.println("Test 5 (1 node no cycle): " + ll.isLinkedListLoop(head5));

    // 6) Two nodes no cycle
    Node head6 = ll.buildList(new int[]{10, 20});
    System.out.println("Test 6 (2 nodes no cycle): " + ll.isLinkedListLoop(head6));
  }
}
