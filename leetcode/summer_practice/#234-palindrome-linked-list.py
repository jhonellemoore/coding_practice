# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

""""
Algorithm:
- Move the fast and slow pointers until the slow pointer gets to the middle
- When the slow pointer gets to the middle, call the reverse function
    - reverse function reverses from middle to end

"""
class Solution(object):
    def isPalindrome(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        def reverseList(middle):
            prev = None
            curr = middle
            while curr is not None:
                next_node = curr.next
                curr.next = prev
                prev = curr
                curr = next_node   
            return prev

        # Goal = we want the slow pointer to end up in the middle of the list
        slow = head
        fast = head
        if head is None:
            return True
        while fast.next != None and fast.next.next != None :
            fast = fast.next.next
            slow = slow.next

        # reverse from middle to end
        new_end = reverseList(slow)
        while head is not None:
            if head.val != new_end.val:
                return False
            head = head.next
            new_end = new_end.next
        
        return True
