package Array;

import java.util.*;

public class maxProduct {

    /**
     * 分析：全是正数或全是负数都是取其三个最大值（负数中值越大绝对值越小），正负都有的就比较三个最大正数和一最大正二最小负的结果
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int length = nums.length, result = 0, posresult = 0, negresult = 0;
        boolean positive = false, negative = false;
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        for (int i = 0; i < length; i++){
            if(nums[i] >= 0){
                positive = true;
            }else {
                negative = true;
            }
        }
        if(positive && negative){
            for(int x: nums){
                if(x >= 0){
                    posList.add(x);
                }else {
                    negList.add(x);
                }
            }
            Collections.sort(posList);
            Collections.sort(negList);
            if(posList.size()>=3){
                int size = posList.size();
                posresult = posList.get(size-1)*posList.get(size-2)*posList.get(size-3);
            }
            if(negList.size()>=2 && posList.size()>=1) {
                negresult = posList.get(posList.size()-1)*negList.get(0)*negList.get(1);
            }
            System.out.println("有正有负");
            result = posresult>negresult ? posresult : negresult;
        }else {
            System.out.println("全正/全负");
            Arrays.sort(nums);
            result = nums[length-1]*nums[length-2]*nums[length-3];
        }
        System.out.println(result);
        return result;
    }

    /**
     * 分析：关键是找最大的三个和最小的两个，与二叉树类似，只是利用取值范围作起点维护2、3个最值
     * @param nums
     * @return
     */
    public int maximumProduct3(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        int[] nums = {3,-3,5,2,-4};
        maxProduct m = new maxProduct();
        m.maximumProduct3(nums);
    }
}
