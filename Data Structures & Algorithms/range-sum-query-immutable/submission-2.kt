class NumArray(nums: IntArray) {

    val prefixSum = IntArray(nums.size + 1)

    init {
        nums.forEachIndexed { i, num ->
            prefixSum[i + 1] = prefixSum[i] + num
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        return prefixSum[right + 1] - prefixSum[left]
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */