package StringType;

public class ReverLeft {
    /**
     * 左循环的特点就是左边旋转部分整体循序不变得连接到原结尾
     * 时空复杂度都是O(N)
     * 注意，StringBuilder的append操作是可以用字符串类型的+操作代替的
     * 取余操作优化：由于咱们是分两种情况连接的，其实可以用%统一做法
     *      for (int i = n; i < s.length()+n; i++){
     *             stringBuilder.append(s.charAt(i%s.length));
     *         }
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length(); i++){
            stringBuilder.append(s.charAt(i));
        }
        for (int j = 0; j < n; j++){
            stringBuilder.append(s.charAt(j));
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * 用切片函数substring(left,right)，是左闭右开区间
     * 再通过字符串的+操作连接到一起
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
       return s.substring(n,s.length())+s.substring(0,n);
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        int n = 6;
        ReverLeft reverLeft = new ReverLeft();
        reverLeft.reverseLeftWords(s,n);
    }
}
