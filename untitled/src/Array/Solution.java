package Array;

import java.util.*;

/**
 * 难度：easy
 * 题号：415
 * 全程时间：1h
 * 复杂度：时间——O(nlogn)；空间——O(logn)，排序只看额外的空间，本处需要用到栈空间为logn
 * 题目：给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)
 */
public class Solution {

    public int thirdMax(int[] origin){
        int length = origin.length;
        int term;
        if(length >= 3) {
            int count =3;
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < length - i - 1; j++) {
                    if (origin[j] > origin[j + 1]) {
                        term = origin[j];
                        origin[j] = origin[j + 1];
                        origin[j + 1] = term;
                    }
                }
                if(i > 0){
                    if(origin[length-i-1] == origin[length-i]){
                        count++;
                    }
                }
                if(count>length){
                    // System.out.println(origin[length-1]);
                    return origin[length-1];
                }
            }
            if(count>3){
                System.out.println("前三名存在并列名次");
            }
            //System.out.println(origin[length-count]);
            return origin[length-count];
        }else{
            System.out.print("不存在三个以上元素\n");
            if(length == 2){
                //System.out.println((Math.max(origin[0], origin[1])));
                return (Math.max(origin[0], origin[1]));
            }else {
                //System.out.println(origin[0]);
                return origin[0];
            }
        }
    }

    /**
     * 分析:主要是分类数组元素数、排序问题、重复问题，分类可用三目条件、
     * 可以利用Set/List的contains先去重、再用Collections的sort排序
     * 复杂度：去重Set复杂度为O(n)，排序sort为0(nlogn)，时间——O(nlogn),空间——O(n)sort仅用O(logn)
     * 注意点：用Set和ArrayList记得加泛型、ArrayList可以将set集转化为list，在新建时放入()即可、
     * List根据index找是从0开始但是size则是从1开始，要注意前后三种数据结构转换之后元素顺序和数目的变化
     * @param origin
     * @return
     */
    public int thirdMax2(int[] origin){
        /**
         * AraayList<Integer> a = new ArrayList<>();
         * for(int x: origin) if(!a.contains(x)) a.add(x)
         */
        Set<Integer> distinct = new HashSet<>();
        for (int x: origin) {
            distinct.add(x);
        }
        ArrayList<Integer> list = new ArrayList<>(distinct);
        Collections.sort(list);
        int length = list.size();
        int a = length>=3 ? list.get(length-3) : list.get(length-1);
        return a;
    }

    /**
     * 分析：去重、利用二叉树存储最大三位排序结果，每当向二叉树存入元素都要变动：用comparedTo实现元素升序且元素不能重复
     * 复杂度：时间复杂度O(n)，空间复杂度O(1)
     * @param origin
     * @return
     */
    public int thirdMax3(int[] origin){
        TreeSet<Integer> tree = new TreeSet<>();
        for(int x: origin){
            tree.add(x);
            if(tree.size()>3){
                tree.remove(tree.first());
            }
        }
        int result = tree.size()<3 ? tree.last() : tree.first();
        System.out.println(result);
        return result;
    }

    public static void main(String[] args){
        int[] a = {2,2,1,3};
        Solution fid = new Solution();
        fid.thirdMax3(a);
    }
}
