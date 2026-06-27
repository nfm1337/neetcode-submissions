class MyLinkedList() {

    private class ListNode(val value: Int, var next: ListNode? = null, var prev: ListNode? = null)

    private var head: ListNode? = null
    private var tail: ListNode? = null
    private var size: Int = 0

    fun get(index: Int): Int {
        val node = getNode(index)
        return node?.value ?: -1
    }

    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`, next = head)
        if (head == null) {
            tail = newNode
        } else {
            head?.prev = newNode
        }
        head = newNode
        size++
    }

    fun addAtTail(`val`: Int) {
        val newNode = ListNode(`val`, prev = tail)
        if (tail == null) {
            head = newNode
        } else {
            tail?.next = newNode
        }
        tail = newNode
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index !in 0..size) return

        if (index == 0) {
            addAtHead(`val`)
            return
        }

        if (index == size) {
            addAtTail(`val`)
            return
        }

        val current = getNode(index) ?: return
        val previous = current.prev
        val newNode = ListNode(`val`, next = current, prev = previous)

        previous?.next = newNode
        current.prev = newNode

        size++
    }

    fun deleteAtIndex(index: Int) {
        val node = getNode(index) ?: return

        val previous = node.prev
        val next = node.next

        if (previous == null) {
            head = next
        } else {
            previous.next = next
        }

        if (next == null) {
            tail = previous
        } else {
            next.prev = previous
        }

        size--
    }

    private fun getNode(index: Int): ListNode? {
        if (index !in 0..<size) return null

        var curIndex = 0
        var curNode = head

        while (curIndex < index) {
            curNode = curNode?.next
            curIndex++
        }
        
        return curNode
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
