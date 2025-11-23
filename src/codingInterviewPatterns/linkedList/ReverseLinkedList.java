package codingInterviewPatterns.linkedList;

public class ReverseLinkedList {

  public static ListNode reverseList(ListNode head) {
    ListNode prevNode = null;
    ListNode currentNode = head;

    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = nextNode;
    }
    return prevNode;
  }

  public static ListNode reverseListRecursive(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode newHead = reverseListRecursive(head.next);
    head.next.next = head;
    head.next = null;

    return newHead;

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

    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(4);
    head2.next.next.next.next = new ListNode(5);

    System.out.println("Original list: ");
    printList(head);

    ListNode reversed = reverseList(head);
    ListNode reversedRecur = reverseListRecursive(head2);

    System.out.println("Reversed list: ");
    printList(reversed);

    System.out.println("Recursion: ");
    printList(reversedRecur);

  }
}
