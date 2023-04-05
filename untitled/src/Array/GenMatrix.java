package Array;

public class GenMatrix {
    /**
     * 59. 螺旋矩阵 II
     * 分析：螺旋矩阵问题关键在于螺旋实现以及圈层循环实现：
     * 矩阵螺旋实现要分四个方向，为统一旋转模式，要限定区间为左闭右开；
     * 矩阵圈层循环数为行数n/2，圈层之间转换可以依靠起始点设置
     * 最后记得单独讨论最内层元素
     * 时间复杂度O(N^2),空间O(1)
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int start = 0, count = 1, loop = 0, j = start, i = start;
        int[][] matrix = new int[n][n];
        while (loop++ < n/2){
            j = start;
            while (j < n-loop){
                matrix[start][j] = count++;
                j++;
            }
            i = start;
            while (i < n-loop){
                matrix[i][j] = count++;
                i++;
            }
            while (j >= loop) {
                matrix[i][j] = count++;
                j--;
            }
            while (i >= loop){
                matrix[i][j] = count++;
                i--;
            }
            start++;
        }
        if(n % 2 == 1){
            matrix[start][start] = count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        GenMatrix g = new GenMatrix();
        g.generateMatrix(3);
    }
}
