package cn.wxb.java;

//7. 整数反转，如果反转后溢出则返回0
public class seven {

    public static void main(String[] args) {
//        int num = 2147483647;
        int num = 1463847412;
        System.out.println(test(num));
    }

    private static int test(int num){
        if (num < 10){
            return num;
        }
        int rev = 0;

        while(num != 0){
            int a = num % 10;
            num = num /10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && a > 8)){
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && a < 8)){
                return 0;
            }
            rev = rev * 10 + a;
        }

        return rev;
    }
}
