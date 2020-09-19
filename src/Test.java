import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import datastructure.tree.TreeNode;
import datastructure.tree.TreeUtils;

import javax.print.attribute.standard.NumberUp;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * {@link java.util.concurrent.locks.ReentrantReadWriteLock}
 */

public class Test {
    static double a;

    public void method(String str){
        byte[] strBytes = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strBytes[i] = (byte) str.charAt(i);
        }
    }

    volatile int  cnt=0;

    Thread T1 = new Thread(new Runnable(){
        @Override
        public  void run(){
            cnt++;
        }
    });

    Thread T2 = new Thread(new Runnable(){
        @Override
        public  void run(){
            try {
                T1.join();
                cnt--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread T3 = new Thread(new Runnable(){
        @Override
        public void run(){
            try {
                T2.join();
                System.out.println(cnt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws UnsupportedEncodingException {


    }



}
