package qiuzhao.mihayou;

import java.util.Scanner;

public class Main {


    static class Fraction{
        // 分子
        public int up;
        // 分母
        public int down;
        public Fraction(){

        }
        public Fraction(int up, int down){
            this.up = up;
            this.down = down;
        }

        @Override
        public String toString() {
            return up + "/" + down;
        }
    }

    public static Fraction reduction(Fraction result){//简化
        if(result.down<0){
            result.up = -result.up;
            result.down = -result.down;
        }

        if(result.up==0){
            result.down = 1;
        } else
        {
            int d = gcd(Math.abs(result.up), result.down);
            result.up /=d;
            result.down /=d;
        }
        return result;
    }



    public static Fraction add(Fraction f1, Fraction f2){
        Fraction result = new Fraction();
        result.up = f1.up * f2.down + f1.down*f2.up;
        result.down = f1.down * f2.down;
        return reduction(result);
    }

    // 减法
    public static Fraction reduce(Fraction f1, Fraction f2){
        Fraction result = new Fraction();
        result.up = f1.up * f2.down - f1.down * f2.up;
        result.down = f1.down * f2.down;
        return reduction(result);
    }

    // 乘法
    public static Fraction multi(Fraction f1, Fraction f2){
        Fraction result = new Fraction();
        result.up = f1.up * f2.up;
        result.down = f1.down * f2.down;
        return reduction(result);
    }


    //除法
    public static Fraction divide(Fraction f1, Fraction f2){
        Fraction result = new Fraction();
        result.up = f1.up * f2.up;
        result.down = f1.down * f2.down;
        return reduction(result);
    }


    static public int gcd(int a, int b){
        if(b==0){
            return a;
        } else{
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.next();
        String o = scanner.next();
        String num2 = scanner.next();
        scanner.close();

        String[] upAndDown1 = num1.split("/");

        String[] upAndDown2 = num2.split("/");


        int up1 = Integer.parseInt(upAndDown1[0]);
        int down1 = Integer.parseInt(upAndDown1[1]);
//
        int up2 = Integer.parseInt(upAndDown2[0]);
        int down2 = Integer.parseInt(upAndDown2[1]);
        Fraction fraction1 = new Fraction(up1, down1);
        Fraction fraction2 = new Fraction(up2, down2);

        if(o.equals("+")){
            Fraction add = add(fraction1, fraction2);
            Fraction reduction = reduction(add);
            System.out.println(reduction.toString());
        }

        /*
        11/8 + 3/8
         */
    }
}
