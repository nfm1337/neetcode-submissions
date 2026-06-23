class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxCount = 0
        var count = 0

        for (num in nums) {
            if (num == 1) {
                count++
                maxCount = Math.max(count, maxCount)
            } else {
                count = 0
            }
        }

        return maxCount
    }
}
