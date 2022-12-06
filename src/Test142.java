import java.util.HashSet;
import java.util.Set;

/**
 * author jmh
 */
public class Test142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }else{
                set.add(temp);
                temp = temp.next;
            }
        }
        return null;
    }
}
