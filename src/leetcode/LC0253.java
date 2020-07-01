package leetcode;

import java.io.*;
import java.util.*;
/**
 * 《测试用例的输入输出问题》
 *
 * 253. 会议室II https://leetcode-cn.com/problemset/algorithms/?search=253
 * 雷同 1428. 活动安排问题 http://www.51nod.com/Challenge/Problem.html#problemId=1428 由这个引出了《测试用例的输入输出问题》
 * 《300分钟搞定算法》https://www.bilibili.com/video/BV1SK411V7Lq?p=8
 */
public class LC0253 {


    public void meetingRoom(){
        //253. 会议室II https://leetcode-cn.com/problemset/algorithms/?search=253
    }


    //51nod的模板代码
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        //int n = Integer.parseInt(reader.readLine());
        //writer.write(n);
        //主要程序内容写在这里

        writer.flush();
    }

}

/**
 * 关于《输入输出》的问题，下边给出示例
 * 51nod 示例代码
 *
 */
class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(array);
        for(int i = 0; i < n; i++)
            writer.write(array[i] + "\r\n");

        writer.flush();
    }
}


