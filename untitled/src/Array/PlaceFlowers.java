package Array;

public class PlaceFlowers {

    /**
     * 分析：主要分几种情况考虑——夹在两个1中间的0、头尾的0、全0各自的计算数目公式不同，本题分四种情况讨论
     * 解法2：可以用参数prev记录停顿位置，初始值为-1说明没有1,复杂度O(N),O(1)
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length, count = 0,total = 0, ins = 0, j = 0, k = length-1, l = 0;
        while (l < length && flowerbed[l]==0){
           l++;
        }
        if(l == length){
            System.out.println("空！");
            System.out.println((length+1)/2>=n);
            return (length+1)/2>=n;
        }
        while (j < length-1 && flowerbed[j] == 0){
            j++;
        }
        if(j > 0){
            total = j/2;
        }
        while (k > 0 && flowerbed[k] == 0){
            k--;
        }
        if(k < length-1){
            total = total + (length-1-k)/2;
        }
        for(int i=j; i<k+1; i++){
            count = 0;
            if(flowerbed[i] == 0){
                count++;
                while (i+1 < length && flowerbed[i+1] == 0){
                    i++;
                    count++;//0的个数
                }
                ins = (count-1)/2;
                total = total + ins;
            }
        }
        if(total >= n){
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int prev = -1, length = flowerbed.length, count = 0;
        for (int i = 0; i < length; i++){
            if(flowerbed[i] == 1){
                if(prev == -1){
                    count = count + i/2;
                }else {
                    count = count + (i-prev-2)/2;
                }
                prev = i;
            }
        }
        if(prev == -1){
            count = (length+1)/2;
        }else {
            count = count + (length-1-prev)/2;
        }
        if(count>=n){
            System.out.println(true);
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        PlaceFlowers f = new PlaceFlowers();
        int[] flowers = {1,0,0,0,1,0,0};
        f.canPlaceFlowers2(flowers,2);
    }
}
