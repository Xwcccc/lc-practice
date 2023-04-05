package Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class FindDepth {

    /**
     * 深度递归：求全局最长，可以递归求左右子树深度再比较；边界条件是读到了空节点
     * 时间复杂度O(N)——遍历了所有节点，空间复杂度O(H)——递归用栈实现的，深度遍历就是走遍整个树的高度
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        return getDepth(root);
    }
    public int getDepth(TreeNode root){
        int max = 0;
        if(root == null){
            return max;
        }
        if(root.left == null && root.right == null){
            return max+1;
        }
        max += 1;
        int max1 = getDepth(root.left);
        int max2 = getDepth(root.right);
        max = max1 >= max2 ? max1+max : max2+max;
        return max;
    }

    /**
     * 更简练递归写法
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth2(root.left);
            int rightHeight = maxDepth2(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 广度遍历，用队列先进先出的原理，每次只存一层的数据
     * 时空复杂度都是O(N)
     * @param root
     * @return
     */
    public int maxDepth3(TreeNode root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode top = queue.poll();
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    queue.offer(top.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
