package Leetcode23;

import common.ListNode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。
 * 示例：
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */

// 思路一：将所有值放到一个数组中排序，并产生新的链表
// 思路二：使用优先队列
// 思路三：分治算法，并列相邻的两个链表，直到只剩下一个链表为止
class Solution{

    public ListNode mergeKLists(ListNode[] lists){
        // 如果数组中没有头节点
        if(lists == null | lists.length == 0){
            return null;
        }

        // 如果数组中只有一个头节点
        int num = lists.length;
        if(num == 1){
            return lists[0];
        }

        // 如果有多个头节点
        return splitTwo(lists, 0, num-1);
    }

    // 分治递归
    private ListNode splitTwo(ListNode[] lists, int l, int r){
        // 退出条件
        // 当只分割到一个头节点的时候 返回Lists[l]
        if(l == r){
            return lists[l];
        }
        int mid = l + (r-l)/ 2;
        return mergeTwo(splitTwo(lists, l, mid), splitTwo(lists, mid + 1, r));
    }

    // 两个链表排序成一个链表
    private ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode nhead = null;
        if(l1.val < l2.val){
            nhead = l1;
            nhead.next = mergeTwo(l1.next, l2);
        }else{
            nhead = l2;
            nhead.next = mergeTwo(l2.next, l1);
        }
        return nhead;
    }

}

public class MergeKLists{

    public static void main(String[] args){
        Solution solution = new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode head = solution.mergeKLists(lists);

        while(head != null){
            System.out.print(head.val);
            if(head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }


    }

}