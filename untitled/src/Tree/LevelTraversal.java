package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelTraversal {
    /**
     * 102. 二叉树的层序遍历
     * 迭代法层级遍历BFS
     * 1.用队列先进先出的原理，然每层的元素进了就出，方便独立统计每一层
     * 2.每次统计层里元素个数，逐个去除并登记，同时从后面压入其非空左右子树
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode cur;
        int size;
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
            }
            result.add(line);
        }
        return result;
    }

    /**
     * 递归写法DFS
     * 1.递归层级深度deep
     * 2.先是考虑每次递归做什么的问题，先考虑root，可以推断出每次递归都要将同一层级的元素加入特定链表中
     * 3.递归内容：左子树和右子树递归
     * 4.边界问题：节点为空、存储数据结构未分配问题
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        int deep = 0;
        List<List<Integer>> result = new ArrayList<>();
        oder(root,result,deep);
        return result;
    }

    public void oder(TreeNode root, List<List<Integer>> result, int deep){
        if(root == null){
            return;
        }
        if(result.size() < deep+1){
            result.add(new ArrayList<>());
        }
        result.get(deep).add(root.val);
        oder(root.left,result,deep+1);
        oder(root.right,result,deep+1);
    }
}
