package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {

    private static ExpetionClass expetionClass;
    public static Util util;

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
//        System.out.println(secondNonRepited("asswsdff"));
//     System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
//        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
//        System.out.println(maxProfit(new int[]{7, 1, 4, 5,3,2}));
 //        System.out.println(max());
 //        System.out.println(lengthOfLongestSubstring1("abcbbcbb"));
//         System.out.println(Arrays.toString(productExceptSelf(new int[]{2, 3, 4, 5})));
//        System.out.println(maxAmountOfNumberFound(new int[]{7,7, 1, 4, 5,3,2}));
        int nbPersons = 3;

        List<String> ingredients = Arrays.asList(
                "2 eggs",
                "1 tomato",
                "100 rice",
                "50 chicken"
        );
//        System.out.println(adjustQuantities(nbPersons, ingredients));

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
/*       System.out.println(isArmstrong(153));
       System.out.println(maximum("yuiopphh"));
       System.out.println(anInt(new int[]{23,23,4,6}));*/
       System.out.println(anInt(new int[]{23,23,4,6}));
       System.out.println( mostCommonFirstLetter(Util.Result()));
        slidingWindowAverage();
        System.out.println(longestWordFinder("The quick, brown fox jumped over the lazy dog!"));
        mostFrequentWord();
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

//        System.out.println(howManyWords(2,"bad", new String[]{"The_video_is_BAD", "BAD_bad_bad"}));
//
//        System.out.println(largerstString( new String[]{"SDF","DF"}));
//        System.out.println(swap());
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
           String s = map.keySet().stream().max(Comparator.comparing(String::length)).orElse("#");

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
    public  static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> sa = new ArrayList<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for(var entry: map.entrySet()) sa.add(entry.getValue().toString());




        return new ArrayList<>(map.values());
    }
    public static int compress(char[] chars){
        int i = 0;
        int writer = 0;
                while(i < chars.length){

                    char currentChar = chars[i];

                    int count = 0;
                    while(i < chars.length && currentChar == chars[i]){

                        count ++;
                        i++;


                    }
                    chars[writer++] = currentChar;

                    if(count > 1){

                        for(var c : String.valueOf(count).toCharArray())
                            chars[writer++] = c;

                    }


                }


              return writer;


    }

    public static Map.Entry<Character, Long> maximum(String word){



        return  word.chars().mapToObj(z -> (char) z).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().skip(1).max(Map.Entry.comparingByValue()).orElse(new AbstractMap.SimpleEntry<>('g', 3L));


    }

    public boolean palidrom(String word1){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(word1);

        return stringBuilder.reverse().toString().equals(word1);


    }

    public static String anInt(int [] nums){

        Map<Integer, Integer> map = new HashMap<>();

        for(var num : nums)
            map.put(num, map.getOrDefault(num,0)+ 1);
        Map.Entry<Integer, Integer> integerIntegerEntry = map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(new AbstractMap.SimpleEntry<>(23, 3));

        return "Number" + integerIntegerEntry.getKey() + "times" + integerIntegerEntry.getValue();
    }


    public static String mostCommonFirstLetter(List<Employee> employeeList){

        Map.Entry<Character, Long> a = employeeList.stream().map(employee -> employee.getName().charAt(0))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).orElse(new AbstractMap.SimpleEntry<>('a', 3L));
        return "letter: " + a.getKey() + " times: " + a.getValue();

    }
    public static void slidingWindowAverage(){

        int window = 3;
        List<Integer> input = Util.Result1();
        List<Double> list = IntStream.range(0, (input.size() - (window - 1)))
                .mapToObj(i -> input.subList(i, i + window))
                .map(w -> w.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0)
                ).toList();
        System.out.println(list);

    }

    public static String longestWordFinder(String word){


        return Arrays.stream(word.toLowerCase().split("\\W+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .keySet().stream().max(Comparator.comparing(String::length))
                .orElse("");



    }

    public static void mostFrequentWord(){

        String words = "Java is the best nothing like Java, is Object oriented and the funniest thing is easy";
        Map<String, Long> map = new HashMap<>();
        for(String word : words.split("\\W+")){
            map.put(word, map.getOrDefault(word, 0L) + 1);
        }
        List<Map.Entry<String, Long>> list = map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3).toList();

        System.out.println(list);
        list.forEach( e -> {
            System.out.print( " word: " + e.getKey() + " times: " + e.getValue());
        });

    }









}







