/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        val nodeToCopy = mutableMapOf<Node, Node>()
        var curr = head
        while (curr != null) {
            nodeToCopy[curr] = Node(curr.`val`)
            curr = curr.next
        }

        for ((original, copy) in nodeToCopy) {
            copy.next = nodeToCopy[original.next]
            copy.random = nodeToCopy[original.random]
        }

        return nodeToCopy[head]
    }
}
