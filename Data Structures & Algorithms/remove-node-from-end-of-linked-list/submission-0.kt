/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var left: ListNode? = dummy
        var right = head

        var count = n
        while (count > 0) {
            right = right?.next
            count--
        }

        while (right != null) {
            left = left?.next
            right = right?.next
        }

        left?.next = left?.next?.next
        
        return dummy.next
    }
}
