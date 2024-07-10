# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def pairSum(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: int
        """
        fast = slow = head
        max_sum = float('-inf')
        def reverseList(curr):
            prev = None
            while curr is not None:
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node
            return prev

        while fast.next is not None and fast.next.next is not None:
            fast = fast.next.next
            slow = slow.next
        right_head = reverseList(slow)
        while right_head and head is not None:
            curr_sum = right_head.val + head.val
            max_sum = max(curr_sum, max_sum)
            right_head, head = right_head.next, head.next
        return max_sum
