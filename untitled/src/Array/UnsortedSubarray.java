package Array;

import java.util.Arrays;

/**
 * @author hp
 */
public class UnsortedSubarray {

    /**
     * 分析：因为要确定的是无序的，连续子数组，所以重点是找到两端无序点，
     * 有个误区是：找左端下降点和右端上升点，其实要找左右最近最远下降点和右左最近最远上升点，
     * 两者合并最大范围才是所求,没有重合就是没有连续的
     * 复杂度：时间;O(N)，空间O(1)，Math很占时间，尽量放在条件里使用
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length,  max=nums[0], min=nums[length-1], low=0, high=length-1;
        if(length == 1){
          return 0;
        }
        for (int i = 1; i < length; i++){
            if(nums[i]<max){
                low = i;
            }else{
                max = Math.max(nums[i],max);
            }
            if(nums[length-1-i]>min){
                high = length-1-i;
            }else {
                min = Math.min(nums[length-i-1],min);
            }
        }
        int result = low>high ? low-high+1 : 0;
        return result;
    }

    /**
     * 分析：不找无序，观察有序段，只要有序段长，无序段就短了
     * System.arraycopy(原数组，原数组复制起始，目标数组，目标数组复制起始,长度)
     * 复杂度：时间：O(nlogn)、空间:O(n)
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        if(nums.length==0 || isSorted(nums)){
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums,0,copy,0,nums.length);
        Arrays.sort(copy);
        int i=0, j=nums.length-1;
        while (nums[i]==copy[i]){
            i++;
        }
        while (nums[j]==copy[j]){
            j--;
        }
        System.out.println(j-i+1);
        return j-i+1;
    }

    public boolean isSorted(int[] nums){
        for (int i=0; i<nums.length-1; i++){
            if(nums[i]>nums[i+1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        UnsortedSubarray s = new UnsortedSubarray();
        s.findUnsortedSubarray2(nums);
    }
}
