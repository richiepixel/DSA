package codingInterviewPatterns.linkedList;

public class LinkedListMidPoint {
  class Node {
    int val;
    Node next;

    Node(int val){
      this.val = val;
    }
  }

  public Node findMidpoint(Node head){

    if(head == null) return null;
    Node fast = head, slow = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
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
    LinkedListMidPoint ll = new LinkedListMidPoint();

    // Helper to print mid
    java.util.function.Consumer<Node> printMid = n ->
            System.out.println(n == null ? "null" : n.val);

    // ---------- TEST 1: Odd length ----------
    Node head1 = ll.buildList(new int[]{1,2,3,4,5});
    System.out.print("Test 1 (odd): expected 3 → got: ");
    printMid.accept(ll.findMidpoint(head1));

    // ---------- TEST 2: Even length ----------
    Node head2 = ll.buildList(new int[]{1,2,3,4,5,6});
    System.out.print("Test 2 (even): expected 4 → got: ");
    printMid.accept(ll.findMidpoint(head2));

    // ---------- TEST 3: Single node ----------
    Node head3 = ll.buildList(new int[]{10});
    System.out.print("Test 3 (single): expected 10 → got: ");
    printMid.accept(ll.findMidpoint(head3));

    // ---------- TEST 4: Two nodes ----------
    Node head4 = ll.buildList(new int[]{7, 8});
    System.out.print("Test 4 (two nodes): expected 8 → got: ");
    printMid.accept(ll.findMidpoint(head4));

    // ---------- TEST 5: Empty list ----------
    Node head5 = null;
    System.out.print("Test 5 (empty): expected null → got: ");
    printMid.accept(ll.findMidpoint(head5));
  }
}
