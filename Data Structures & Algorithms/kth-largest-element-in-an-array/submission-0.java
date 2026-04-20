class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            q.add(num);
        }
        for (int i = 0; i < k - 1; i++) {
            q.poll();
        }

        return q.poll();
    }
}
