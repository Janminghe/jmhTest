/**
 * author jmh
 */
public class Test234 {
    public boolean isPalindrome(ListNode head){
        if(head.next == null){
            return true;
        }
        StringBuffer str = new StringBuffer();
        ListNode node = head;
        while(node != null){
            str.append(node.val);
            node = node.next;
        }
        return isPalindromeString(str.toString());
    }
    public boolean isPalindrome2(ListNode head){
        if(head.next == null){
            return true;
        }
        if(head.next.next == null){
            if(head.val == head.next.val){
                return true;
            }else{
                return false;
            }
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = reverse(slow.next);
        while(temp != null){
            if(temp.val != head.val){
                return false;
            }else{
                temp = temp.next;
                head = head.next;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while(next != null){
            curr.next = pre;
            pre = curr;
            curr = next;
            next = next.next;
        }
        curr.next = pre;
        return curr;
    }

    public boolean isPalindromeString(String str){
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left < right){
            if(chars[left] == chars[right]){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
