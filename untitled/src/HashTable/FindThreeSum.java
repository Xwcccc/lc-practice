package HashTable;

import java.util.*;

public class FindThreeSum{
    /**
     * 主要思想：首先将数组从小到大排序，从1号元素遍历到倒数第2个元素作中间元素，每个中间元素左右各一个指针寻找三数和为0的两个数；
     * 找到了就放hashset里去重，最后再放到List里
     * 1.hashSet转化为List方法：
     *  构建法：List<List<Integet>> result = new ArrayList<>(hashSet);
     *  全加法：result.addAll(hashSet);
     * 问题：往List里加List对象时，加的是对象的引用，修改了就被覆盖了，所以每次都新建一个对象
     * 时间复杂度：O(N^2) 空间复杂度O(logN)这是排序需要的空间，空间复杂度若为O(N)就视作用一个新数组存放了排序后的数组
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hashSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length-1; i++){
            int left = 0, right = nums.length-1;
            int total = 0;
            while (left < i && right > i){
                total = nums[left]+nums[right]+nums[i];
                List<Integer> templist = new ArrayList<>();
                if(total == 0){
                    templist.add(nums[left]);
                    templist.add(nums[i]);
                    templist.add(nums[right]);
                    if(!hashSet.contains(templist)){
                        hashSet.add(templist);
                    }
                    left++;
                    right--;
                }else if(total > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(hashSet);
        return result;
    }

    /**
     * 方法2：可以先双层循环遍历确定a,b的值，然后在双层循环内修改和寻找哈希表进行判断，时间复杂度可以做到O(N^2)
     * @param args
     */
    public static void main(String[] args) {
        int[] num = {0,1,1};
        FindThreeSum f = new FindThreeSum();
        f.threeSum(num);
    }
}
