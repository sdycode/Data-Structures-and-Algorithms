package Trees.Basics;

import java.util.Stack;

public class ShowStack {
    public  static  void showStack(Stack<TreeNode> stack){
        Stack<TreeNode>  t =(Stack<TreeNode>)   stack.clone();
        while (!t.isEmpty()){
            System.out.print(t.pop().value+" ");
        }
    }
}
