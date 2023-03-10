

# from collections import deque


# def fibAt( n):
#     if n < 2:
#         return n
#     else:
#         return fibAt(n-1) + fibAt(n-2)
    
# stack =deque
# def fibUpTo(n, a , b):
#     if(n > 0):
#         fibUpTo(n-1, b, a+b)
#         stack.append(a)
#         # print(a, end=" ")
    
#     while stack.qsize() != 0:
#         print(stack.get()) 
#         stack.pop()


    
   


# # print(fibAt(6))
# fibUpTo(10, 0,1)

# stack = stack.reverse
# print(stack)

from collections import deque  
  
my_stack = deque()  
  
# # append() function is used to push   
# # element in the my_stack   
# my_stack.append('a')  
# my_stack.append('b')  
# my_stack.append('c')  
  
# print('Initial my_stack:')  
# print(my_stack)  
  
# # pop() function is used to pop   
# # element from my_stack in    
# # LIFO order   
# print('\nElements poped from my_stack:')  
# print(my_stack.pop())  
# print(my_stack.pop())  
# print(my_stack.pop())  
  
# print('\nmy_stack after elements are poped:')  
# print(my_stack)   


def fibUpTo(n, a , b):
    if(n > 0):
        print(a, end=" ")
        fibUpTo(n-1, b, a+b)

def fibUpToReverse(n, a , b):
    if(n > 0):
       
        fibUpTo(n-1, a, a+b)    
        print(a, end=" ")
    
    
        # my_stack.pop()

fibUpTo(10,0,1)
print()
fibUpToReverse(10,0,1)