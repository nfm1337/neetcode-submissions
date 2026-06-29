/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        var slow = head
        var fast = head?.next
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var second = slow?.next
        slow?.next = null

        var prev: ListNode? = null
        var curr = second
        while (curr != null) {
            val nextTemp = curr?.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }

        var first = head
        while (prev != null) {
            val tmp1 = first?.next
            val tmp2 = prev?.next
            first?.next = prev
            prev?.next = tmp1
            first = tmp1
            prev = tmp2
        }
    }
}
