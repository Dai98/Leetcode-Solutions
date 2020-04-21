package Leetcode91;

import java.util.ArrayList;
import java.util.List;

/**
 * 一条含有A-Z字母的消息被加密为数字，使用一下的映射：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一条加密信息，计算出有多少种解码结果
 * 示例:
 * 1221 -> 5
 * 因为有: ABBA(1 2 2 1), ABU(1 2 21), AVA(1 22 1), LBA(12 2 1), LU(12 21)
 */

public class DecodeWay {

    private List<Integer> res;

    public int numDecodings(String s){
        if(s.length() == 0 | s == null){
            return 0;
        }else if(s.length() == 1){
            return 1;
        }
        res = new ArrayList<>();
        countDecodeWays("",s);
        return res.size();
    }

    private void countDecodeWays(String current, String s){

    }
}
