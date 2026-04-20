class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0, length = 0;
        Set<Character> set = new HashSet<>();

        for (int R = 0; R < s.length(); R++) {
            while (set.contains(s.charAt(R))) {
                set.remove(s.charAt(L));
                L++;
                
            }
            set.add(s.charAt(R));
            length = Math.max(length, R - L + 1);
        }

        return length;
    }
}
