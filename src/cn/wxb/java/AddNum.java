package cn.wxb.java;

import java.util.HashMap;

public class AddNum {


    public static void main(String[] args) {
        int[] arr = {1,3,6,7,18,29,31,44,56};
        int target = 32;
        int[] ret =addNum2(arr, target);
        System.out.println("******* ret = " + ret[0] + " , " + ret[1]);
    }

    //1.两个数相和
    private static int[] addNum(int[] arr, int target){
        int[] ret = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if (map.containsKey(target - arr[i])){
                ret[0] = map.get(target-arr[i]);
                ret[1] = i;
                break;
            } else {
                map.put(arr[i], i);
            }
        }
        return ret;
    }

    private static int[] addNum2(int[] arr, int target){
        int[] ret = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean flag =false;
        for(int i = 0; i < arr.length-1; i++){
            for(int j =i+1;  j < arr.length; j++){
                if (arr[i] + arr[j] == target){
                    ret[0] = i;
                    ret[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        return ret;
    }
}
