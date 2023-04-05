package StackAndQueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * 思路：分俩部分，先是利用哈希表计算频率，再对频率进行排序，可以用小顶堆（优先队列实现）、快排，只是使用后者的时间复杂度为O(N^2)
 * 1.分析：像这种找前K个最值元素的，可以通过堆来实现，小顶堆好比较
 *      首先，堆元素小于k个就直接插入；堆元素大于k个时，比较当前元素和堆顶，若大于堆顶则插入
 * 2.实现堆：最小堆可以用优先队列PriorityQueue实现，这个队列头是优先度最小的
 * 3.复合的元素要存储在优先队列中，要重新定义比较方法
 * 时间复杂度为O(Nlogk),哈希表部分为O(N),遍历哈希表建立堆部分，每一个元素处理时间为O(logk)、空间复杂度为O(N)
 */
public class FindMaxK {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
//这个做法是小顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(int key : map.keySet()){
            int val = map.get(key);
            if(priorityQueue.size() == k){
                if(priorityQueue.peek()[1] < val){
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{key,val});
                }
            }else {
                priorityQueue.offer(new int[]{key,val});
            }
        }
        int[] result = new int[k];
        for (int s = 0; s < k; s++){
            System.out.print(priorityQueue.peek()[0]+",");
            result[s] = priorityQueue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums= {1,1,1,2,2,3};
        int k = 2;
        FindMaxK findMaxK = new FindMaxK();
        findMaxK.topKFrequent(nums,k);
    }
}
