import heapq
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        """elements in the sequence with relation to n"""
        """
        ALGORITHM
        #1 Pop from the priority queue and add it to our queue if that wasn't the last occurence of that ele
        #2 Check if the latest element in the queue has a time that's equal to our current time
            If yes:
                Decrease its number and put back into the priority queue
        
        """
        def create_heap(tasks):
            task_counts = Counter(tasks)
            # Create a max heap (negate the counts for max heap behavior)
            max_heap = [-count for count in task_counts.values()]
            heapq.heapify(max_heap)
            print(max_heap)
            return max_heap
        
        pq = create_heap(tasks)
        queue = deque()
        t = 0
        while pq or queue:
            t+=1
            if pq:
                count = heapq.heappop(pq)
                if count < -1:
                    queue.append((count + 1, t + n))
            
            if queue and queue[0][1] == t:
                task_count, _ = queue.popleft()
                heapq.heappush(pq, task_count)
        return t
