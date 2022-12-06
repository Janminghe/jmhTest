/**
 * author jmh
 */
public class Test092 {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        Test092 test = new Test092();
        ListNode listNode = test.reverseBetween(node1, 1, 2);
        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == right){
            return head;
        }
        ListNode temp = head;
        ListNode leftNode = new ListNode();
        ListNode rightNode = new ListNode();
        ListNode pre = new ListNode(0, head);
        ListNode tail = new ListNode();
        int count = 1;
        while(temp != null){
            if(count == left){
                leftNode = temp;
                break;
            }
            pre = pre.next;
            temp = temp.next;
            count++;
        }
        while(temp != null){
            if(count == right){
                rightNode = temp;
                tail = rightNode.next;
                break;
            }
            temp = temp.next;
            count++;
        }

        ListNode[] result = reverse(leftNode, rightNode);
        pre.next = result[0];
        result[1].next = tail;
        if(left == 1){
            return pre.next;
        }
        return head;
    }

    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode[] result = new ListNode[2];
        if(head.next == tail){
            tail.next = head;
            head.next = null;
            result[0] = tail;
            result[1] = head;
            return result;
        }
        result = reverse(head.next, tail);
        result[1].next = head;
        head.next = null;
        result[1] = head;
        return result;
    }
}
