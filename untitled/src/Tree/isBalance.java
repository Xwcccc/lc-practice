package Tree;

public class isBalance {
    /**
     * 时间复杂度：每个节点都会判断一次平衡，而每个节点判断平衡时求取高度，
     * 每次求取高度都是自上而下的，很多节点此时被重复访问，每个节点一般是被访问logp次，链式树时就是N次，所以为O(N^2)
     * 空间复杂度：看递归次数，此处为O(N)
     * 本题采用类似前序遍历的思想，自顶向下遍历
     * 注意:某节点的深度指根节点到此节点的最长距离，某节点的高度是指该节点到叶子节点的最长距离
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return Math.abs(height(root.left)-height(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int LeftHeight = height(root.left)+1;
        int RightHeight = height(root.right)+1;
        return LeftHeight>RightHeight ? LeftHeight : RightHeight;
    }

    public boolean isBalanced2(TreeNode root) {
       return height2(root) >= 0;
    }

    /**
     * 自底向上遍历：时空复杂度都为O(N)
     * @param root
     * @return
     */
    public int height2(TreeNode root){
        if(root == null){
            return 0;
        }
        int LeftHeight = height2(root.left);
        int RightHeight = height2(root.right);
        if(LeftHeight == -1 || RightHeight == -1 || Math.abs(LeftHeight-RightHeight) > 1){
            return -1;
        }
        return Math.max(LeftHeight,RightHeight)+1;
    }
}
