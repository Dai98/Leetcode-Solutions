package Leetcode206;
import common.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * https://blog.csdn.net/qq_41231926/article/details/82377446
 */

class Solution{

    public ListNode reverseList(ListNode head){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur1 = dummyHead;
        if(cur1.next == null || cur1.next.next == null){
            return head;
        }
        ListNode cur2 = cur1.next;
        ListNode cur3 = cur2.next;
        while(cur3 != null) {
            cur2.next = cur3.next;
            ListNode temp = cur1.next;
            cur1.next = cur3;
            cur3.next = temp;
            cur3 = cur2.next;
        }
        return dummyHead.next;

    }

    public ListNode reverseListRecursive(ListNode head){
        // 退出条件
        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

public class ReverseList {

    public static void main(String[] args){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode reverse_head = solution.reverseList(head);
        ListNode reverse_head2 = solution.reverseListRecursive(head);


        while(reverse_head != null){
            System.out.print(reverse_head.val);
            if(reverse_head.next != null){
                System.out.print("->");
            }
            reverse_head = reverse_head.next;
        }
        System.out.println();

        System.out.println(reverse_head2.next);
        while(reverse_head2 != null){
            System.out.print(reverse_head2.val);
            if(reverse_head2.next != null){
                System.out.print("->");
            }
            reverse_head2 = reverse_head2.next;
        }

    }
}
