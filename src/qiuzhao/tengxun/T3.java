package qiuzhao.tengxun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class T3 {

    static class StrAndCnt{
        public String s;
        public int cnt;

        public StrAndCnt(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }

    public static List<StrAndCnt> topKFrequent(String[] words, int k, Comparator<StrAndCnt> comparator) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word , count.getOrDefault(word, 0) + 1);
        }
        ArrayList<StrAndCnt> candidates = new ArrayList<>();
        Set<String> strings = count.keySet();

        for (String word : strings) {
            int cnt = count.get(word);
            candidates.add(new StrAndCnt(word, cnt));
        }

        candidates.sort(comparator);
        return candidates.subList(0, k);
    }

    public static String[] stringSort(String [] s) {
        List<String> list = new ArrayList<String>(s.length);
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        Collections.sort(list);
        return list.toArray(s);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.next();
        }
        List<StrAndCnt> strAndCnts = topKFrequent(words, k, new Comparator<StrAndCnt>() {
            @Override
            public int compare(StrAndCnt o1, StrAndCnt o2) {
                return o2.cnt - o1.cnt;
            }
        });
        
        List<StrAndCnt> strAndCnts1 = topKFrequent(words, k, new Comparator<StrAndCnt>() {
            @Override
            public int compare(StrAndCnt o1, StrAndCnt o2) {
                return o1.cnt - o2.cnt;
            }
        });


        for (StrAndCnt strAndCnt : strAndCnts) {
            bw.write(strAndCnt.s + " "+ strAndCnt.cnt);
            bw.write("\n");
        }

        for (StrAndCnt strAndCnt : strAndCnts1) {
            bw.write(strAndCnt.s + " "+ strAndCnt.cnt);
            bw.write("\n");
        }
        bw.flush();
    }
}
