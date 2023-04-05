package StringType;

public class ReverseFrontK {
    /**
     * 1.其实先考虑一般情况，可以进行一次以上的2k查找：在到达结尾+1之前，循环2k倍数的节点，将其内部的前k个用双向链表反转
     * 2.然后再处理结尾部分：结尾剩下的部分一般就是小于2k长度的，根据题意区分k以内以及k到2k的，确定反转范围变量
     * 3.边界情况：第一次查找2k就出了界，就是说直接跳过了步骤1进行第二步
     * 4.考虑边界情况的时候发现，若第一次跳到的位置是length位置，那么其实这个数组就是2k个，前三步都忽略了这种情况，所以在第一步循环的时候用<=length下标
     * 时间复杂度：O(N),空间复杂度:O(N)，取决于存取字符数组的长度，或者可以原地修改，比如方法2
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        int i = 0;
        char temp = 0;
        char[] chars = s.toCharArray();
        while (i <= s.length()){
            if(i != 0){
                int left = i - 2*k, right = i - k -1;
                while (left < right){
                    temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
            }
            i += 2*k;
        }
        i -= 2*k;
        int startnum = i;
        int endnum = 0;
        if(s.length()-i < 2*k){
            if(s.length()-i < k){
                endnum = s.length()-1;
            }else if((s.length()-i) >= k && (s.length()-i < 2*k)) {
                endnum = i + k - 1;
            }
            while (startnum < endnum){
                temp = chars[startnum];
                chars[startnum] = chars[endnum];
                chars[endnum] = temp;
                startnum++;
                endnum--;
            }
        }
        for (char x:chars){
            System.out.print(x+",");
        }
        return new String(chars);
    }

    /**
     * 这种书写更简便,与其比较最后剩余不足2k的长度，不如比较最后是i+k-1先到达还是length-1先到达结束
     * @param s
     * @param k
     * @return
     */
    public String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2*k){
            rever(chars,i,Math.min(i+k-1, chars.length-1));
        }
        for (char x:chars){
            System.out.print(x+",");
        }
        return new String(chars);
    }

    public void rever(char[] str,int i,int j){
        char temp;
        while (i < j){
            temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int k = 2;
        String s = "abcd";
        ReverseFrontK reverseFrontK = new ReverseFrontK();
        reverseFrontK.reverseStr2(s,k);
    }
}
