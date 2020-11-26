package qiuzhao.dianxinyun;

import java.util.*;

public class T33 {

    static public void dfs(double[] moneyVals, Double target, List<Double> combine, List<Double> ret){
        if(target.equals(0.0)){
            ArrayList<Double> tmp = new ArrayList<>(combine);
            Collections.sort(tmp);
            if(ret.containsAll(tmp))return;
            if(ret.size()!=0 && ret.size() > tmp.size()){
                ret = tmp;
                System.out.println(tmp);
            }else if(ret.size() == 0){
                ret = tmp;
            }
            System.out.println(ret.size());
            return;
        }
        if(target.compareTo(0.0) < 0){
            return;
        }

        for (int i = 0; i < moneyVals.length; i++) {
            if((target - moneyVals[i]) < 0.0)continue;
            combine.add(moneyVals[i]);
            dfs(moneyVals, target - moneyVals[i], combine, ret);
            combine.remove(combine.size()-1);
        }
    }

    static public void dfs(int[] moneyVals, int target, Set<Integer> combine, Set<Set<Integer>> ret){

        if(target == 0 && !ret.contains(combine)){
            ret.add(new HashSet<>(combine));
            System.out.println(combine);
            return;
        }
        if(target < 0){
            return;
        }

        for (int i = 0; i < moneyVals.length; i++) {
            combine.add(moneyVals[i]);
            dfs(moneyVals, target - moneyVals[i], combine, ret);
            combine.remove(combine.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double shouldPay = sc.nextDouble();
        double realPay = sc.nextDouble();
        sc.close();
        double target = realPay - shouldPay;
        double[] moneyVal = {10.0, 1.0, 0.5};

        List<Double> combine = new ArrayList<>();
        List<Double> ret = new ArrayList<>();
        dfs(moneyVal, target, combine, ret);
        ThreadLocal t;

    }
}
/*
26.5 50.0
 */