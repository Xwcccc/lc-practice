package Tree;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PrintAllPath {

    /**
     * 几个巧妙之处:
     * 1.逐条路线来，而不是广撒网
     * 2.StringBuffer的构造函数可以用参数作为新缓冲区的原始数据，之后append的数据在此基础上叠加
     * 时间复杂度：深度搜索每个结点仅访问一次，但本题每次访问都拷贝此前路线：O(N^2)
     * 空间复杂度：看递归次数，最坏情况高度为N，递归调用N次，每次递归都复制此前深度长度的字符串：O(N^2)；
     * 最好情况是平衡二叉树：高度为O(logN),每次递归的长度字符串长度也不会超过logN,则为O(logN ^2)
     * 自上而下添加路径，避免了回溯
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<String>();
        return addPath(root, list,"");
    }
    public List<String> addPath(TreeNode root, ArrayList<String> list, String record){
        if(root != null){
            StringBuilder s = new StringBuilder(record);
            s.append(root.val);
            if(root.left == null && root.right == null){
                list.add(s.toString());
            }else{
                s.append("->");
                addPath(root.left,list,s.toString());
                addPath(root.right,list,s.toString());
            }
        }
        return list;
    }

    /**
     * 层序遍历
     * 1.节点遍历和路径遍历同步，丢掉节点之后要么是提交路径要么是接着续路径，路径都需要更改
     * @param root
     * @return
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<String> stringQueue = new ArrayDeque<>();
        nodeQueue.offer(root);
        stringQueue.offer(String.valueOf(root.val));
        while (!nodeQueue.isEmpty()){
            TreeNode top = nodeQueue.poll();
            String stop = stringQueue.poll();
            if(top.left == null && top.right == null){
                list.add(stop);
            }else{
                if(top.left != null){
                    nodeQueue.offer(top.left);
                    stringQueue.offer(stop+"->"+top.left.val);
                }
                if(top.right != null){
                    nodeQueue.offer(top.right);
                    stringQueue.offer(stop+"->"+top.right.val);
                }
            }
        }
        return list;
    }
}
