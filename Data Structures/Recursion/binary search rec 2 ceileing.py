
# Question find ceilieng no for given no
# arr = [5,6,,8,12,14,15,24,18,26,34]


# Hint: use binary search
# Ceiling is no >= given no
def printarr(arr: list[int], s: int, e: int):
    print('see',e-s )
    for i in range(e-s+1):
        print( arr[s+i],i,' ',end=' ' )
    print()
    

def findCeiling(arr: list[int], t: int, s: int, e: int):
    print((e-s)//2)
    m = s + (e-s+1)//2
    print('middle',m, s, e)
    printarr(arr,s,e )
    if(arr[m] == t):
        return t
    if(e <=s+1):
        if(arr[s>= t]):
            print('final',arr[s])
            return arr[s]
           
        
        print('final',arr[e])
        return arr[e]
    if(arr[m] > t):
        # In left arraye
        findCeiling(arr, t,s, m)
    else:
         # In right arraye
        findCeiling(arr, t,m+1, e )

    
# 24, 26, 34
ar2 =[2,3,5,9,14,16,18]
arr = [5, 6, 8, 12, 14, 15, 18 ]
# print(findCeiling(ar2, 11, 0, len(arr)-1), 'ans')
ans = findCeiling(ar2, 10, 0, len(arr)-1)
print('ans', ans)