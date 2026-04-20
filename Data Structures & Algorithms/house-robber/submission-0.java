class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0, new HashMap<>());
    }

    private int dfs(int[] nums, int i, Map<Integer, Integer> cache) {
        if (i < 0 || i >= nums.length) {
            return 0;
        }

        if (cache.get(i) != null) {
            return cache.get(i);
        }

        cache.put(i, Math.max(nums[i] + dfs(nums, i + 2, cache), dfs(nums, i + 1, cache)));

        return cache.get(i);
    }
}
