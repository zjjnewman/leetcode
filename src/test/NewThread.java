package test;

import java.util.concurrent.ThreadPoolExecutor;

class NewThread implements Runnable{
    Thread t1, t2;

    public NewThread() {
        t1 = new Thread(this, "T1");
        t2 = new Thread(this, "T2");
        t1.start();
        t2.start();
    }

    @Override
    public void run(){
        t2.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t1.equals(t2));
    }
}
class Main1{
    public static void main(String[] args) {
        new NewThread();
    }
}

