# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        # switch node with next node
        curr = node
        next_node = curr.next
        next_next = next_node.next

        curr.val = next_node.val
        curr.next = next_next
        return
