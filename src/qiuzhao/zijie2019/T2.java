package qiuzhao.zijie2019;

public class T2 {
    public int question (int a, int b) {
        // write code here
        int ret = 0;
        for (int i = 0; i <= 500; i++) {

            if(Math.sqrt(i+a) - (int)Math.sqrt(i+a) == 0 && Math.sqrt(i+a+b) - (int)Math.sqrt(i+a+b)==0){
                int m = (int) Math.sqrt(i+a);
                int n = (int) Math.sqrt(i+a+b);
                if(m*m==i+a&&n*n==i+a+b){
                    ret = i;
                }
            }

        }
        return ret;
    }
}
