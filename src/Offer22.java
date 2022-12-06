
/**
 * author jmh
 */
public class Offer22 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        Offer22 test = new Offer22();
        ListNode result = test.getKthFormEnd(node1, 2);
        while(result != null){
            System.out.println(result.val);
        }

    }

    public ListNode getKthFormEnd(ListNode head, int k){
        ListNode tail = reverse(head);
        ListNode tailK = tail;
        int count = 1;
        while(count < k){
            tailK = tailK.next;
            count++;
        }
        tailK.next = null;
        return reverse(tail);

    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
