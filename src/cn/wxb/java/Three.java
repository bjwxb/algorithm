package cn.wxb.java;

import java.util.HashSet;
import java.util.Set;

//找出字符串中，最长的不重复子字符串
public class Three {

    public static void main(String[] args) {
        String str = "abcdabcera";
        System.out.println(test((str)));
    }

    private static int test(String str){
        int ret = 0;

        if (null == str || str.isEmpty()){
            return ret;
        }

        int len = str.length();
        int r = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            if (i != 0){
                set.remove(str.charAt(i-1));
            }

            while(r+1 < len && !set.contains(str.charAt(r+1))){
                set.add(str.charAt(r+1));
                r++;
            }

            ret = Math.max(ret, r+1-i);
        }

        return ret;
    }


}
