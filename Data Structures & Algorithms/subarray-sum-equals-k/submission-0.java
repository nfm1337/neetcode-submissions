class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            count += prefix.getOrDefault(prefixSum - k, 0);
            prefix.put(prefixSum, prefix.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}