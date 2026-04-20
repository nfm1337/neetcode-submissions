class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val arr = IntArray(26)

        for ((cs, ct) in s.zip(t)) {
            arr[cs - 'a']++
            arr[ct - 'a']--
        }

        return arr.all { it == 0 }
    }
}
