package qiuzhao.zuiyou;

import java.math.BigInteger;
import java.util.HashMap;

public class M1 {
    static public long transferTo10(String num){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 1); map.put("7", 7);
        map.put("2", 2); map.put("8", 8);
        map.put("3", 3); map.put("9", 9);
        map.put("4", 4); map.put("a", 10);
        map.put("5", 5); map.put("b", 11);
        map.put("6", 6); map.put("c", 12);

        map.put("d", 13); map.put("j", 19);
        map.put("e", 14); map.put("k", 20);
        map.put("f", 15); map.put("l", 21);
        map.put("g", 16); map.put("m", 22);
        map.put("h", 17); map.put("n", 23);
        map.put("i", 18); map.put("o", 24);

        map.put("p", 25); map.put("v", 31);
        map.put("q", 26); map.put("w", 32);
        map.put("r", 27); map.put("x", 33);
        map.put("s", 28); map.put("y", 34);
        map.put("t", 29); map.put("z", 35);
        map.put("u", 30); map.put("0", 0);
        BigInteger sum = new BigInteger("0");
        int cnt=0;
        BigInteger d = new BigInteger("36");
        for (int i = num.length()-1; i >=0 ; i--){
            String b = num.substring(i,i+1);
            BigInteger tmp = d.pow(cnt);
            sum = sum.add(new BigInteger(String.valueOf(map.get(b))).multiply(tmp));
            cnt++;
        }
        return sum.longValue();
    }
    public static void main(String[] args) {
        System.out.println(transferTo10("1y2p0ij32e8e7"));
    }
}
