class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        
        for (ch in s) {
            when (ch) {
                '(' -> stack.addLast(')')
                '[' -> stack.addLast(']')
                '{' -> stack.addLast('}')
                else -> {
                    if (stack.isEmpty() || stack.removeLast() != ch) {
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
}
