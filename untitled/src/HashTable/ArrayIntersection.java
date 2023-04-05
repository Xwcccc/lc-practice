package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
    /**
     * 1.主要思想就是：先把第一个数组不重复地添加进HashMap中，再遍历第二个数组看有contains的就是交集
     * 2.要规避第二个数组也有重复元素的问题，所以采用HashMap，这样可以用值记录一个元素是否被提取做交集
     * 3.最后是返回一个数组的问题，数组定义必须固定长度，可以先存储在一个list中，再将最终结果存入数组中，当然这是空间的浪费
     * 4.时间复杂度：O(M+N)，空间复杂度：O(M+N)
     * 5.但是使用哈希set和map因为要计算hashcode，所以其实速度都是比数组实现要慢的，而且占用空间也大，
     * 而数组实现可以直接将下标作为索引，在数据量大的时候相差明显。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(count < nums1.length){
            if(!hashmap.containsKey(nums1[count])){
                hashmap.put(nums1[count],0);
            }
            count++;
        }
        count = 0;
        while(count < nums2.length){
            if(hashmap.containsKey(nums2[count]) && hashmap.get(nums2[count]) == 0){
                hashmap.put(nums2[count],1);
                list.add(nums2[count]);
            }
            count++;
        }
        count = 0;
        int[] result = new int[list.size()];
        while (count < list.size()){
            result[count] = list.get(count);
            count++;
        }
        return result;
    }


}
