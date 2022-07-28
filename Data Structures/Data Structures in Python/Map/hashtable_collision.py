# Collision is avoided using chaning



class HashTable:
    def __init__(self):
        self.MAX = 10
        self.arr = [[] for i in range(self.MAX)]

    def get_hash(self, char):
        hash = 0
        for i in char:
            hash += ord(i)
        return hash % self.MAX

    def print_arr(self):
        print(self.arr)

    def print_nth_element(self, n):
        print(self.arr[n % len(self.arr)])

    def __getitem__(self, key):
        h = self.get_hash(key)
        for kv in self.arr[h]:
            if kv[0]== key:
                return kv[1]



    def __setitem__(self, key, value):
        h = self.get_hash(key)
        found = False
        for i,kv in enumerate(self.arr[h]):
            if kv[0]== key:
                self.arr[h][i] = (key, value)
                found = True
        if not found:
            self.arr[h].append((key, value))
    

    def __delitem__(self, key):
        h = self.get_hash(key)
        for i, kv in enumerate(self.arr[h]):
            if kv[0] == key:
                del self.arr[h][i]

     


if __name__ == '__main__':
    t = HashTable()

    t.print_nth_element(10)
    t.get_hash('shub')
    t['shu'] = 50
    t['may'] = 150
    t['kun'] = 120
    # t.print_arr()
    # x = t['may']
    # print(x, t['kun'])
    t["march 6"] = 310
    t["march 7"] = 420
    t["march 8"] = 67
    t["march 17"] = 63457
    t.print_arr()
    del t["march 7"]
    t.print_arr()
    del t["march 6"]
    t.print_arr()
