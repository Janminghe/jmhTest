import javax.print.attribute.standard.PagesPerMinute;

/**
 * author jmh
 */
public class Test083 {
    public static void main(String[] args) {

    }
    public ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode next = head.next;
        while(next != null){
            if(pre.val == next.val){
                pre.next = null;

            }else{
                pre.next = next;
                pre = next;
            }
            next = next.next;
        }
        return head;
    }
}
