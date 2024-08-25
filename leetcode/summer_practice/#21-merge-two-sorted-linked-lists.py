# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
index at bpth lists
compare both indices
create a node and put the smaller value in that node in lsit
increment the smaller index

"""
class Solution(object):
    def mergeTwoLists(self, list1, list2):
        """
        :type list1: Optional[ListNode]
        :type list2: Optional[ListNode]
        :rtype: Optional[ListNode]
        """
        if not list1:
            return list2
        if not list2:
            return list1
        temp_head = ListNode(0, None)
        curr = temp_head
        while list1 and list2:
            if list1.val <= list2.val:
                curr.next = ListNode(list1.val, None)
                list1 = list1.next
                curr = curr.next
            else:
                curr.next = ListNode(list2.val, None)
                list2 = list2.next
                curr = curr.next
        if list2:
            curr.next = list2
        else:
            curr.next = list1
        return temp_head.next
