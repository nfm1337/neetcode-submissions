class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        
        hash_one = {}
        hash_two = {}

        for i in range(len(s)):
            hash_one[s[i]] = hash_one.get(s[i], 0) + 1
            hash_two[t[i]] = hash_two.get(t[i], 0) + 1

        return hash_one == hash_two