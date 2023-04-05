package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class isAngram {
    /**
     * 1.hashmap.getOrDefault(key,defaultvalue)可以用来获得原值再进行加减
     * 2.HashMap的put方法是可以直接覆盖已有的key-value
     * 3.可以采用先加后减的方式匹配等值，而不用再次遍历两个独立的HashMap
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
       if(s.length() != t.length()){
           return false;
       }
       Map<Character,Integer> hashmap = new HashMap<>();
       Character ch = null;
       int count = 0;
       while(count < s.length()){
           ch = s.charAt(count);
           hashmap.put(ch, hashmap.getOrDefault(ch,0)+1);
           count++;
       }
       count = 0;
       while (count < t.length()){
           ch = t.charAt(count);
           hashmap.put(ch,hashmap.getOrDefault(ch,0)-1);
           if(hashmap.get(ch) < 0){
               return false;
           }
           count++;
       }
        System.out.println(true);
       return true;
    }

    /**
     * 匹配字符串出现次数，就是匹配排序后是否相等
     * 字符串转换为字符数组：s.toCharArray()
     * 比较问题：
     * String下的a.equals(b)，比较的是字符串内容
     * Charactor[]也没有equals方法，继承Object类的，这个是比较对象地址的，数组用==比较的也是数组地址
     * 要比较数组内容要用Arrays.equals(a,b);
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);
        System.out.println(Arrays.equals(schar,tchar));
        return Arrays.equals(schar,tchar);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        isAngram isAn = new isAngram();
        isAn.isAnagram(s,t);
    }
}
