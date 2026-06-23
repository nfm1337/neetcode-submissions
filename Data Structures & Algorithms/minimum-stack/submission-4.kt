class MinStack() {

    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        minStack.add(min(`val`, minStack.lastOrNull() ?: Integer.MAX_VALUE))
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
