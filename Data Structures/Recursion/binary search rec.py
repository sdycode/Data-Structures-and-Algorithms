

def findTargedwithBinarySeacrch(l, t, s, e):
    
    if(e< s):
        return -1
    m = s +(e-s)/2
    

    if(l[m] == t):
        return l[m]
    if(l[m] > t):
        # search in left array
        findTargedwithBinarySeacrch(l, t, s, m-1)
    if(l[m]< t):
        findTargedwithBinarySeacrch(l, t, m+1, e)
    


    


l = [2,5,6,8,12,25,66,45]

findTargedwithBinarySeacrch(l, 6, 0, len(l)-1)
