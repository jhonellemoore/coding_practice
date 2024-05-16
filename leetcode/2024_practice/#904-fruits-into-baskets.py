class Solution(object):
    """
[0, 1, 0, 2]
iteration1 
l = 0, r = 0
map = 0, 0

iteration2
l = 0, r = 1
map = 0, 0
map = 1, 1

iteration3
l = 0, r = 2
map = 0, 2
map = 1, 1

iteration4
l = 2, r = 3
map = 0, 2
maxsofar = 3

Each tree produces a kind of fruit and each index is a type of tree
Find a max subarray that contains two types of numbers 
sliding window

    keep two digits in a hashmap. key = digit, value = max index
    l = 0
    maxsofar = python minimum
    for r in range(0, len(fruits)):
        if ele at fruits[r] not in hashmap and hashmap.size == 2:
            maxsofar = max(maxsofar, r - l + 1)
            l = 1 + min val in hashmap
            hashmap.remove(min key-val in hashmap)
        else:
            # area of optimization
            hashmap.put(fruits[r], r)
    
    maxsofar = max(maxsofar, r - l + 1)
    """
    # min = -sys.maxsize - 1
    import sys
    def totalFruit(self, fruits):
        """
        :type fruits: List[int]
        :rtype: int
        """
        l = 0
        hash_map = dict()
        max_so_far = -1
        for r in range(0, len(fruits)): #o(n)
            if fruits[r] not in hash_map and len(hash_map) == 2:
                max_so_far = max(max_so_far, r - l)
                min_key = min(hash_map, key=hash_map.get)
                l = hash_map[min_key] + 1
                hash_map.pop(min_key)
            hash_map[fruits[r]] = r
        max_so_far = max(max_so_far, r - l + 1)
        return max_so_far

        # time compl = o(n)
        # space compl = o(n)
