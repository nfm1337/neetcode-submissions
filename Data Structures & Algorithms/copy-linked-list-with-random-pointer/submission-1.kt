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
        return recursiveCopy(head, nodeToCopy)
    }

    private fun recursiveCopy(node: Node?, cache: MutableMap<Node, Node>): Node? {
        if (node == null) {
            return null
        }

        if (node in cache) {
            return cache[node]
        }

        val copy = Node(node.`val`)
        cache[node] = copy
        copy.next = recursiveCopy(node.next, cache)
        copy.random = recursiveCopy(node.random, cache)

        return cache[node]
    }
}
