package com.kzl.leetcode.problem_1_50;

import com.kzl.leetcode.utils.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        //l2.next.next.next = new ListNode(9);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int num = 0;
        while (l1.next != null && l2.next != null) {
            int sum = num + l1.val + l2.val;
            num = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }


        l1.val = num + l1.val + l2.val;
        num = l1.val / 10;
        l1.val %= 10;
        if (l2.next != null) {
            l1.next = l2.next;
        }

        if (num != 0) {
            if (l1.next == null) {
                l1.next = new ListNode(num);
                l1.next.next = null;
            } else {
                while (l1.next != null) {
                    l1.next.val += num;
                    num = l1.next.val / 10;
                    l1.next.val %= 10;
                    l1 = l1.next;
                }

                if (num != 0) {
                    l1.next = new ListNode(num);
                    l1.next.next = null;
                }
            }
        }

        return head;
    }
}
