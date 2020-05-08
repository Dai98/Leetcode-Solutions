package Leetcode69;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 思路一：二分法
 * 思路二：牛顿迭代法
 */
public class mySqrt {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt1(4));
        System.out.println(solution.mySqrt1(8));
        System.out.println(solution.mySqrt2(4));
        System.out.println(solution.mySqrt2(8));
    }
}

class Solution{

    // 二分法
    public int mySqrt1(int x) {
        long left = 0;
        long right = x;
        long mid = 0;

        while(left <= right){
            mid = left + (int)(right-left)/2;
            if(mid * mid > x){
                right = mid - 1;
            }else if(mid * mid < x){
                left = mid + 1;
            }else{
                return (int)mid;
            }
        }

        return (int)Math.min(left, right);
    }

    // 牛顿法
    // 实际上是在寻找f(x) = a - x^2的零点
    // 我们用(x,f(x))所在的切线不断逼近零点
    // 牛顿法递推公式 Xn+1 = Xn - f(Xn)/f'(Xn)
    // 函数的切线方程为f'(x)=-2x
    // 新的零点坐标为 x - f(x)/2x
    // 带入f(x), 也就是(x+a/x)/2
    public int mySqrt2(int x) {
        long num = x;
        while(num * num > x){
            num = (num + x / num) / 2;
        }
        return (int)num;
    }
}
