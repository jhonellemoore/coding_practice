class Solution(object):
    def intervalIntersection(self, firstList, secondList):
        """
        :type firstList: List[List[int]]
        :type secondList: List[List[int]]
        :rtype: List[List[int]]
        """
        # merged interval = [maximum left, minimuim right]
        # increment the one with the bigger right that wasn't in the interval

        """
        |a    |b
            |c   |d
        a must be less than d and b must be greater than c for them to be overlapping
        """
        def mergeLists(list1, list2):
            return [max(list1[0], list2[0]), min(list1[1], list2[1])]
        
        def overlapping(list1, list2):
            return list1[0] <= list2[1] and list1[1] >= list2[0]
            
        index_first = 0
        index_second = 0
        res = []
        while index_first < len(firstList) and index_second < len(secondList):
            first = firstList[index_first]
            second = secondList[index_second]
            is_overlapping = overlapping(first, second)
            if is_overlapping:
                result = mergeLists(first, second)
                res.append(result)
            if first[1] < second[1]:
                index_first +=1
            else:
                index_second+=1
        return res
