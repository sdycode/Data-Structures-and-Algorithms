

import re


class TreeNode:
    def __init__(self, name,desgn ):
        self.name = name
        self.desgn = desgn
        self.children =[]
        self.parent =None
        
    def add_child(self, child):
        child.parent = self
        self.children.append(child)
    
    def print_tree(self, treetype):
        datatoprint =''
        match treetype:
            case 'name':
                datatoprint = self.name
            case 'desgn':
                datatoprint = self.desgn
            case 'both':
                datatoprint = self.name+ " ("+self.desgn+")"
            case default:
                datatoprint = self.name


        
        spaces = self.get_level() *" "*3
        print(spaces,datatoprint)
        for child in self.children:
            child.print_tree(treetype)
    
    def get_level(self):
        level =0
        p = self.parent
        while p:
            level += 1
            p = p.parent
        return level
        


def build_tree():
    tr = TreeNode('parentnode', 'CEO')
    ch1 = TreeNode('child1','Head1')
    ch2 = TreeNode('child2','Head2')
    ch3 = TreeNode('child3','Head3')
    ch4 = TreeNode('child4','Head4')
    gr11= TreeNode('grand11','Manager11')
    gr12= TreeNode('grand12','Manager12')
    gr22= TreeNode('grand22','Manager22')
    gr34= TreeNode('grand34','Manager34')
    ch1.add_child(gr11)
    ch1.add_child(gr12)
    ch2.add_child(gr22)
    ch3.add_child(gr34)
    tr.add_child(ch1)
    tr.add_child(ch2)
    tr.add_child(ch3)
    tr.add_child(ch4)
    return tr



if __name__=='__main__':
    root = build_tree()
    root.print_tree('both')
    root.print_tree('name')
    root.print_tree('desgn')
    
