class BrowserHistory(homepage: String) {

    private var current: Node = Node(homepage)

    fun visit(url: String) {
        val newEntry = Node(url)
        newEntry.prev = current
        current.next = newEntry
        current = newEntry
    }

    fun back(steps: Int): String {
        var count = 0
        while (count < steps && current.prev != null) {
            current = current.prev!!
            count++
        }

        return current.url
    }

    fun forward(steps: Int): String {
        var count = 0
        while (count < steps && current.next != null) {
            current = current.next!!
            count++
        }

        return current.url
    }

    private class Node(val url: String) {
        var next: Node? = null
        var prev: Node? = null
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */