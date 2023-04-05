package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class InverTrees {
    /**
     * 迭代法可以用前序遍历、后序遍历和层序遍历，就是不能中序遍历，会产生重复反转
     * 反转每一棵二叉子树，可以用层序遍历，逐层逐个遍历并反转其子树
     * 时间空间复杂度都是:O(N)
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        int size = 0;
        TreeNode cur = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            size = queue.size();
            List<Integer> line = new ArrayList<>();
            for(int i = 0; i < size; i++){
                cur = queue.peek();
                queue.poll();
                line.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                TreeNode temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
            }
        }
        return root;
    }

    /**
     * 递归做法
     * 代码明显简洁，并且空间复杂度为O(H)，H为树高度，存H个函数调用占空间，时间复杂度为O(N)，每个节点都访问一遍
     * 对比迭代法：
     * 1.从时间复杂度上其实迭代法和递归法差不多（在不考虑函数调用开销和函数调用产生的堆栈开销）
     * 2.空间复杂度上，递归开销会大一些，因为递归需要系统堆栈存参数返回值等等
     * 总结：在实际项目开发的过程中我们是要尽量避免递归！因为项目代码参数、调用关系都比较复杂，不容易控制递归深度，甚至会栈溢出
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        oder(root);
        return root;
    }
    public void oder(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        oder(root.left);
        oder(root.right);
    }
}
