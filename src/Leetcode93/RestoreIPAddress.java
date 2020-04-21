package Leetcode93;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddress {

    private static ArrayList<String> res;

    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if(s.length() <= 3){
            return res;
        }else if(s.length() == 4){
            res.add(s.charAt(0)+"."+s.charAt(1)+"."+s.charAt(2)+"."+s.charAt(3));
            return res;
        }else{
            generateIpAddresses("",s);
            return res;
        }
    }

    private static void generateIpAddresses(String ipAddress, String s){
        int n = 0; // 数第几个区段
        for(int i=0;i < ipAddress.length();i++){
            if(ipAddress.charAt(i) == '.'){
                n++;
            }
        }
        // 如果已经是第四个区段了 出口条件
        if(n == 3){
            String lastString = s.substring(ipAddress.length() - 3);
            // 区段号大于等于四位
            if(lastString.length() >= 4){
                return;
            }
            // 区段号大于1位 但第一位是0
            if(lastString.length() != 1 && lastString.charAt(0) == '0'){
                return;
            }
            // 区段号要在0到255之间
            if(Integer.valueOf(lastString) >= 0 && Integer.valueOf(lastString) <= 255){
                res.add(ipAddress + lastString);
                return;
            }else{
                return;
            }
        }

        // 保存一个区段取3位的结果
        String[] nextString = new String[3];
        // 区段中可以是 1位，2位，3位，用i表示
        for(int i=0; i < 3; i++){
            // 启示索引 = 前面的长度 - 有几个点 - 1(索引从0开始) + 1(往后数一位)
            // 结尾索引 = 前面的长度 - 有几个点 + 1(往后数一位)  + 现在试的是几位的
            int end_index = ipAddress.length() - n + i + 1;
            if(end_index <= s.length()){
                // 取出对应的子字符串
                nextString[i] = s.substring(ipAddress.length() - n, end_index);
                // 如果长度不是1 且0开头 则这种可能性不可以
                if(nextString[i].length() != 1 && nextString[i].charAt(0) == '0'){
                    continue;
                }
                // 如果值在0到255之间 可以继续递归了
                int num = Integer.valueOf(nextString[i]);
                if(num >= 0 && num <= 255){
                    generateIpAddresses(ipAddress + nextString[i] + ".", s);
                }
            }
        }
        return;
    }

    public static void main(String[] args){
        String IpAddress = "1111";
        List<String> res = restoreIpAddresses(IpAddress);
        for(String address: res){
            System.out.println(address);
        }
    }
}
