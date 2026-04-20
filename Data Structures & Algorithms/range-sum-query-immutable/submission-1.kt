class NumArray(nums: IntArray) {

    val prefixSum = IntArray(nums.size)

    init {
        var total = 0
        nums.forEachIndexed { i, num ->
            total += num
            prefixSum[i] = total
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        val rightSum = prefixSum[right]
        val leftSum = if (left > 0) prefixSum[left - 1] else 0
        return rightSum - leftSum
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */