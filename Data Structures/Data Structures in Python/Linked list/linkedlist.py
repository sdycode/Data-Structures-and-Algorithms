



class Node:
    def __init__(self, data=None, next=None):
        self.data= data
        self.next=next

class LinkedList:
    def __init__(self) :
        self.head=None
    def insert_at_beg(self, data):
        node =Node(data, self.head)
        self.head = node

    def insert_at_end(self, data):
        if self.head == None:
            self.head= Node(data, None)
            return
        itr = self.head
        while itr:
            itr = itr.next
        itr.next = Node(data, None)
        

    def print(self):
        if self.head == None:
            print('Linked list in Empty')
            return
        itr = self.head
        lstr =''
        while itr:
            lstr += str(itr.data)+'-->'
            itr = itr.next
        print(lstr)




if __name__=='__main__':
    ll =LinkedList()
    ll.insert_at_beg(50)
    ll.print()





