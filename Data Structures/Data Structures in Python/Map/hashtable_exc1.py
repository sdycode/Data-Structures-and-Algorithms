


from hashtable_collision import HashTable

def get_avg(first=1, last=7):
    diff = last-first
    sum =0
    for i in range(diff):
        sum +=int( t[str(diff+i)])
    return sum/diff


    pass

t = HashTable()
with open('Map/nyc_weather.csv', 'r+') as f:
    for i,line in enumerate(f):
        if i >0 :
            # print(line.split(',')[0].split(' ')[0])
            t[str(line.split(',')[0].split(' ')[1])] = str(line.split(',')[1]).strip()
    print(t.arr)
print(get_avg(first=1, last=4))




       