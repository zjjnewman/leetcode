import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.platform.commons.function.Try;
import sun.misc.Unsafe;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test{
    public static volatile int count = 0;
    public static int n = 100;
    public static final Object monitor =  new Object();

    public static Runnable run = new Runnable(){
        @Override
        public void run(){
            synchronized(monitor){
                while (count<=n){
                    String s=null;
                    if((s=Thread.currentThread().getName()).equals("t1")){
                        if(count % 2 == 0){
                            System.out.println(s+": "+count);
                            count++;
                        }
                    } else if(Thread.currentThread().getName().equals("t2")){
                        if(count % 2 != 0){
                            System.out.println(count);
                            count++;
                        }
                    }
                    monitor.notifyAll();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                monitor.notifyAll();
            }
        }
    };

    public static Runnable run1 = new Runnable() {
        @Override
        public void run() {
            while (count <= n){
                String s;
                if((s=Thread.currentThread().getName()).equals("t1")){
                    if(count % 2==0) System.out.println(s +" " + count);
                } else if((s=Thread.currentThread().getName()).equals("t2")) {
                    if(count % 2!=0) System.out.println(s +" " + count);
                }
                while (!cas(count, count, count+1));

            }
        }
    };

    public static boolean cas(int cur, int expect, int update){
        if(cur == expect){
            count = update;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(run1, "t1");
        Thread t2 = new Thread(run1, "t2");
        t1.start();
        t2.start();
        Unsafe unsafe = Unsafe.getUnsafe();
        ThreadPoolExecutor e;
        Executors e1;
    }
}
/*
          62003090 996325786 858958590 963069888 885515894 920601393 908712433 884253640 924879241 739410870 984497726 729278470 990689002 126354657
你的输出为: 990689002 126354657 984497726 729278470 924879241 739410870 908712433 884253640 885515894 920601393 858958590 963069888 162003090 996325786
 */