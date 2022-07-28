
# Implement Stack class using a deque

from collections import deque


class Stack:
    def __init__(self):
        self.container = deque()
    
    def push(self,val):
        self.container.append(val)
        
    def pop(self):
        if(len(self.container)>0):

            return self.container.pop()
    
    def peek(self):
        return  self.container[-1]
    
    def is_empty(self):
        return len(self.container)==0
    
    def size(self):
        return len(self.container)


# Exrecise 1
# reverse_string("We will conquere COVID-19") should return "91-DIVOC ereuqnoc lliw eW"

def reverse_string(string):
    stack = Stack()
    for s in string:
        stack.push(s)
    print(stack.peek())
    rev_ans =''
    while stack.size():
        rev_ans += stack.pop()
    return rev_ans


print(reverse_string("We will conquere COVID-19"))


