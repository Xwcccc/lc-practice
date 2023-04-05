package HashTable;

import java.util.*;

public class FindSum {
    /**
     * 1. 两数之和
     * 分析：本题找到两数之和为目标数的两数，最保守的计算方式为双层循环，暴力解决；
     * 本题采取先排序，再用双指针从两个方向遍历，找到两位数了，再通过复制的原始数组寻找他们的编号
     * 一次遍历的时候注意，同时匹配，但是已经匹配了的元素之后不能再参与，已经匹配的位置也是不能参与本次与之后的匹配了
     * 时间复杂度：O(logN),空间复杂度：O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        boolean mark1 = false, mark2 = false;
        int slow = 0, fast = nums.length-1;
        int[] result = new int[2], copy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        while (slow < fast){
            if(nums[slow]+nums[fast] == target){
                for (int i = 0; i < copy.length; i++){
                    if(!mark1 && copy[i] == nums[slow]){
                        result[0] = i;
                        mark1 = true;
                    }else if(!mark2 && copy[i] == nums[fast]){
                        result[1] = i;
                        mark2 = true;
                    }
                }
                return result;
            }else if(nums[slow]+nums[fast] > target){
                fast--;
            }else {
                slow++;
            }
        }
        return null;
    }

    /**
     * 分析：target是固定的，想找两数之和=target，就是在固定一个元素的时候，找另一个元素，可以用哈希表
     * 1.首先遍历每一个元素
     * 2.在遍历的过程中，检查哈希表中有没有与之匹配的，有则返回
     * 3.没有则将其加入
     * 其实这种做法背后的思想是，利用快慢指针形成一轮循环，如果将一轮循环的变量选作起始点，那其实跟双层没区别i，所以可以将一轮循环作终点；
     * 这样凡是遍历过的元素都在hash表中，比较的目标又在遍历过的元素里，查询的时间又是O(1),所以整体而言复杂度为O(N)；
     * 而且可以轻易获得其键值
     * hashset.get只能通过Key找到value，不能反过来
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> hashset = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if(hashset.containsKey(target-nums[i])){
                return new int[]{i,hashset.get(target-nums[i])};
            }
            hashset.put(nums[i],i);
        }
        return null;
    }
}
