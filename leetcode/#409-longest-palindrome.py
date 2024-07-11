class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        # all even occurences
        # even and one odd occurence

        carry = 0
        res_dict = dict()
        final_nums = 0
        for key, val in enumerate(s):
            res_dict[val] = res_dict.get(val, 0) + 1
        for key in res_dict:
            if res_dict[key]%2 == 0:
                final_nums += res_dict[key]
            else:
                final_nums += res_dict[key] - 1
                carry = 1

        final_nums += carry
        return final_nums
