package qiuzhao.wangyihuyu;

import com.sun.org.apache.bcel.internal.generic.I2F;

import java.util.*;

public class T2 {


    static class Info{
        public String id = "-1";
        public HashSet<String> gThings = new HashSet<>();
        public HashSet<String> maps = new HashSet<>();
        public HashSet<String> markMaps=new HashSet<>();
        public Info() {
        }
        public Info(String id, Info e) {
            this.id = id;
            this.gThings = new HashSet<>(e.gThings);
            this.maps = new HashSet<>(e.maps);
            this.markMaps = new HashSet<>(e.markMaps);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<String, Info> idToMap = new HashMap<>();
        HashMap<String, Info> mapToMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split(" ");
            if(s[1].equals("own")){
                Info info = new Info();
                info.id = s[0];
                info.gThings.add(s[2]);
                info.maps.add(s[2]);
                info.markMaps.add(s[2]);
                idToMap.put(s[0], info);
                mapToMap.put(s[2], info);
            }else if(s[1].equals("record")){
                if(mapToMap.containsKey(s[0])){
                    mapToMap.get(s[0]).markMaps.add(s[2]);
                } else {
                    System.out.println("error");
                    return;
                }
            }else if(s[1].equals("shareto")){
                if(idToMap.containsKey(s[0])){
                    Info e = idToMap.get(s[0]);
                    idToMap.put(s[2], new Info(s[2], e));
                } else {
                    System.out.println("error");
                    return;
                }
            }else if(s[1].equals("abandon")){
                if(idToMap.containsKey(s[0])){
                    Info e = idToMap.get(s[0]);
                    e.maps.remove(s[2]);
                    if(e.markMaps.contains(s[2])){
                        e.markMaps.remove(s[2]);
                    }
                } else {
                    System.out.println("error");
                    return;
                }
            }else if(s[1].equals("storm")){
                HashSet<String> set = new HashSet();
                for (Map.Entry<String, Info> e : idToMap.entrySet()) {

                }

            }else if(s[1].equals("die")){

            }

        }

    }
}
