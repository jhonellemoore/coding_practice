import heapq

class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        ele_dict = dict()
        res = []
        heap = []
        heapq.heapify(heap)
        for ele in nums:
            ele_dict[ele] = ele_dict.get(ele, 0) - 1
        
        for key, value in ele_dict.items():
            heapq.heappush(heap, (value, key))
        print(heap)
        for i in range(k):
            val, key = heapq.heappop(heap)
            print(key)
            res.append(key)
        return res
