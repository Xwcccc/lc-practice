package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 要变成快乐数，那得是1、10、100、1000，就是只有一个1
 * s = String.valueOf(n);
 * ch = s.toCharArray();
 *
 */
public class HappyNum {
    /**
     * 分析：首先分析快乐数能否达到的问题：
     * 1.可能达到1
     * 2.在一段范围内循环，就是说第二次出现的数值意味着无法到达1
     * 是第二种情况是根据表格分析得来
     * 1位   9
     * 2位   81
     * 3位   243
     * 4位   324
     * ……………………
     * 13位（int最大位数） 1053
     * 就是说所有情况下要么达到1，要么在243内循环，所以不存在无穷大的情况
     * 3.比较方式的问题，不能先将int转成字符串再转为char[]类型逐个比较，
     * 因为这种比较比的是ascii码，不是实际数值，所以通过%10和/10来实现读指定位数
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> hashset = new HashSet<>();
        int total = 0, cur = 0;
        while (n != 1){
            total = 0;
            while (n > 0){
                cur = n%10;
                n = n/10;
                total += cur*cur;
            }
            if(hashset.contains(total)){
                return false;
            }else{
                hashset.add(total);
            }
            n = total;
        }
        return true;
    }

    /**
     * 快慢指针法，有循环的都能用
     * 快慢指的是通用进程，如果能达到1那么fast一定是最先到的，如果不能那么会陷入循环fast和slow是迟早会相遇的
     * 当面临两个条件时，可以将两个条件均未到达并作大条件，出来之后再判断是哪一种情况
     * 时间复杂度O(logN),O(1)
     * @param n
     * @return
     */
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && fast != slow){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == slow;
    }

    public int getNext(int n){
        int total = 0, cur = 0;
        while (n != 1){
            total = 0;
            while (n > 0){
                cur = n%10;
                n = n/10;
                total += cur*cur;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        HappyNum h = new HappyNum();
        h.isHappy(2);
    }
}
