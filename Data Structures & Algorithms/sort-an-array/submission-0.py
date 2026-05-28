class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        return self.sort(nums, 0, len(nums) - 1)

    def sort(self, arr: List[int], s: int, e: int) -> List[int]:
        if e - s + 1 <= 1:
            return arr
        
        m = (e + s) // 2
        self.sort(arr, s, m)
        self.sort(arr, m + 1, e)
        self.merge(arr, s, m, e)
        
        return arr
    
    def merge(self, arr: list[int], s: int, m: int, e: int):
        L = arr[s: m + 1]
        R = arr[m + 1: e + 1]
        i, j, k = 0, 0, s

        while i < len(L) and j < len(R):
            if L[i] <= R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1 
