package com.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author tqx
 * @CreateDate 2021/4/1
 * @Description 两个数组的交集
 */
public class Intersect {
    public static void main(String[] args) {
        //int[] arr1 = {1, 2, 2, 1};
        //int[] arr2 = {2, 2};
        int[] arr1={4,9,5};
        int[] arr2={9,4,9,8,4};
        int[] re=intersect(arr1,arr2);

        for (int i=0;i<re.length;i++){
            System.out.println(re[i]);
        }
    }

    public static int[] intersect(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            Integer num1 = map.get(arr1[i]);
            map.put(arr1[i], (num1 == null) ? 1 : ++num1);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int j = 0; j < arr2.length; j++) {
            Integer num2 = 0;
            //判断是否相等
            if (map.containsKey(arr2[j]) && (num2 = map.get(arr2[j]))>0) {
                arrayList.add(arr2[j]);
                map.put(arr2[j],--num2);
            }

        }
        int[] in=new int[arrayList.size()];
        int e=0;
        for(int a:arrayList){
            in[e++]=a;
        }
        return in;
    }
}
