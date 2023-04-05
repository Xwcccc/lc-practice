package Array;

public class PowStore {
    /**
     * 题解：
     * 1.常规考虑数组非负、非正、正负都有三种情况，前二者分别正序和倒叙将平方存储存入新数组，
     * 2.后者采用一次遍历的形式比较两端正负绝对值，将较大的平方值存入新数组
     * 3.边界问题：数组元素为单个/双个时不影响；遍历时采用了nums[left]<0作循环条件，容易产生遍历不完全问题，解决此问题的代码量多，性价比低
     * 优化：
     * 1.分类问题：不用见题就分类，先思考最常见的情况，再看适用与否，找到适用条件，比如本题的采用平方
     * 2.由于最终也要获得元素平方，所以可以比较平方，消除正负带来的影响；
     * 2.边界条件：有正负讨论的最好不要以正/负作为边界，此种划分不完全，可以采用左指针小于等于右指针作循环条件
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length-1, newright = right, inv = 0;
        int[] newStore = new int[nums.length];
        if(nums[0] >= 0){
            while(left < nums.length){
                newStore[left] = nums[left]*nums[left];
                left++;
            }
        }else if(nums[right] <= 0){
            while(right >= 0){
                newStore[left] = nums[right]*nums[right];
                right--;
                left++;
            }
        }else{
            while(nums[right] >= 0 && nums[left] < 0){
                inv = -nums[left];
                if(nums[right] >= inv){
                    newStore[newright] = nums[right]*nums[right];
                    right--;
                }else{
                    newStore[newright] = nums[left]*nums[left];
                    left++;
                }
                newright--;
            }
            while (right >= left){
                if(nums[left] >= 0){
                    newStore[newright] = nums[right]*nums[right];
                    newright--;
                    right--;
                }else if(nums[right] < 0){
                    newStore[newright] = nums[left]*nums[left];
                    newright--;
                    left++;
                }
            }
        }
        return newStore;
    }

    /**
     * 优化版
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int left = 0, right = nums.length-1, newright = right;
        int[] newStore = new int[nums.length];
        while (left <= right){
            if(nums[left]*nums[left] >= nums[right]*nums[right]){
                newStore[newright] = nums[left]*nums[left];
                left++;
            }else {
                newStore[newright] = nums[right]*nums[right];
                right--;
            }
            newright--;
        }
        return newStore;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,3};
        PowStore p = new PowStore();
        p.sortedSquares2(nums);
    }
}
