

# Simple hash table without collision

class HashTable:
    def __init__(self):
        self.MAX =100
        self.arr =[ [ ] for i in range(self.MAX)]

    
    def get_hash(self, char):
        hash =0
        for i in char:
            hash += ord(i)
        return hash %self.MAX
    def print_arr(self):
        print(self.arr)
    
    def print_nth_element(self, n):
        print(self.arr[n%len(self.arr)])

    def __getitem__(self, key):
        h = self.get_hash(key)
        print(self.arr[h])
        return self.arr[h]
    
    def __setitem__(self, key, value):
        h = self.get_hash(key)
        self.arr[h] = value




if __name__=='__main__':
    t = HashTable()
  
    t.print_nth_element(10)
    t.get_hash('shub')
    t['shu'] =50
    t['may']=150
    t['kun']=120
    # t.print_arr()
    x = t['may']
    print(x, t['kun'])

    
