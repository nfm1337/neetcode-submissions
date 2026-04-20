class Solution {
    public int characterReplacement(String s, int k) {
        int L = 0, length = 0, maxf = 0;
        int[] counts = new int[26];

        for (int R = 0; R < s.length(); R++) {
            counts[s.charAt(R) - 'A']++;
            maxf = Math.max(maxf, counts[s.charAt(R) - 'A']);

            while((R - L + 1) - maxf > k) {
                counts[s.charAt(L) - 'A']--;
                L++;
            }
            length = Math.max(length, R - L + 1);
        }

        return length;
    }
}
