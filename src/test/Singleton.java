package test;

public class Singleton{
    private volatile Singleton s=null;
    private Singleton(){};

    private static class singletonHandler{
        private static Singleton singleton = new Singleton();
    }
    public Singleton getSingleton(){
        return singletonHandler.singleton;
    }
}