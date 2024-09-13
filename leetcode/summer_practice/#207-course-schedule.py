class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool

        to take course 1, we need course 0. to take course 0, we need course 1 [1, 0] [0, 1]
        [2, 4] [4, 2]
        [3, 4] [4, 5] [5, 7]
        prereqs = [[2d arrat]]
        """
        def build_dict(prereqs, num_courses):
            adj_list = {i:[] for i in range(num_courses)}
            prereqs.sort()
            for index, prereq in enumerate(prereqs):
                ele = prereq[0]
                neighbor = prereq[1]
                if ele in adj_list:
                    adj_list[ele].append(neighbor)
                else:
                    adj_list[ele] = [neighbor]
                if neighbor not in adj_list:
                    adj_list[neighbor] = []
            return adj_list

        # This method checks if any of the current element's children contains a cycle. If no, it makes the list for the element empty. If yes, it returns True
        # Things to note. We have a seen set that we add the current element to in each dfs as it traverses the stack trace. We remove it from seen when we're done.
                        # We also want to make the adjacency list for the current element empty if it doesn't contain a cycle. This is sort of a signal that there's not cycle-- our base case.
        def contains_cycle(ele, adj_list, seen):
            if not adj_list:
                return False
            if not adj_list[ele]:
                return False
            if ele in seen:
                return True

            # add to seen for children.
            seen.add(ele)
            for next_ele in adj_list[ele]:
                if contains_cycle(next_ele, adj_list, seen):
                    return True
            adj_list[ele] = [] # update it to the base case
            # remove from seen after processing children
            seen.remove(ele)
            return False

        if not prerequisites:
            return True

        adj_list = build_dict(prerequisites, numCourses)
        print(adj_list)
        seen = set()
        num_courses = 0
        # count how many elements don't contain a cycle
        for ele in adj_list:
            if not contains_cycle(ele, adj_list, seen):
                num_courses += 1
            if num_courses == numCourses:
                return True
        print(num_courses)
        return num_courses >= numCourses
