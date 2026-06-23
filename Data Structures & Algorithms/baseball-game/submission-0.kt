class Solution {
    fun calPoints(operations: Array<String>): Int {
        val scores = mutableListOf<Int>()

        for (op in operations) {
            when (op) {
                "+" -> scores.add(scores[scores.lastIndex] + scores[scores.lastIndex - 1])
                "D" -> scores.add(scores.last() * 2)
                "C" -> scores.removeLast()
                else -> scores.add(op.toInt())
            }
        }
        
        return scores.sum()
    }
}
