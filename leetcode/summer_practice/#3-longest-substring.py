"""
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
"""

class Solution(object):
    """
    iterate through every character,
    if character hasn't repeated:
        find curr length
        compare it to max length 
    if it has repeated:
        decrement left pointer until the repetition is done
    """
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        l, r = 0, 0
        seen = set()
        max_length = -float('inf')
        if len(s) == 0:
            return 0
        while r < len(s):
            curr_char = s[r]
            if curr_char in seen:
                # decrease left until curr char not in seen
                while curr_char in seen:
                    # remove left character from set
                    seen.remove(s[l])
                    # increment left
                    l+=1
            else:
                length = r - l + 1
                max_length = max(length, max_length)
            r += 1
            seen.add(curr_char)
        return max_length
