package Array;

public class MaxAverage {

    /**
     * 分析：求平均值MAX就是求总和MAX，一般固定长度子序列会采用滑动方式，比较首尾数来确定更新的总和位置,
     * 因为滑动的单位可能是1，所以不用下标标记，而是采取后者与前面最大值比较
     * 浮点问题：如果数组等一开始的参数用的是整数，根据题目范围误差可以在最终结果中*1.0化作浮点数，一开始浮点数整数混用会有更大的误差
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int maxtotal = 0, Max = 0;
        for(int i=0; i<k; i++){
            maxtotal = maxtotal + nums[i];
        }
        Max = maxtotal;
        for(int j=k; j<nums.length; j++){
            maxtotal = maxtotal - nums[j-k] + nums[j];
            Max = Math.max(Max,maxtotal);
        }
        return 1.0*Max/k;
    }

    public static void main(String[] args) {
        int[] a = {0,4,0,3,2};
        MaxAverage m = new MaxAverage();
        m.findMaxAverage(a,1);
    }
}
