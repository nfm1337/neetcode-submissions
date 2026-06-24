class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var curMax = -1

        for (i in arr.lastIndex downTo 0) {
            val curr = arr[i]
            arr[i] = curMax
            curMax = Math.max(curMax, curr)
        }

        return arr
    }
}
