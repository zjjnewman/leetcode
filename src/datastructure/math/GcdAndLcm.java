package datastructure.math;

public class GcdAndLcm {
    /**
     * 求最大公约数，递归
     * @param a
     * @param b
     * @return
     */
    static public int gcd(int a, int b){
        if(b==0){
            return a;
        } else{
            return gcd(b, a%b);
        }
    }

    // 最大公约数非递归
    public static int gcd1(int a, int b){
        // 让a保持最大
        if(a < b){
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if(b == 0){
            return a;
        }else {
            while(b != 0){
                if(a == b){
                    return a;
                }else{
                    int k = a % b;
                    a = b;
                    b = k;
                }
            }
            return a;
        }
    }

    // 最小公倍数
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 1071;
        int b = 462;
        System.out.println(gcd(a, b));
        System.out.println(gcd1(a, b));
        System.out.println(lcm(a, b));
    }
}
