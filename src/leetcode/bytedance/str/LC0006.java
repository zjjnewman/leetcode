package leetcode.bytedance.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换 https://leetcode-cn.com/problems/zigzag-conversion/
 *
 */
public class LC0006 {
    public String convert(String s, int numRows) {
        if(s.length() == 0 || numRows == 0){
            return "";
        }

        if(numRows == 1){
            return s;
        }

        List<StringBuilder> lists = new ArrayList<>();

        //是否转换状态标志位
        boolean turn = false;

        //初始化数组的字符串数组
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            lists.add(sb);
        }

        //初始化数组下标
        int rowsIdx = 0;
        for (int i = 0; i < s.length(); i++) {

            lists.get(rowsIdx).append(s.charAt(i));

            //如果没转换状态
            if(!turn){
                rowsIdx++;
                if(rowsIdx == (numRows - 1)){
                    turn = true;
                }
            } else {
                rowsIdx --;
                if(rowsIdx == 0){
                    turn = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(lists.get(i));

        }
        return sb.toString();
    }
}
