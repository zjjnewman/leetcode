package qiuzhao.shunfeng;

import java.util.*;

public class Main {

    public static int maxIncome(List<Server> servers, List<Client> clients){
        Collections.sort(servers, new Comparator<Server>() {
            @Override
            public int compare(Server o1, Server o2) {
                return o1.band - o2.band;
            }
        });

        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o2.cost - o1.cost;
            }
        });

        for (int i = 0; i < servers.size(); i++) {
            Server server = servers.get(i);
            for (int j = 0; j < clients.size(); j++) {
                Client client = clients.get(j);
                if(!server.isUse && server.band >= client.band && !client.isGet){
                    client.isGet = true;
                    server.isUse = true;
                }
            }
        }

        int val = 0;
        for (Client client : clients) {
            if(client.isGet == true){
                val = val + client.cost;
            }
        }
        return val;
    }

    static class Server{

        // 带宽
        public int band;
        // 是否被分配
        public boolean isUse;
        // 出租这个服务器得到了多少钱
        public int income;
        public Server(int band){
            this.band = band;
        }
    }

    static class Client{
        // 需求带宽
        public int band;
        // 是否获取到服务器
        public boolean isGet;
        // 愿意出多少钱
        public int cost;
        public Client(int band, int cost){
            this.band = band;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // n台服务器
        int n = scanner.nextInt();
        // m个租户
        int m = scanner.nextInt();
        ArrayList<Server> servers = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            servers.add(new Server(scanner.nextInt()));
        }

        for (int i = 0; i < m; i++) {
            clients.add(new Client(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println(maxIncome(servers, clients));
    }
}
