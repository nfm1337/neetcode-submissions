/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null) return list2
        if (list2 == null) return list1
        
        val dummy = ListNode(-1)
        var curr: ListNode? = dummy
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                curr?.next = l1
                l1 = l1.next
            } else {
                curr?.next = l2
                l2 = l2.next
            }
            curr = curr?.next
        }

        curr?.next = l1 ?: l2

        return dummy.next
    }
}
