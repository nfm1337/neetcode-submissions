class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val valueToIndex = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            val diff = target - nums[i]
            val inIndex = valueToIndex[diff]

            if (inIndex == null) {
                valueToIndex[nums[i]] = i
                continue
            }

            return intArrayOf(inIndex, i)
        }

        return intArrayOf(0, 0)
    }
}
