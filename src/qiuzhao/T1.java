package qiuzhao;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.*;

public class T1 {

    public ArrayList<String> findCommonString (ArrayList<ArrayList<String>> values) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (ArrayList<String> value : values) {
            for (String s : value) {
                if(set.contains(s)){
                    res.add(s);
                }else {
                    set.add(s);
                }
            }
        }

        return res;
    }


    public ArrayList<String> findCommonString1 (ArrayList<ArrayList<String>> values) {


        List<String> intersect=null;
        for (int i = 0; i < values.size() - 1; i=i+2) {
            ArrayList<String> arr1 = values.get(i);
            ArrayList<String> arr2 = values.get(i+1);
            intersect = intersect(arr1, arr2);
        }
        return (ArrayList<String>) intersect;
    }

    public static List<String> intersect(List<String> arr1, List<String> arr2){
        Map<String, Boolean> map = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for (String s : arr1) {
            if(!map.containsKey(s)){
                map.put(s,Boolean.FALSE);
            }
        }
        for (String s : arr2) {
            if(map.containsKey(s)){
                map.put(s,Boolean.TRUE);
            }
        }

        for (Map.Entry<String, Boolean> e : map.entrySet()) {
            if(e.getValue().equals(Boolean.TRUE)){
                list.addFirst((e.getKey()));
            }
        }
        return list;
    }
}
