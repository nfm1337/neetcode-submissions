class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        int l = 0;
        int r = str.length - 1;

        while (l < r) {
            if (str[l] != str[r]) {
                return false;
            }

            l++;
            r--;
        }
        return true;
    }
}
