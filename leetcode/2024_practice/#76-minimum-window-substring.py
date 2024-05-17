class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        # expand window until all letters in word found
        # when all letters found, contract window until smallest
        # repeat
        dict_t = dict()
        dict_s = dict()
        min_so_far = float('inf')
        min_string = ""
        r = 0
        l = 0
        for char in t:
            dict_t[char] = dict_t.get(char, 0) + 1
        
        while r < len(s):
            curr = s[r]
            if curr in dict_t:
                dict_s[curr] = dict_s.get(curr, 0) + 1


            while all(dict_s.get(char, 0) >= count for char, count in dict_t.items()):
                if r - l + 1 < min_so_far:
                    min_so_far = r - l + 1
                    min_string = s[l:r + 1]
                # shrink left of the window while you still can
                if s[l] in dict_s:
                    dict_s[s[l]] = dict_s[s[l]] - 1
                l+= 1
            r+= 1
        
        if dict_t == dict_s:
            min_so_far = min(min_so_far, r - l + 1)
        return min_string
