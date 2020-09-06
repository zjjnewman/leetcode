package datastructure.math;

import java.math.BigInteger;

public class Fact {

    // 阶乘
    public static BigInteger fact(BigInteger num){
        if(num.equals(new BigInteger("0"))){
            return new BigInteger("1");
        }
//        long tmp = 1;
        BigInteger tmp = new BigInteger("1");
//        long factorial=1;
        BigInteger factorial = new BigInteger("1");
        while (num.compareTo(tmp)>=0){
            factorial=factorial.multiply(tmp);
            tmp = tmp.add(new BigInteger("1"));
        }
        return factorial;
    }

    public static long fact1(long num){
        if(num==0){
            return 1;
        }
        long tmp = 1;
        long factorial = 1;
        while (num >= tmp){
            factorial = factorial * tmp;
            tmp = tmp + 1;
        }
        return factorial;
    }

    public static void main(String[] args) {
        long a = 5;
        BigInteger b = new BigInteger("5");
        System.out.println(fact(b));
        System.out.println(fact1(a));
    }

}
