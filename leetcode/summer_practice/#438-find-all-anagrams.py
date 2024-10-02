"""
s = "cbaebabacd", p = "abc"
fr i in len(p):
    add i to hashmap with number of occurence
for every char in s until len(s) - 3:
    check if first (lenp) elements resemble p (using a hashmap)
    if yes:
        add index to list
    increment l and r pointers
"""


class Solution(object):
    def findAnagrams(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: List[int]
        """
        size_anagram = len(p)
        anagram_dict = dict()
        curr_dict = dict()
        res = []
        l, r = 0, len(p) - 1
        if len(s) < len(p):
            return []
        for i, ele in enumerate(p):
            # add to hashmap
            anagram_dict[ele] = anagram_dict.get(ele, 0) + 1
            if i != len(p) - 1:
                curr_dict[s[i]] = curr_dict.get(s[i], 0) + 1

        # dict1 = {a:1 b:1 c:1}, dict2 = {c:1, b:1}
        while r < len(s):
            char_l = s[l]
            char_r = s[r]
            curr_dict[char_r] = curr_dict.get(char_r, 0) + 1

            # check if equal
            if curr_dict == anagram_dict:
                res.append(l)
            
            r+=1 
            curr_dict[char_l]-=1
            if curr_dict[char_l] == 0:
                del curr_dict[char_l]
            l+= 1

        return res

        """
        for every char in s until len(s) - 3:
    check if first (lenp) elements resemble p (using a hashmap)
    if yes:
        add index to list
    increment l and r pointers"""
