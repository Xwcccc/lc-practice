package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOderBottom {
    /**
     * 注意泛型问题！
     * List<List<Integer>> 和 List<ArrayList<Integer>> 和 ArrayList<ArrayList<Integer>>均是并列关系，没有继承关系
     * 类的兼容不可以放到泛型<>里兼容,所以本题只能新建一个List<> = new ArrayList兼容，内部泛型必须是List<Integer>类型，如果采用reverse了，就是按子类进行了
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
//为什么reverse就变成了ArrayList<ArrayList<Integer>>呢
        List<List<Integer>> result2 = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i-- ) {
            result2.add(result.get(i));
        }
        return result2;
    }
}
