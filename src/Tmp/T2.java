package Tmp;

public class T2 {
    private T2 t2 = null;
    private T2(){
    }

    public T2 getT2(){
        if(t2 == null){
            synchronized (T2.class){
                if(t2 == null){
                    t2 = new T2();
                }
            }
        }
        return t2;
    }
}
