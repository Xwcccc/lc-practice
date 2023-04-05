package HashTable;

import java.math.BigInteger;
import java.util.*;

public class FindFourSumKey {
    /**
     * 18. 四数之和
     * 1.大数问题：
     * byte是8位，short是16位，int是32位，long是64位，float是单精度的32位，double是双精度的64位
     * 转换成十进制数，有符号数正负两端都要取范围，注意负数取满正数端-1
     * 其中，int是最多存10位数不满，也就是10亿：-2147483648~2147483647
     * 所以，面对10^9的边界条件，得用long存，记得存的时候右边要强制类型转换
     * 2.主要思路：跟同数组内找三个和为0的差不多，只是外层单层循环变成了双层循环，以及target变一下
     * 3.剪枝问题：O(N^3)以及上一道题的O(N^2)其实都不低，可以通过提出一些判断条件筛选掉不必要的循环
     *  （1）当确定第一个元素时：如果nums[i]+nums[i+1]+nums[i+2]+nums[i+3]都>target，就可以continue了；
     *          如果nums[i]+nums[n−3]+nums[n−2]+nums[n−1]都<target,也可以直接continue了
     *   （2）同理，确定第二个元素时，也可以参照上述边界，只是看的是j
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                int left = 0, right = nums.length-1;
                while (left < i && right > j){
                    long total = (long)nums[left]+nums[right]+nums[i]+nums[j];
                    List<Integer> templist = new ArrayList<>();
                    if(total == target){
                        templist.add(nums[left]);
                        templist.add(nums[i]);
                        templist.add(nums[j]);
                        templist.add(nums[right]);
                        if(!hashSet.contains(templist)){
                            hashSet.add(templist);
                        }
                        left++;
                        right--;
                    }else if(total > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(hashSet);
        for (List<Integer> x:result){
            System.out.println(x);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        FindFourSumKey f = new FindFourSumKey();
        f.fourSum(nums,target);
    }
}
