package qiuzhao.meituan;

import java.util.*;

public class Test2 {

    /**
     *
     */

    static class Order{
        public int oNum;
        public int total;
        public Order(int oNum, int value, int weight) {
            this.oNum = oNum;
            this.total = value + weight * 2;
        }
    }
    
    public static List<Order[]> choose(Order[] orders, int m){
        Arrays.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o2.total - o1.total;
            }
        });

        int income = 0;
        for (int i = 0; i < m; i++) {
            income = income + orders[i].total;
        }

        ArrayList<Order[]> list = new ArrayList<>();

        Order[] orders1 = Arrays.copyOfRange(orders, 0, m);
        Arrays.sort(orders1, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.oNum - o2.oNum;
            }
        });

        list.add(orders1);

        for (int i = 1; m + i < orders.length ; i++) {
            int temp = income - orders[i].total + orders[m + i].total;
            if(income == temp){
                Order[] ordersTmp = Arrays.copyOfRange(orders, i, m + i + 1);
                Arrays.sort(ordersTmp, new Comparator<Order>() {
                    @Override
                    public int compare(Order o1, Order o2) {
                        return o1.oNum - o2.oNum;
                    }
                });
                list.add(ordersTmp);
            } else {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            orders[i] = new Order(i + 1, scanner.nextInt(), scanner.nextInt());
        }

        List<Order[]> list =  choose(orders, m);
        Order[] orders1 = list.get(0);
        for (Order order : orders1) {
            System.out.print(order.oNum + " ");
        }
    }
}
