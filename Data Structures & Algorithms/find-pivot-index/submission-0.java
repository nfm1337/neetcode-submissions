class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            prefix[i] += prefix[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            int leftSum = prefix[i];
            int rightSum = prefix[nums.length] - prefix[i + 1];
            if (leftSum == rightSum) {
                return i;
            }
        }

        return -1;
    }
}