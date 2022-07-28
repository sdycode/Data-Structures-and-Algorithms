

class TreeNode:
    def __init__(self, data):
        self.data = data
        self.children =[]
        self.parent =None

    def add_child(self, child):
        child.parent = self
        self.children.append(child)
    
    def print_tree(self):
        spaces = self.get_level() *" "*3
       
        print(spaces,self.data)
        for child in self.children:

            child.print_tree()
    
    def get_level(self):
        level =0
        p = self.parent
        while p:
            level += 1
            p = p.parent
        return level
def build_tree():
    tr = TreeNode('parentnode')
    ch1 = TreeNode('child1')
    ch2 = TreeNode('child2')
    ch3 = TreeNode('child3')
    ch4 = TreeNode('child4')
    gr11= TreeNode('grand11')
    gr12= TreeNode('grand12')
    gr22= TreeNode('grand22')
    gr34= TreeNode('grand34')
    ch1.add_child(gr11)
    ch1.add_child(gr12)
    ch2.add_child(gr22)
    ch3.add_child(gr34)
    tr.add_child(ch1)
    tr.add_child(ch2)
    tr.add_child(ch3)
    tr.add_child(ch4)
    tr.print_tree()

    return tr





if __name__ =='__main__':
    root =build_tree()
    pass



        
