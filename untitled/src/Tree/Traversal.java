package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class Traversal {
    /**
     * 前序遍历：
     * 1.先访问到的就是先加入结果的，所以可以采取先压栈头结点，再弹栈头结点，再逆向压入子树节点的做法
     * 2.弹栈的时候就是加入结果集的时候
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
            list.add(temp.val);
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历：
     * 1.自底向上
     * 2.找到最左子树的最后一个左节点，加入结果集；将其父结点加入结果集；然后再递归其右子树，循环前面的过程，这种情况最适合用单次复合条件的while循环，配合if讨论
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
        while(next != null || !stack.isEmpty()){
            if(next != null){
                stack.push(next);
                next = next.left;
            }else{
                next = stack.pop();
                list.add(next.val);
                next = next.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历：
     * 1.前序遍历的过程相似，只是压栈的时候是先左子树压，再右子树，最后的到的结果还要用Collections.reverse()
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, top = null;
        if(root == null){
            return list;
        }
        stack.push(cur);
        while(!stack.isEmpty()){
            cur = stack.pop();
            list.add(cur.val);
            if(cur.left != null){
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        Collections.reverse(list);
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
