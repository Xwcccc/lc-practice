package StringType;

import java.util.*;

public class ReverWords {
    /**
     * 151. 反转字符串中的单词
     * 分析：
     * 1.题解主要任务——去除前后空格、调转单词之间的顺序、使得单词之间的空格只有一个
     *  用trim去除前后空格，而且String在Java中是不可变的，trim得到一个新字符串要赋给原值；
     *  将String转化为char数组，逐个遍历，以空格为间隔符提交前面遍历的字符组到list中，这种结构用StringBuilder比较好；注意要跳过空格符；
     *  最后反向复制到新StringBuilder中，再toString
     * 2.时空复杂度都是O(N)
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < chars.length; j++){
            if(chars[j] == ' '){
                list.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                while (chars[j] == ' '){
                    j++;
                }
                j--;
            }else{
                stringBuilder.append(chars[j]);
                if(j == s.length()-1){
                    list.add(stringBuilder.toString());
                }
            }
        }
        for(int i = list.size()-1; i >= 0; i--){
            result.append(list.get(i));
            result.append(' ');
        }
        System.out.println(result.toString().trim());
        return result.toString().trim();
    }

    /**
     * 思路跟上面是一样的，只是通过调用内置函数使得代码简洁点，也减少bug
     * 1.字符串类型String有个切割方法：x.split("\\s+"),是通过正则表达式切割的，切割结果放在一个数组里
     * 2。Collections有个reverse方法，可以调转List类型，所以先把数组转化为List，通过Arrays.asList方法
     * 3.字符串有个组合形成字符串方法String.join(List)，对象是List，可以替代StringBuilder
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join("",list);
    }

    public static void main(String[] args) {
        ReverWords reverWords = new ReverWords();
        reverWords.reverseWords("a good   example");
    }
}
