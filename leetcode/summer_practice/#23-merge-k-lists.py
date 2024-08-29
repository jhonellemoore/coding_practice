# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
import heapq
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        """
        list = [[1 -> 2 -> 3], [1 -> 2 -> 4], [3 -> 4 -> 5]]
        heap = 1, 1, 3 
        """
        heap = [(l.val, index) for index, l in enumerate(lists) if l]
        heapq.heapify(heap)
        temp_head = ListNode(0)
        curr = temp_head
        while heap:
            # Add the smallest node from the heap to the result list
            val, idx = heapq.heappop(heap)
            next_node = lists[idx]
            curr.next = next_node
            curr = curr.next

            # Move to the next node in the list from which the value was taken
            next_node = next_node.next
            lists[idx] = next_node

            # If there are more nodes in this list, push the next node onto the heap
            if next_node:
                heapq.heappush(heap, (next_node.val, idx))
            # curr = curr.next
        return temp_head.next
