package StringType;

import java.util.ArrayList;
import java.util.List;

public class ReplaceEmpty {
    /**
     * 剑指 Offer 05. 替换空格
     * 思路：首先String不可变，得把元素放到别处，比如List，他可变，最后也能逐个存到根据其长度确定长度的数组；
     * 字符串.get(index)找到的是字符类型，遍历找到为空格的字符，判断空格的条件是‘ ’ == x，char类型的表达形式是单引号里必须嵌入内容
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        List<Character> list = new ArrayList<>();
        char target = ' ';
        int count = 0;
        while (count < s.length()){
            if(s.charAt(count) == target){
                list.add('%');
                list.add('2');
                list.add('0');
            }else{
                list.add(s.charAt(count));
            }
            count++;
        }
        char[] result = new char[list.size()];
        for (int x = 0; x < list.size(); x++){
            result[x] = list.get(x);
        }
        return new String(result);
    }

    /**
     * 除了List的可变性可利用之外，还可找个既可追加字符也可追加字符串的结构，
     * StringBuilder，它可以追加所有基本数据类型boolean还有别的都行;他还能随即插入，还能直接toString()
     * 时空复杂度都为O(N)
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        StringBuilder builder = new StringBuilder();
        for (char x: s.toCharArray()){
            if(x == ' '){
                builder.append("%20");
            }else{
                builder.append(x);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ReplaceEmpty replaceEmpty = new ReplaceEmpty();
        replaceEmpty.replaceSpace("We are happy.");
    }
}
