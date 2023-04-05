package HashTable;


import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    /**
     * 用哈希表解决
     * 1.String对象的toCharArray()方法，将小范围String拆分成char数组，逐个加入哈希表，char作键，出现次数作值，因为是一次性消费，当资源存起来
     * 2.同样处理大范围String，逐个遍历消耗哈希表资源，直至出现-1资源不足的情况
     * 复杂度：时间O(M+N),空间O(M+N)
     * 注意；虽然边界条件包含于次讨论，但是如果单独处理，就不用浪费那么多资源了
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        Map<Character,Integer> hashmap = new HashMap<>();
        char[] charsM = magazine.toCharArray();
        char[] charsR = ransomNote.toCharArray();
        for (char x: charsM){
            hashmap.put(x,hashmap.getOrDefault(x,0)+1);
        }
        for(char y: charsR){
            hashmap.put(y,hashmap.getOrDefault(y,0)-1);
            if(hashmap.get(y) < 0){
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }

    /**
     * 采用哈希前要思考用哪种形式
     * 用Map需要维护hashcode、哈希表、红黑树啥的，占用空间大啊；本题是只有小写元素，完全可以用一个26长度的数组存储
     * 利用字符char类型的ASCII码减法：x-'a'刚好是可以表示数组下标，可以用这个来作下标存储出现次数
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] hasharray = new int[26];
        for (char x: magazine.toCharArray()){
            hasharray[x-'a'] += 1;
        }
        for (char y: ransomNote.toCharArray()){
            hasharray[y-'a'] -= 1;
            if(hasharray[y-'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CanConstruct can = new CanConstruct();
        can.canConstruct2("a","b");
    }
}
