package StackAndQueue;

import java.util.*;

public class DeleteRepeat {
    private Stack<Character> stack = new Stack<>();

    /**
     * 分析：找相邻的重复的元素删除，栈正好合适
     * 可以先转为List类型，然后逐个从数组末尾开始加到起始实现反转,也可以直接弹栈后用头插法存储在String元素里
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        int count = 0;
        while (count < s.length()){
            if(stack.isEmpty()){
                stack.push(s.charAt(count));
            }else {
                if(s.charAt(count) == stack.peek()){
                    stack.pop();
                }else {
                    stack.push(s.charAt(count));
                }
            }
            count++;
        }
        String ss = "";
        while (!stack.isEmpty()){
            ss = stack.pop()+ss;
        }
        return ss;
    }

    /**
     * StringBuffer可以用append、deleteCharAt、charAt、toString，这个实际上就是一个可以模拟栈行为的字符串类
     * 可以用指针top=-1代替栈指针
     * @param s
     * @return
     */
    public String removeDuplicates2(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(top>=0 && ch == stringBuffer.charAt(top)){
                stringBuffer.deleteCharAt(top);
                top--;
            }else{
                stringBuffer.append(ch);
                top++;
            }
        }
        System.out.println(stringBuffer);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        DeleteRepeat deleteRepeat = new DeleteRepeat();
        deleteRepeat.removeDuplicates2("abbaca");
    }
}
