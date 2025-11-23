package codingInterviewPatterns.linkedList;

public class RemoveKthLastNode {

  public static ListNode removeKthElementFromEnd (ListNode head, int k){
    ListNode dummyNode = new ListNode(0);
    dummyNode.next = head;

    ListNode slowNode = dummyNode;
    ListNode fastNode = dummyNode;

    //Move fast k steps ahead.
    for(int i = 0; i <= k; i++){
      fastNode = fastNode.next;
    }

    //Move both until fast reaches the end,
    while(fastNode != null){
      fastNode = fastNode.next;
      slowNode = slowNode.next;
    }

    //Move the pointers to delete the element
    slowNode.next = slowNode.next.next;

    return dummyNode.next;
  }

  public static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    System.out.printf("Original: ");
    printList(head);

    System.out.printf("After removal: ");
    printList(removeKthElementFromEnd(head, 3 ));
  }
}
