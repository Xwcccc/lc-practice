package StackAndQueue;

import java.util.Stack;

public class ValidQuate {
    /**
     * 关键点：
     * 1.遇到左就压栈
     * 2.遇到右符号就先判断是否与当前peek相对应，是的话就弹出，不是的话就返回匹配失败
     * 3.遇到左符号对应右符号对应的，可以用Map<key,value>
     */
    Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        int count = 0;
        while (count < s.length()){
            if(stack.isEmpty()){
                stack.push(s.charAt(count));
            }else {
                if(s.charAt(count) == '(' || s.charAt(count) == '[' || s.charAt(count) == '{'){
                    stack.push(s.charAt(count));
                }else {
                    if(s.charAt(count) == getReverse(stack.peek())){
                        stack.pop();
                    }else {
                        System.out.println(false);
                        return false;
                    }
                }
            }
            count++;
        }
        System.out.println(stack.isEmpty());
        return stack.isEmpty();
    }

    public char getReverse(char x){
        if(x == '('){
            return ')';
        }else if(x == '{'){
            return '}';
        }else if(x == '['){
            return ']';
        }
        return ' ';
    }

    public static void main(String[] args) {
        ValidQuate validQuate = new ValidQuate();
        validQuate.isValid("({[]})");
    }
}
