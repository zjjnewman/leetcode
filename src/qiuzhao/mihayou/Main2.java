package qiuzhao.mihayou;

import java.util.Scanner;

public class Main2 {

    public static Integer getZXGB(Integer aa, Integer bb){
        if(aa ==bb){
            return aa;

        }
        int res =1;
        for (int i = 2; i <= Math.min(aa,bb) ; i++) {
            while (aa%i==0&&bb%i==0){
                res*=i;
                aa=aa/i;
                bb=bb/i;
            }
        }
        return res*aa*bb;
    }

    public static Integer getZDGYS(Integer aa, Integer bb){
        int res =1;
        for (int i = 0; i < Math.min(aa, bb); i++) {
            while (aa%i==0&&bb%i==0){
                res = res*i;
                aa=aa/i;
                bb=bb/i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String input = sc.nextLine();
        String a = input.split("\\s+")[0];
        String b = input.split("\\s+")[1];
        String c = input.split("\\s+")[2];

        String a1 = a.split("/")[0];
        String a2 = a.split("/")[1];

        String b1 = a.split("/")[0];
        String b2 = a.split("/")[1];

        Integer fenzi1 =Integer.valueOf(a1);
        Integer fenzi2 =Integer.valueOf(b1);

        Integer fenmu1 =Integer.valueOf(a2);
        Integer fenmu2 =Integer.valueOf(b2);

        Integer zxgbs = getZXGB(fenmu1, fenmu2);

        Integer fenzi = fenzi1*zxgbs/fenmu1+fenzi2*zxgbs/fenmu2;
        if(fenzi%zxgbs==0){
            System.out.println(fenzi%zxgbs);
        }
        Integer zdgys=getZDGYS(fenzi,zxgbs);
        System.out.println(fenzi/zdgys+"/"+zxgbs/zdgys);

    }
}
