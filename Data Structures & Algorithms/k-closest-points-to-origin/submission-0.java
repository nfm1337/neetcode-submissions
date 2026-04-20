class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> {
            double dist1 = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double dist2 = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return Double.compare(dist2, dist1);
        });


        for (int[] point : points) {
            q.add(point);
            if (q.size() > k) {
                q.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll();
        }

        return ans;
    }
}
