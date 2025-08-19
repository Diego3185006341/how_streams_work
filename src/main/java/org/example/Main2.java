package org.example;

import javax.naming.LinkException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {

    private static ExpetionClass expetionClass;
    public static void main(String [] args) throws ExpetionClass {


       // System.out.println(possibleExeption(-1));

//        for(int i = 0; i < 10; i++){
//            System.out.println(fibonachi(i));
//        }
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        System.out.println(Arrays.toString(twoSum(nums, target)));
        int[] nums = {10, 20, 30, 40};
        System.out.println(median(nums));

    }

    public  static String possibleExeption(int number) throws ExpetionClass {


        int s [] ={34};
        int i [] ={34};


        int r [] = IntStream.concat(Arrays.stream(s), Arrays.stream(i)).toArray();

        if (number < 0){

            throw new ExpetionClass("negative number");

        }

       return  String.valueOf(number);

    }
    public static double median(int [] list){
        Arrays.sort(list);
        int length = list.length;
        int meadian1 = 0;
        int meadian2 = 0;


        if(length % 2 == 0) {
            meadian1 = list[length / 2 - 1];
            meadian2 = list[length / 2];
            return (meadian1 + meadian2) / 2.0;
        }

        else{
            return list[ length / 2];
        }



    }

    public  static int fibonachi(int tems){

        int a = 0, b = 1;
        ;
        for(int i = 0; i < tems; i++){

            int next = a + b;

            a = b;
            b = next;

        }
        return  b ;




    }




    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }





}
