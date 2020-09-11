package leetcode.str;

public class LC0008 {

    public static int myAtoi(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        str = str.replaceAll(" ", "");
        if(str.length()==0){
            return 0;
        }
        char[] chars = str.toCharArray();
        if((chars[0]>'9'|| chars[0]<'0') && chars[0] != '-' && chars[0] != '+'){
            return 0;
        }

        long ret = 0;
        long flag = 1;
        int bak = -1;
        for(int i = 0; i<chars.length;i++){
            if(i==0){
                if(chars[i]=='-'){
                    flag=-1;
                }
                if(chars[i]=='+'){
                    flag=1;
                }
            }

            if(chars[i]=='.'){
                int c = -1;
                for (int j = i+1; j < chars.length; j++) {
                    if(chars[j] >= '0' && chars[j] <= '9'){
                        c = chars[j] - '0';
                        break;
                    }
                }
                if(c>=0 && c<=9){
                    if(c >= 5){
                        bak = 1;
                    } else {
                        bak = 0;
                    }
                }
            }
            if(bak!=-1){
                break;
            }
            if(chars[i] >= '0' && chars[i] <= '9'){
                ret = ret*10 + (chars[i]-'0');
            }
        }
        ret=flag*ret;
        if(ret > ~(1<<31)){
            return ~(1<<31);
        }else if(ret < 1<<31){
            return 1<<31;
        }
        return (int)ret + (Math.max(bak, 0));
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("3.14159"));
    }
}
