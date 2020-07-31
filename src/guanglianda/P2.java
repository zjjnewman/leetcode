package guanglianda;

import sun.security.util.Length;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class P2 {

    public void change(ArrayList<Integer> nums){

        while (true){
            int min = findMinRepeatableNum(nums);

            // 如果有最小重复元素，处理
            if(min != -1){
                nums.remove(nums.indexOf(min));
                int idx = nums.indexOf(min);
                nums.remove(idx);
                nums.add(idx, min * 2);
            } else {
                break;
            }
        }

    }



    // 查找最小重复元素的值
    public int findMinRepeatableNum(ArrayList numsList){
        Object[] nums = numsList.toArray();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i+1]){
                return (int) nums[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {

        /**
         *
         */
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        ArrayList arrayList = new ArrayList();
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            arrayList.add(tmp);
        }

        P2 p2 = new P2();
        p2.change(arrayList);

        bufferedWriter.write(Arrays.toString(arrayList.toArray()));
        bufferedWriter.flush();
    }
}
