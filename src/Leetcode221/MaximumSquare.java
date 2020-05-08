package Leetcode221;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */

// 题解来源: https://www.cnblogs.com/thoupin/p/4780352.html

public class MaximumSquare {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(solution.maximalSquare(matrix));
    }
}

class Solution {
    /**
     * 主要思路：
     *     1.初始化第一行和第一列
     *     2.从[1][1]开始看上 左 左上是否都是1
     *           如果不是的话 无法构成正方形
     *           如果是的话 可能再之前也是正方形 因此再之前的边长基础上加1 并取三个数的最小值
     *           因为必须三个数的数字相等才能是正方形
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] ret = new int[row][col];

        // 最大值
        int max = 0;

        //初始化第一行
        for(int i=0;i<col;i++){
            /**
             * matrix是char类型的二维数组 其中字符0对应的ASCII码是48
             * 如果为字符'0'，则ret对应的为48-48=0
             * 如果为字符'1'，则ret对应的为49-48=1
             * 实际上是字符与整形之间的快速转换
             */
            ret[0][i] = matrix[0][i] - 48;
            max = Math.max(max, ret[0][i]);
        }

        //初始化第一列
        for(int i=0;i<row;i++){
            ret[i][0] = matrix[i][0] - 48;
            max = Math.max(max, ret[i][0]);
        }

        // 从[1][1]开始 逐个由前三个(上 左 左上)递推
        for(int i=1;i<row;i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j] == '0') {
                    ret[i][j] = 0;
                }else{
                    int left = ret[i-1][j];
                    int top = ret[i][j-1];
                    int left_top = ret[i-1][j-1];
                    if(left > 0 && top > 0 && left_top > 0){
                        ret[i][j] = Math.min(left_top, Math.min(left,top)) + 1;
                    }else{
                        ret[i][j] = 1;
                    }
                    max = Math.max(ret[i][j], max);
                }
            }
        }

        return max * max;
    }
}