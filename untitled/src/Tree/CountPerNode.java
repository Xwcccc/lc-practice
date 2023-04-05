package Tree;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class CountPerNode {
    /**
     * 当然可以通过深度遍历和层序遍历统计节点数，消耗的时间复杂度均为O(N)，前者空间复杂度为O(H)，后者为O(N)——最坏情况
     * 但是既然是完全二叉树，可以利用完全二叉树的特征（除了最后一层聚集在左边没填满以外别的层都填满了）
     * 比如深度遍历从右边查找最后一层缺失的个数，可惜debug没完成，节点上移的时候难以处理
     * 1.结点数计算：2^0+2^1+…………+2^h = 2^(h+1)-1,h从0开始记录层数，所以总的结点数范围在2^(h+1)~2^(h+2)-1
     * 2.二进制编码二叉树路径：每层节点用层数+1位二进制数表示，向下往左节点就是0，往右节点就是1，每层最高位永远是1
     * 3，完全二叉树包括满二叉树和底层右边未满两种情况
     * 解题思路：利用叶子层二进制编码判断某节点是否存在，找到第一个不存在的节点——根据编码的路径查找
     * 注意：二分法的边界：由于low已经代表确定存在的节点，high代表未确定节点，那么mid就应该落在未确定节点上做判断，loq+high /2是向小舍的
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int deep = -1;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            deep++;
            if(t.left != null){
                stack.push(t.left);
            }else{
                break;
            }
        }
        int low = (int)Math.pow(2,deep), high = (int)Math.pow(2,deep+1)-1, mid;
        while (low != high){
            mid = (low+high)/2+1;
            if(isExist(mid,root,deep)){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean isExist(int mid, TreeNode root, int level){
        int temp = 1 << (level-1);
        TreeNode found = root;
        while (found != null && temp > 0){
            if((mid & temp) > 0){
                found = found.right;
            }else{
                found = found.left;
            }
            temp >>= 1;
        }
        return found != null;
    }
}
