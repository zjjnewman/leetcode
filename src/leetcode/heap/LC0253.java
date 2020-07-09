package leetcode.heap;

import java.io.*;
import java.util.*;
/**
 * 《测试用例的输入输出问题》
 * 用到了 堆 数据结构
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
        /**
         * 1428. 活动安排问题
         * 第一行一个正整数n (n <= 10000)代表活动的个数。
         * 第二行到第(n + 1)行包含n个开始时间和结束时间。
         * 开始时间严格小于结束时间，并且时间都是非负整数，小于1000000000
         *
         * 输入reader 输入要测试的数据
         * 输出writer 是吧程序产生的输出写入到标准输出，测试程序会抓取这些输出。
         */
        class Meeting{
            public int start;
            public int end;
            Meeting(int start, int end){
                this.start = start;
                this.end = end;
            }
        }
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        //int n = Integer.parseInt(reader.readLine());
        //writer.write(n);
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        // 用这个数组接收连着的几行数据
        Meeting[] startOrderedArray = new Meeting[n];
        for (int i = 0; i < n; i++) {
            startOrderedArray[i] = new Meeting(scanner.nextInt(), scanner.nextInt());
        }

        //主要程序内容写在这里

        // 解答开始
        // 构造数据结构

        // 读入数据

        // 读入行数


        // 用这个数组接收连着的几行数据
//        Meeting[] startOrderedArray = new Meeting[n];
//        for (int i = 0; i < n; i++) {
//            // 读入一行
//            String s = reader.readLine();
//            // 一行有两个数据，去除前后的空格
//            s = s.trim();
//            // 把两个数据中间的空格用 一个','代替，方便分割String数组
//            s = s.replaceAll("\\s+", ",");
//            // 分割string数组，0是起始时间 1是结束时间
//            String ss[] = s.split(",");
//            // 把开始结束时间放入meeting数据结构
//            startOrderedArray[i] = new Meeting(Integer.parseInt(ss[0]), Integer.parseInt(ss[1]));
//        }

        // 首先按照会议起始时间排序
        Arrays.sort(startOrderedArray, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.start - o2.start;
            }
        });

        // 优先队列作为堆存储结构，堆顶为最早结束的时间
        PriorityQueue<Meeting> endSmallHeap = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.end - o2.end;
            }
        });


        /**
         * 数据结构准备完毕，开始处理，
         * 开始的时候，startArray是开始时间的有序数组，结束时间的小顶堆为空
         * 取出最早开始会议startTime，在endSmallHeap中取出堆顶endTime，看是否 startTime >= endTime
         *      若是 不用开辟新会议室，把此会议endTime放入 endSmallHeap
         *      若否 开辟新会议室，把此会议endTime放入 endSmallHeap
         */
        int meetingRoomCnt = 0;
        for (int i = 0; i < n; i++) {
            Meeting startMeeting = startOrderedArray[i];
            if(endSmallHeap.isEmpty()){
                endSmallHeap.offer(startMeeting);
                meetingRoomCnt++;
                continue;
            }

            Meeting endMeeting = endSmallHeap.peek();
            if (startMeeting.start >= endMeeting.end) {
                endSmallHeap.poll();
                endSmallHeap.offer(startMeeting);
            } else {
                meetingRoomCnt++;
                endSmallHeap.offer(startMeeting);
            }

        }
        writer.write(String.valueOf(meetingRoomCnt)+" "+endSmallHeap.size());
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] array = new int[n];

        for(int i = 0; i < n; i++)
            array[i] = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(array);
        for(int i = 0; i < n; i++)
            bufferedWriter.write(array[i] + "\r\n");

        bufferedWriter.flush();
    }
}


