class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals.sort()
        merged_intervals = []
        if len(intervals) == 0:
            return []
        merged_intervals.append(intervals[0])
        for interval in intervals:
            prev = merged_intervals[-1]
            if interval[0] <= prev[1]:
                # replace that interval with this new end
                prev[1] = max(interval[1], prev[1])
                prev[0] = min(interval[0], prev[0])
            else:
                merged_intervals.append(interval)
        return merged_intervals
