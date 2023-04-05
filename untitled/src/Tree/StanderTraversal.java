package Tree;

import java.util.*;

public class StanderTraversal {
    /**
     * 前序遍历：
     * 1.自顶向下，递归思想，迭代实现
     * 2.先右子树，后左子树，最后顶点
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp;
        if(root != null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp != null){
                if(temp.right != null){
                    stack.add(temp.right);
                }
                if(temp.left != null){
                    stack.add(temp.left);
                }
                stack.add(temp);
                stack.add(null);
            }else{
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    /**
     * 中序遍历：
     * 1.自顶向下，向栈中按右子树、父树、左子树节点存储
     * 2.根据递归，每个子树还能替换成对应的1中的结构，所以原子树节点弹出，按上述顺序压栈子子树
     * 3.每次当节点的元素都是重复访问两次的，可以在压入此节点后再压入个null做标记，表示重复访问过的元素可以直接出栈，不用再深入遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode next = root, temp = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp != null){
                if(temp.right != null){
                    stack.push(temp.right);
                }
                stack.push(temp);
                stack.push(null);
                if(temp.left != null){
                    stack.push(temp.left);
                }
            }else{
                list.add(stack.pop().val);
            }
        }
        return list;
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Queue<Integer> l = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, temp = null;
        if(root == null){
            return list;
        }
        stack.push(cur);
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp != null){
                stack.add(temp);
                stack.add(null);
                if(temp.right != null){
                    stack.add(temp.right);
                }
                if(temp.left != null){
                    stack.add(temp.left);
                }
            }else{
                list.add(stack.pop().val);
            }
        }
        return list;
    }
}
