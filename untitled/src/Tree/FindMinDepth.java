package Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindMinDepth {
    /**
     * 深度递归
     * 时间复杂度O(N)，空间复杂度O(H)
     * 找最近的叶子节点的深度，可以通过左右子树较小深度+1获得，此时比较取min，所以初始值不能再设为0，要设为最大值
     * 注意只有左右子树都为空时父结点才是叶子节点，不然还得递归，所以搜索终点是左右子树均为空
     * 求最大深度比较的时候，由于取深度大的子树，所以另一子树为null自然被舍弃，符合查找叶子节点的过程；但
     * 是求最小深度的时候取的是深度更小的，此处与查找叶子节点舍弃空子树违背
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if(root.left == null && root.right == null){
            return 1;
        }else {
            int leftHeight = Integer.MAX_VALUE;
            int rightHeight = Integer.MAX_VALUE;
            if(root.left != null){
                leftHeight = minDepth(root.left);
            }
            if(root.right != null){
                rightHeight = minDepth(root.right);
            }
            return Math.min(leftHeight, rightHeight) + 1;
        }
    }

    /**
     * 广度遍历
     * 广度遍历的思路就更简单了，每次队列中只存着一层的元素，当驱除上层时检测叶子节点即可（无左右子树）
     * 时空复杂度还是O(N)
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
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
                if(top.left == null && top.right == null){
                    return depth+1;
                }
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
