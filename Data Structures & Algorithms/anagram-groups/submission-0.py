class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        counts = {}

        for s in strs:
            count_arr = [0] * 26
            for ch in s:
                count_arr[ord(ch) - ord('a')] += 1
            key = tuple(count_arr)
            if key in counts:
                counts[key].append(s)
            else:
                counts[key] = [s]

        return list(counts.values())
            
        
