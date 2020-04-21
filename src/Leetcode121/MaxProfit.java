package Leetcode121;

class Solution{
    public int maxProfit(int[] prices){
        if(prices.length == 0){
            return 0;
        }
        int profit = 0, min = prices[0];
        for (int i=1; i <prices.length; i++){
            min = Math.min(prices[i], min);
            profit = Math.max(profit, prices[i]- min);
        }
        return profit;
    }
}
public class MaxProfit {
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.maxProfit(prices2));
    }
}
