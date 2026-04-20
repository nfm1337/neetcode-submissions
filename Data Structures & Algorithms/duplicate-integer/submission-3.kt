class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        return nums.toHashSet().size != nums.size
    }
}
