package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxWindows {
    /**
     * 分析 ：本题本质思想是通过滑动窗口解决，但是学了队列之后发现队列也契合滑动窗口的思想，
     * 主要是每一步pop、push、以及计算出每一步滑动需要的东西，我们可以设计一个适用的队列：
     * 1.首个窗口，每一个元素push的时候都剔除前面比自己小的，以此来维持窗口就是最大值
     * 2.之后滑动的每一步，先看看还有没有需要pop的元素（要跳过在前面已经剔除掉了的，剩下的就是过了期的窗口最大值了），再push一个，找最大值，循环至结尾
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyMovingQueue myMovingQueue = new MyMovingQueue();
        int[] max = new int[nums.length-k+1];
        if(nums.length == 1){
            max = nums;
        }
        for(int i = 0; i < k; i++){
            myMovingQueue.add(new int[]{nums[i],i});
        }
        int count = 0;
        max[count++] = myMovingQueue.peek()[0];
        for (int c = k; c < nums.length; c++){
            myMovingQueue.poll(c-k);
            myMovingQueue.add(new int[]{nums[c],c});
            max[count++] = myMovingQueue.peek()[0];
        }
        return max;
    }

    /**
     * 用优先队列PriorityQueue也就是最大堆实现
     * 处理的细节比较关键：
     * 1.整体思路：逐个滑动窗口，每次用最大堆找窗口内的最大值
     * 2.优先队列设置：根据值从大到小排序，也就是用最大堆，则比较器要用值的降序；如果值相同，那么位置靠前的排前面，即位置的升序
     * 所以，用int[]作优先队列和比较器的泛型参数
     * 3.首次填充最大堆直接取堆顶，之后每次移动滑动窗口直接添加新元素到优先队列中（不遍历查找滑出的元素了），直接判断最大值的位置在不在窗口里，
     * 不在的话去除，在的话留下，所以每次的窗口里可能有很多没去除的元素，因此此处用while
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        int count = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] op1, int[] op2){
                return op1[0] == op2[0] ? op1[1]-op2[1] : op2[0]-op1[0];
            }
        });
        for(int i = 0; i < k; i++){
            queue.offer(new int[]{nums[i],i});
        }
        result[count++] = queue.peek()[0];
        for (int j = k; j < nums.length; j++){
            queue.offer(new int[]{nums[j],j});
            while (queue.peek()[1] <= j-k){
                queue.poll();
            }
            result[count++] = queue.peek()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 1;
        int[] nums = {1,2,3,4};
        MaxWindows maxWindows = new MaxWindows();
        maxWindows.maxSlidingWindow(nums,k);
    }
}
