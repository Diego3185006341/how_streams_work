package org.example;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main2 {

    private static ExpetionClass expetionClass;

    static Map<String, Long> orders = new ConcurrentHashMap<>();

    static void processOrders() {
        for (String city : orders.keySet()){
            for (int i = 0 ; i < 50; i ++){
                Long oldOrder = orders.get(city);
                orders.compute(city, (k, v) -> v + 1);
            }

        }
    }
    public static void main(String [] args) throws ExpetionClass, InterruptedException {


       // System.out.println(possibleExeption(-1));

//        for(int i = 0; i < 10; i++){
//            System.out.println(fibonachi(i));
        orders.put("Bogota", 0l);
        orders.put("Cartagena", 0l);
        orders.put("Cali", 0l);
        orders.put("Medellin", 0l);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(Main2::processOrders);
        executorService.submit(Main2::processOrders);
        executorService.submit(Main2::processOrders);
        executorService.submit(Main2::processOrders);



        executorService.awaitTermination(1, TimeUnit.SECONDS);

        executorService.shutdown();
        System.out.println(orders);
        MyTask t1 = new MyTask("Thread A");
        MyTask t2 = new MyTask("Thread B");

        t1.start(); // starts Thread A
        t2.start(); // starts Thread B


//        }
       int[] nums = {2, 7, 11, 15};
       int target = 9;
//      System.out.println(Arrays.toString(twoSum(nums, target)));
//      System.out.println(replace("hello e"));
//      System.out.println(removeDuplicated(new int[]{34,34,45}));
//      System.out.println(wordsInString("hello great question"));
      System.out.println(digits(453456));
      System.out.println(primenumber(7));
      System.out.println(divisors(7));
       // int[] nums = {10, 20, 30, 40};
       // System.out.println(median(nums));

    }

    public  static String possibleExeption(int number) throws ExpetionClass {


        int s [] ={34,35};
        int i [] ={34};

        OptionalInt max = Arrays.stream(s).max();


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

    public static String replace(String word){

        return word.replace(" ","");

    }

    public static boolean isPalidrome(String word){
       StringBuilder stringBuffer = new StringBuilder();
       stringBuffer.append(word);

       return word.contentEquals(stringBuffer.reverse());


    }

    public static  boolean isPalidrome(int word){
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(word);
        String wordString  = String.valueOf(word);

        return wordString.contentEquals(stringBuffer.reverse());


    }

    public static Set<Integer> removeDuplicated(int [] word){

        Set<Integer> gf = new HashSet<>();
        for (int wordTo : word){

            gf.add(wordTo);
        }
        return gf;

    }
    public static Map<?, ?> wordsInString(String words){
        Map<String, Integer> map = new TreeMap<>();


        for (String word : words.split("\\W+"))
            map.put(word, map.getOrDefault( word, 0)+ 1);

        return map;
    }

    public static int digits(int digits){
        return String.valueOf(Math.abs(digits)).length();

    }

    public static boolean primenumber(int number){

        if(number <= 1) return false;

        for(int i = 2; i < number; i++){

            if(number % i == 0) return false;


        }
        return true;

    }

    public static List<Integer> divisors(int number){
        List<Integer> integers = new ArrayList<>();
        for(int i = 1;i <= number;i ++)
            if(number % i == 0)
                integers.add(i);


        return integers;

    }






}
