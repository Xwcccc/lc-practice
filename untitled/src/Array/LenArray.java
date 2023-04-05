package Array;

public class LenArray {

    /**
     * 209.长度最小的子数组
     * * 知识点：
     * 滑动窗口：连续子序列问题不确定长度时，一般采用双层循环的解法，但是双层循环效率太低，需要优化。可以通过减少一层循环优化，即滑动窗口，那么就要确定一层循环的下标含义，本题下标指滑动窗口的终点。需要循环终点值，确定最短序列长度的起始点。
     * - 注意事项：
     * 1. total的计算：每循环一次end就叠加终点处的值，只有起始点后移时需要减去起始点值
     * 2. 计算起始点：找到固定终点后，寻找满足条件的最后起始点，记录最小长度
     * 时间复杂度O(N)，空间O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, total = 0, length = Integer.MAX_VALUE, end = 0;
        if (nums.length == 0) {
            return 0;
        }
        for(; end < nums.length; end++){
            total = total + nums[end];
            while (total >= target){
                length = Math.min(end-left+1,length);
                total = total - nums[left];
                left++;
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

    public static void main(String[] args) {
        LenArray l = new LenArray();
        int[] a = {2,3,1,2,4,3};
        l.minSubArrayLen(7,a);
    }
}
