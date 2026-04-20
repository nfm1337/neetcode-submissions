import re

class Solution:

    def encode(self, strs: List[str]) -> str:
        return "".join(f"{len(s)}#{s}" for s in strs)

    def decode(self, s: str) -> List[str]:
        pattern = re.compile(r'(\d+)#')
        i = 0
        res = []
        while i < len(s):
            j = s.find('#', i)
            length = int(s[i:j])
            word = s[j+1 : j+1+length]
            res.append(word)
            i = j + 1 + length
        return res