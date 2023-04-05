package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeftLeavesSum {
    /**
     * 递归法：求整棵树的左叶子节点和，就等于讨论当前节点的左子树和右子树左节点之和，只是有好几个边界要考虑，null和是否是叶子节点，还有右子树的单独处理
     * 1.当前节点的左节点是不是空，非空再看是否是叶子节点，不是就递归；右边看是否为空，非空就直接递归
     * 时空复杂度均为O(N)，只遍历一次节点，并且最差空间复杂度是链式结构的情况
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        int total = 0;
        if(root == null){
            return 0;
        }
        return getSum(root,total);

    }
    public int getSum(TreeNode root, int total){
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                total += root.left.val;
            }else{
                total = getSum(root.left,total);
            }
        }
        if(root.right != null){
            total = getSum(root.right,total);
        }
        return total;
    }

    /**
     * 层序遍历嘛，用队列存储，每次存储一行，没顶出一个就考察他的左右节点：
     * 判断左节点是否为空、不为空的话是否是叶子节点，不是叶子节点就放进队列里递归；右节点直接放进队列里递归
     * 时空复杂度都是O(N)
     * @param root
     * @return
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if(root == null){
            return 0;
        }
        int total = 0;
        boolean leftEmpty = false;
        Queue<TreeNode> treeQueue = new ArrayDeque<>();
        treeQueue.offer(root);
        while(!treeQueue.isEmpty()){
            TreeNode top = treeQueue.poll();
            leftEmpty = top.left == null;
            if(!leftEmpty){
                if(top.left.left == null && top.left.right == null){
                    total += top.left.val;
                }else{
                    treeQueue.offer(top.left);
                }
            }
            if(top.right != null){
                treeQueue.offer(top.right);
            }
        }
        return total;
    }
}
