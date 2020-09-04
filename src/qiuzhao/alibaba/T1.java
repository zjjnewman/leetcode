package qiuzhao.alibaba;


import java.math.BigInteger;
import java.util.Scanner;

public class T1 {
    private static int mod = 998244353;

    public static void method(){

    }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long d = scanner.nextLong();
        BigInteger n4 = fact(new BigInteger(String.valueOf(a+b+c+d)));

        BigInteger a1 = fact(new BigInteger(String.valueOf(a)));
        BigInteger b1 = fact(new BigInteger(String.valueOf(b)));
        BigInteger c1 = fact(new BigInteger(String.valueOf(c)));
        BigInteger d1 = fact(new BigInteger(String.valueOf(d)));

        System.out.println(n4.divide(a1.multiply(b1).multiply(c1).multiply(d1)).mod(new BigInteger(String.valueOf(mod))));

    }
}
