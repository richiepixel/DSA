package codingInterviewPatterns.linkedList;

import java.util.HashSet;

public class LinkedListIntersection {

  public static ListNode findIntersection(ListNode headA, ListNode headB) {
    HashSet<ListNode> setNodes = new HashSet<>();

    ListNode currentA = headA;
    while (currentA != null) {
      setNodes.add(currentA);
      currentA = currentA.next;
    }

    ListNode currentB = headB;
    while (currentB != null) {
      if (setNodes.contains(currentB)) return currentB;
      currentB = currentB.next;
    }
    return null;
  }

  public static ListNode findIntersectionWithoutHash(ListNode headA, ListNode headB){
    if(headA == null || headB == null) return null;
    ListNode pA = headA;
    ListNode pB = headB;

    while(pA != pB){
      pA = (pA == null) ? headB : pA.next;
      pB = (pB == null) ? headA : pB.next;
    }
    return pA;
  }

  public static void printList(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    ListNode intersect = new ListNode(8);
    intersect.next = new ListNode(4);
    intersect.next.next = new ListNode(5);

    ListNode headA = new ListNode(4);
    headA.next = new ListNode(1);
    headA.next.next = intersect;

    ListNode headB = new ListNode(5);
    headB.next = new ListNode(6);
    headB.next.next = new ListNode(1);
    headB.next.next.next = intersect;

    //printList(findIntersection(headA, headB));
    printList(findIntersectionWithoutHash(headA, headB));

  }
}
