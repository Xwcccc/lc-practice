package StringType;

public class ReverseString {
    /**
     * 344. 反转字符串
     * 分析：主要是前后双指针一次遍历char数组，对换
     * 1.边界条件：循环条件为i<j
     * 2.剪枝：当对换二者相等时，其实不用对换
     * 3.记得任何情况都要往内走一步，注意分类讨论产生的误区
     * @param s
     */
    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        char temp = 0;
        while (i < j){
            if(s[i] == s[j]){
                i++;
                j--;
                continue;
            }
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
