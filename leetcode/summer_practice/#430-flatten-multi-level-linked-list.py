"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child
"""

"""
function takes in the head of a list
traverse through each node in the list
if you encounter a child node:
    store the next node of the current node
    traverse through each node in that list, adding it to the linked list
    continue at the next node
recursive function

"""

class Solution(object):
    def flatten(self, head):
        # returns last node of child list and flatten's child's list
        def flatten_list(head): # head is the head of the list
            # go through each node. if node has a child, flatten child
            curr = head
            while curr:
                # flatten this child
                # change parent's next node to child
                # change child's last node.next node to parent's next node
                next_node = curr.next
                if curr.child:
                    child = curr.child # store
                    child_last = flatten_list(child)
                    curr.next = child
                    child.prev = curr
                    curr.child = None
                    child_last.next = next_node
                    if next_node:
                        next_node.prev = child_last
                    last_node = child_last # added
                else:
                    last_node = curr
                curr = next_node
            return last_node
        
        if not head:
            return head
        flatten_list(head)
        return head


"""" alternative soln """"

class Solution2(object):
    def flatten(self, head):
        # returns last node of child list and merges parent to child
        def merge_parent_child(parent):
            child = parent.child

            while child.next:
                child = child.next

            next_node = parent.next
            if next_node:
                child.next = next_node
                next_node.prev = child

            parent.next = parent.child
            parent.child.prev = parent
            parent.child = None
        
        current = head
        
        while current is not None:
            # check for child node
            if current.child is not None:
                # merge child list into the parent list
                merge_parent_child(current)
                
            # move to the next node
            current = current.next
        
        return head
