package test;

enum Season{
    WINTER,SPRING,SUMMER,FALL
};

class Main{
    public static void main(String[] args) {
        System.out.println(Season.WINTER.ordinal());
        System.out.println(Season.SPRING.ordinal());
    }
}