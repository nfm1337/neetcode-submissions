class MyLinkedList() {

    private class ListNode(val value: Int) {
        var next: ListNode? = null
        var prev: ListNode? = null
    }

    private var head: ListNode? = null
    private var tail: ListNode? = null
    private var size: Int = 0

    fun get(index: Int): Int {
        return getNode(index)?.value ?: -1
    }

    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`).apply {
            next = head
        }

        head?.prev = newNode
        head = newNode

        if (tail == null) {
            tail = newNode
        }

        size++
    }

    fun addAtTail(`val`: Int) {
        val newNode = ListNode(`val`).apply {
            prev = tail
        }

        tail?.next = newNode
        tail = newNode

        if (head == null) {
            head = newNode
        }

        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        when {
            index <= 0 -> addAtHead(`val`)
            index > size -> return
            index == size -> addAtTail(`val`)
            else -> {
                val current = getNode(index) ?: return
                val previous = current.prev

                val node = ListNode(`val`).apply {
                    prev = previous
                    next = current
                }

                previous?.next = node
                current.prev = node

                size++
            }
        }
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

        return if (index < size / 2) {
            var current = head
            repeat(index) {
                current = current?.next
            }
            current
        } else {
            var current = tail
            repeat(size - index - 1) {
                current = current?.prev
            }
            current
        }
    }
}