package StackAndQueue;

import java.util.Stack;

public class RPN {
    /**
     * 1.将字符串转变为int类型，用Integer.phraseInt(String),int转为String类型用String.valueOf(xxx)
     * 2.用栈弹出来计算时，记得除法和减法的参数是有先后顺序的，先弹出来的时除数或者减数
     * 3.==和equals的故事：
     *  String不是基本数据类型，是类
     *  ==：基本数据类型用==是比较数值，对象变量用==是比较在堆上的引用也就是地址
     *  equals：在Object类中是用于比较地址的，所有类都继承了这个方法，String重写了，用来比较字符串内容
     * 4.波兰表达式也就是后缀表达式，更符合计算机的思维
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int count = 0, result = 0, temp = 0;
        while (count < tokens.length){
            if(isNum(tokens[count])){
                stack.push(tokens[count]);
            }else{
                switch (tokens[count]){
                    case "+":
                        result = Integer.parseInt(stack.pop())+Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(result));
                        break;
                    case "-":
                        temp = Integer.parseInt(stack.pop());
                        result = Integer.parseInt(stack.pop())-temp;
                        stack.push(String.valueOf(result));
                        break;
                    case "*":
                        result = Integer.parseInt(stack.pop())*Integer.parseInt(stack.pop());
                        stack.push(String.valueOf(result));
                        break;
                    case "/":
                        if(Integer.parseInt(stack.peek())==0){
                            return -1;
                        }else {
                            temp = Integer.parseInt(stack.pop());
                            result = Integer.parseInt(stack.pop())/temp;
                            stack.push(String.valueOf(result));
                        }
                        break;
                    default:
                }
            }
            count++;
        }
        return Integer.parseInt(stack.peek());
    }

    public boolean isNum(String x){
        return !("+".equals(x) || "-".equals(x) || "*".equals(x) || "/".equals(x));
    }

    public static void main(String[] args) {
        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        RPN r = new RPN();
        r.evalRPN(s);
    }
}
