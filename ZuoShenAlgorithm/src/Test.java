public class Test {


    public static void main(String[] args) {
        int i = 0;
        i = i++;
        System.out.println(i);
    }
}

class A {
    public A foo(){
        return this;
    }

}

class B extends A {
    public A foo(){
        return this;
    }
}

class C extends B{

    @Override
    public A foo(){
        return this;
    }
}