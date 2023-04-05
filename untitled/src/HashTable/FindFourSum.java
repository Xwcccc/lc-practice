package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FindFourSum {
    /**
     * 采用分组+哈希思想
     * 首先双层循环将第一组的total存进哈希表，注意：
     * 由于不同组合产生相同的total也是存在的，我们目的是寻找不同组合，因此total作键，total出现次数作值，hashmap.getOrDefault(total,0)+1实现
     * 第二组是用于检测两组和是否等于0，有两种可能：
     * 1.total1 = -total2
     * 2.total1 = total2 = 0
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int total = 0, result = 0;
        for(int i: nums1){
            for (int j: nums2){
                total = i + j;
                hashmap.put(total,hashmap.getOrDefault(total,0)+1);
            }
        }
        for (int k: nums3){
            for (int v: nums4){
                total = k + v;
                if(hashmap.containsKey(-total)){
                    result += hashmap.get(-total);
                }else if(total == 0 && hashmap.containsKey(0)){
                    result += hashmap.get(total);
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,-1}, nums2 = {-1,1}, nums3 = {-1,1}, nums4 = {1,-1};
        FindFourSum f = new FindFourSum();
        f.fourSumCount(nums1,nums2,nums3,nums4);
    }
}
