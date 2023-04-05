package StringType;

public class MateStr {
    /**
     * 28. 找出字符串中第一个匹配项的下标
     * 题解思路：
     * 1.因为是匹配字符串约等于字符数组，可以采取先匹配首字母，首字母相同再匹配后续字符，所以可以采取双指针，一个指针指向首字母匹配，另一个指针指向后续字符串匹配
     * 2.因为首次匹配成功的机会不大，所以很有可能要找到数个匹配的首字符位置，所以可以干脆采取遍历匹配首字符的方式，找到了第一个匹配的直接返回结果，否则继续：for循环，注意循环调用函数的时候参数范围
     * 3.实现每次判断的逻辑：makeend指针从匹配首字母后一个字母开始匹配，循环匹配后面元素，匹配成功就后移一位，不成就暂停匹配；每次循环的判断条件是匹配个数是否满足needle长度了，用于限制后移范围和判断匹配结尾合法与否
     * 时间复杂度最差是O(m*n)，最好是O(n),空间复杂度为O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int makestart = findNext(haystack,0,needle.charAt(0)), makeend = 0;
        if(makestart == -1){
            System.out.println(-1);
            return  -1;
        }
        for (; makestart != -1; makestart = findNext(haystack,makestart+1,needle.charAt(0))){
            makeend = makestart+1;
            while (makeend < haystack.length() && makeend-makestart != needle.length() ){
                if(haystack.charAt(makeend) == needle.charAt(makeend-makestart)){
                    makeend++;
                }else {
                    break;
                }
            }
            if(makeend-makestart == needle.length()){
                System.out.println(makestart);
                return makestart;
            }
        }
        System.out.println(-11);
        return -1;
    }

    public int findNext(String haystack,int count,char target){
        if(count >= haystack.length()){
            return -1;
        }
        while (haystack.charAt(count) != target){
            count++;
            if(count == haystack.length()){
                System.out.println(-1);
                return -1;
            }
        }
        System.out.println(count);
        return count;
    }

    public int strStr2(String haystack, String needle) {
        int start = 0, end = start, compare = 0;
        while (end < haystack.length()){
            if(haystack.charAt(end) == needle.charAt(compare)){
                end++;
                compare++;
            }else {
                compare = findNext2(start,end,haystack);
            }
            if(compare == needle.length()){
                System.out.println(end - needle.length());
                return end - needle.length();
            }
        }
        System.out.println(-1);
        return -1;
    }

    public int findNext2(int start, int end, String haystack){
        if(end == 0 || start == end){
            return 0;
        }
        int left = start, right = end-1, count = 0;
        while (left < right){
            if(haystack.charAt(left) == haystack.charAt(right)){
                count++;
                left++;
                right--;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String m = "leeto";
        MateStr mateStr = new MateStr();
        mateStr.strStr2(s,m);
    }
}
