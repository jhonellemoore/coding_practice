# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
soln:

start with prev = null

when you're at a node, you want to store its next node
Then you want to move the node's next pointer to prev
then hyou want to store this curr node as prev
then you want to move on to next


"""
class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        prev = None
        while head:
            next_node = head.next
            head.next = prev
            prev = head
            head = next_node
        return prev
