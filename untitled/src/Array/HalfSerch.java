package Array;

public class HalfSerch {

    /**
     * 704. 二分查找：
     * 时间复杂度O(logN),空间复杂度O(1)
     * 分析：循环：节点边界，计算mid，target比较mid，重新界定边界（已比较过的就不纳入了），计算mid，比较mid;
     * 最后结果可能两种：1.找到了，此时mid直接对应 2.没找到，即会出现left>right，所以循环条件是left <= right
     * 本题是左闭右闭区间，所以条件限制<=和节点边界时去除已检查的；另一种时左闭右开区间，即右边界是不检查的，限制条件只需要left<right和右区间不去除
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
              return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            }
        }
        //力扣35.搜索插入位置：最终换成return left;
        return -1;
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = {-1,0,3,5,9,12};
        HalfSerch h = new HalfSerch();
        h.search(nums,target);
    }
}
