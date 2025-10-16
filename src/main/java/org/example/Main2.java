package org.example;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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


        //System.out.println(possibleExeption(-1));
        System.out.println(secondNonRepited("asswsdff"));

        int nbPersons = 3;

        List<String> ingredients = Arrays.asList(
                "2 eggs",
                "1 tomato",
                "100 rice",
                "50 chicken"
        );
        System.out.println(adjustQuantities(nbPersons, ingredients));

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

//        executorService.shutdown();
//        System.out.println(orders);
//        MyTask t1 = new MyTask("Thread A");
//        MyTask t2 = new MyTask("Thread B");
//
//        t1.start(); // starts Thread A
//        t2.start(); // starts Thread B


//        }
//        System.out.println(isArmstrong(12));

       int[] nums = {2, 7, 11, 15};
       int target = 9;
//      System.out.println(Arrays.toString(twoSum(nums, target)));
//      System.out.println(replace("hello e"));
//      System.out.println(removeDuplicated(new int[]{34,34,45}));
//      System.out.println(wordsInString("hello great question"));
//      System.out.println(digits(453456));
//      System.out.println(primenumber(7));
//      System.out.println(divisors(7));
       // int[] nums = {10, 20, 30, 40};
       // System.out.println(median(nums));

        System.out.println(howManyWords(2,"bad", new String[]{"The_video_is_BAD", "BAD_bad_bad"}));

        System.out.println(largerstString( new String[]{"SDF","DF"}));
        System.out.println(swap());
    }

    public  static String possibleExeption(int number) throws ExpetionClass {


        int s [] ={34,35};
        int i [] ={34};

        OptionalInt max = Arrays.stream(s).max();


        int r [] = IntStream.concat(Arrays.stream(s), Arrays.stream(i)).toArray();

        if (number < 0){

            throw new NumberFormatException("no correct number");
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

    public static boolean isArmstrong(int num) {
        int original = num;
        int sum = 0;

        // Step 1: count digits
        int digits = String.valueOf(num).length();

        // Step 2: process each digit
        while (num > 0) {
            int digit = num % 10;              // get last digit
            sum += Math.pow(digit, digits);    // raise it to power
            num /= 10;                         // remove last digit
        }

        // Step 3: check
        return sum == original;
    }

    public static char secondNonRepited(String word){

        Map<Character, Integer>  map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int counter = 0;
        for(char w : word.toCharArray()){
            map.put(w, map.getOrDefault(w, 0) +1);

        }
        for (var entry : map.entrySet()){
            if (entry.getValue() == 1){
                counter ++;
            }
            if(counter == 2){
                return entry.getKey();
            }
        }
        return '0';


    }
    public static List<String> adjustQuantities(int nbPersons, List<String> ingredients) {
        // Create a new list to store the adjusted ingredients.
        List<String> adjustedIngredients = new ArrayList<>();

        // Iterate over each ingredient string in the provided list.
        for (String ingredient : ingredients) {
            // Find the position of the first space, which separates the quantity from the name.
            int firstSpaceIndex = ingredient.indexOf(" ");

            // Extract the quantity part of the string.
            String quantityStr = ingredient.substring(0, firstSpaceIndex);
            // Extract the name part of the string.
            String name = ingredient.substring(firstSpaceIndex + 1);

            // Parse the quantity string into an integer.
            int quantity = Integer.parseInt(quantityStr);

            // Calculate the new quantity by multiplying it by the number of people.
            int newQuantity = quantity * nbPersons;

            // Create the new ingredient string with the adjusted quantity.
            String newIngredient = newQuantity + " " + name;

            // Add the new ingredient string to our list.
            adjustedIngredients.add(newIngredient);
        }

        // Return the list of adjusted ingredients.
        return adjustedIngredients;
    }
    public static int howManyWords(int N, String word, String[] comments){
        int result = 0;



        String keyWord = word.toLowerCase();

        for (int i = 0; i < N; i++){
            String lowerCase = comments[i].toLowerCase();

            String[] howMany = lowerCase.split("_");
            for (String wordY : howMany){
                if (wordY.contains(keyWord)) {
                    result++;
                }

            }

        }

        return result;
        }

        public static String largerstString(String[] name){


            return Arrays.stream(name).max(Comparator.comparing(String::length)).orElse("df");

        }

        public static long factorial(int n){

        long result = 1;

        if(n < 0) throw  new IllegalArgumentException();



        for (int i = 2; i <= n; i++)
            result *= i;

        return result;
        }

        public static String swap(){
        int a = 5, b = 10;
        int temp = a;

        a = b;
        b = temp;




        return  "a :" + a + " b: " + b;

        }
        public static int vowels(String word){

        int count = 0 ;
        Set<Character> set = Set.of('a', 'e','i','o','u');

        for (char c : word.toLowerCase().toCharArray()){
            if(set.contains(c)){
                count++;

            }


        }

            return count;

        }








    }







