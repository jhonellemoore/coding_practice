class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if len(s) != len(t):
            return False
        
        anagrams_dict = dict()
        t_dict = dict()
        for i, ele in enumerate(s):
            anagrams_dict[ele] = anagrams_dict.get(ele, 0) + 1
            t_dict[t[i]] = t_dict.get(t[i], 0) + 1
        return anagrams_dict == t_dict
