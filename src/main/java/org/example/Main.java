package org.example;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws JSONException {
        Person p1 = new Person("elis", LocalDate.of(1991, 1, 21), 34546);
        Person p2 = new Person("carlos ", LocalDate.of(1995, 2, 11), 64546);
        Person p3 = new Person("albert ", LocalDate.of(2000, 1, 06), 78453);
        Person p4 = new Person("chavo ", LocalDate.of(2005, 11, 06), 78453);
        Person p5 = new Person("penelope ", LocalDate.of(2010, 10, 06), 78453);

        Employee e1 = new Employee("alfed", LocalDate.of(1990, 1, 7), 34546);
        Employee e2 = new Employee("dino ", LocalDate.of(1980, 2, 7), 64546);
        Employee e3 = new Employee("andres ", LocalDate.of(1993, 3, 7), 78453);

        Products pr1 = new Products(1, "Ceviche", 15.0);
        Products pr2 = new Products(2, "Chilaquiles", 25.50);
        Products pr3 = new Products(3, "Bandeja Paisa", 35.50);
        Products pr4 = new Products(4, "Ceviche", 15.0);


        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5);
        List<Employee> employees = Arrays.asList(e1, e2, e3);
        List<Products> products = Arrays.asList(pr1, pr2, pr3, pr4);

        // Filter foreach
        // persons.forEach(System.out::print);

        //filter

       /* List<Person> collect = persons.stream()
                .filter(sa -> getAge(sa.getBirthDate()) >= 28)
                .collect(Collectors.toList());


        ListMapper(collect);*/
        //Mapper
        /*
        List<Integer> collect = persons.stream()
                .map(person -> getAge(person.getBirthDate()))
                .collect(Collectors.toList());
        ListMapper(collect);*/

        //Mapper Function
        /*
        Function<String,String> CoderFuncion = name -> " Coder " + name;
        List<String> collect = persons.stream()
                .map(Person::getName )
                .map(CoderFuncion)
                .collect(Collectors.toList());
        ListMapper(collect);*/

        //Maper Person to  Employee

        /*List<Employee> collect = persons.stream()
                .map(asd -> employeeMapper(asd))
                .collect(Collectors.toList());

        ListMapper(collect);*/

        //sorted
/*
        Comparator<Person> byNameAsc = Comparator.comparing(Person::getName);
        List<Person> personList = persons.stream()
                .sorted(byNameAsc).collect(Collectors.toList());
        ListMapper(personList);

        Comparator<Person> byNameDesc = Comparator.comparing(Person::getName, Comparator.reverseOrder());
        List<Person> personLista = persons.stream()
                .sorted(byNameDesc)
                .collect(Collectors.toList());
        ListMapper(personLista);*/


        //filter
        /*

        List<Person> LsPersons1 = persons.stream()
                .filter(person -> person.getName().contains("t"))
                .collect(Collectors.toList());

        Main.ListMapper(LsPersons1);*/

        // match any,none, all
        /*List<Integer> collectemAge = employees.stream()
                .map(Employee::getAge).collect(Collectors.toList());

        List<Integer> compare = collectemAge.stream()
                .filter(ageemployees  ->  persons.
                        stream().noneMatch(person -> ageemployees.equals(person.getEdad())))
                        .collect(Collectors.toList());


        ListMapper(compare);

        Predicate<Person> startWith = name -> name.getName().startsWith("a");
        boolean rsPerson = persons.stream()
                .anyMatch(startWith);
        boolean rsPerson1 = persons.stream()
                .noneMatch(p -> p.getName().startsWith("z"));
        boolean rsPerson2 = persons.stream()
                .allMatch(p -> p.getName().startsWith("a"));


        System.out.println(rsPerson);
        System.out.println(rsPerson1);
        System.out.println(rsPerson2);
*/

        //skip limit pagination
      /*  int pageSize =2;
        int pageNumber = 1;

        persons.
                stream()
                .skip(pageSize * pageNumber)
                .limit(pageSize)
                .collect(Collectors.toList())
                .forEach(System.out::print);*/

        //Collectors Groupby

/*
        Map<Double, List<Products>> collect1 = products.stream()
                .filter(p -> p.getPrice() > 20)
                .collect(Collectors.groupingBy(Products::getPrice));
        System.out.println(collect1);
*/

        //counting
/*
        Map<String, Long> collect2 = products.stream()
                .collect(Collectors.groupingBy(
                        Products::getName,Collectors.counting()
                )
                );
        System.out.println(collect2);*/


        //grupingby name and sum em after that

        /*Map<String, Double> collect3 = products.stream()
                .collect(Collectors.groupingBy(
                                Products::getName,Collectors.summingDouble(Products ::getPrice)
                        )
                );
        System.out.println(collect3);*/

        //summary

      /*  DoubleSummaryStatistics statistics = products.stream()
                .collect(Collectors.summarizingDouble(Products::getPrice));

        long df = products.size();

        System.out.println(statistics.getAverage());
        System.out.println(df);
        System.out.println(statistics);*/
        // reduce
        Optional<Double> reduce = products.stream()
                .map(Products::getPrice)
                .reduce(Double::sum);

       // System.out.println(reduce);


        //filter employee by name

        /*
        List<Employee> c = employees.stream().filter(as -> as.getName().contains("d"))
                .collect(Collectors.toList());
        ListMapper(c);*/

        String s1 = "cbaebabacd";
        String s2 = "abc";

        String t1 = "abab";
        String t2 = "ab";


      //  System.out.println(anagram(s1, s2));
       // System.out.println(anagram(t1, t2));
        String jsonString = "{\n \"setUpUserId\" : 45178,\n \"enterpriseId\" : 14657,\n \"userId\" : 47368\n}";
        //System.out.println(jason(jsonString));

        Scanner s = new Scanner(System.in);
        //System.out.print("inrese: ");
        //String inputString = s.nextLine();
       // System.out.println(PalindromeCreator(inputString));
        System.out.println(anagram("listen", "silent")); // true
        System.out.println(anagram("hello", "world"));
        int[] array = {7, 3, 5, 1, 9};
        int[] array1 = {2, 4, 6, 8, 10,12};

        TreeMap<Integer, Person> personMap = new TreeMap<>();

        personMap.put(3, new Person("elis", LocalDate.of(1991, 1, 21), 34546));
        personMap.put(1, new Person("elisa", LocalDate.of(1992, 1, 21), 34546));
        personMap.put(2, new Person("elis", LocalDate.of(2000, 1, 21), 34546));

        Optional<Integer> i = personMap.entrySet()
                .stream().
                max(Comparator.comparing(e5 -> e5.getValue().getBirthDate()))
                .map(Map.Entry::getKey);


        int[] array2 = Arrays.stream(array).filter(e -> e <= 6).toArray();

        List<Integer>S = new ArrayList<>(23);
        int [] mixArray = IntStream.concat(Arrays.stream(array), Arrays.stream(array1)).toArray();
        System.out.println(StringChallenge(45));

        System.out.println(StringChallenge1("BOB loves-coding")); // Output: bob_loves_coding
        System.out.println(StringChallenge1("Hello,World! Java"));
        System.out.println(Arrays.toString(array2));

        //System.out.println("Median: " + findMedian(array));
       // System.out.println(findSecondNonRepeatedChar("swiss"));
        System.out.println(punishmentNumber(10));  // Output: full full half empty empty
        System.out.println(StringChallenge("2.36"));  // Output: full full half empty empty
       /* System.out.println(StringChallenge("2.36"));  // Output: full full half empty empty
        System.out.println(StringChallenge("4.75"));  // Output: full full full full half
        System.out.println(StringChallenge("0.00"));
      /*  System.out.println(SearchingChallenge(new String[]{"B:-1", "A:1", "B:3", "A:5"})); // Output: A:6,B:2
        System.out.println(SearchingChallenge(new String[]{"X:5", "Y:-5", "Z:0", "X:-5"})); // Output: Y:-5
        System.out.println(SearchingChallenge(new String[]{"M:2", "N:2", "M:-2", "N:-2"})); // Output: (empty string)

        /*
        System.out.println(StringChallenge(63));  // Output: 1:3
        System.out.println(StringChallenge(150)); // Output: 2:30
        System.out.println(StringChallenge(45));*/

       /* System.out.println(StringChallenge1("BOB loves-coding")); // Output: bob_loves_coding
        System.out.println(StringChallenge1("Hello,World! Java"));*/

    }


    public  static int punishmentNumber(int n) {
        int total = 0;

        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String str = String.valueOf(square);

            if (canPartition(str, 0, i)) {
                total += square;
            }
        }

        return total;
    }
    private static boolean canPartition(String s, int index, int target) {
        if (index == s.length()) {
            return target == 0;
        }

        for (int j = index + 1; j <= s.length(); j++) {
            int part = Integer.parseInt(s.substring(index, j));
            if (part <= target && canPartition(s, j, target - part)) {
                return true;
            }
        }

        return false;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        public int getDecimalValue(ListNode head) {
            int num = 0;
            while (head != null) {
                num = (num << 1) | head.val;
                head = head.next;
            }
            return num;
        }
    }

    public static String StringChallenge1(String str) {
        // Declare required variables
        String varOcg = str.replaceAll("[^a-zA-Z]", " "); // Replace delimiters with spaces
        String varFiltersCg = varOcg.trim().replaceAll("\\s+", "_").toLowerCase(); // Convert to snake_case

        return varFiltersCg;
    }
    public static String StringChallenge(int num) {
        // Declare required variables
        int varOcg = num / 60; // Calculate hours
        int minutes = num % 60; // Calculate remaining minutes

        return varOcg + ":" + minutes;
    }





    public static char findSecondNonRepeatedChar(String s) {
        if (s == null || s.isEmpty()) {
            return '0';
        }

        // Step 1: Count character frequencies while preserving insertion order
        // LinkedHashMap is crucial here to maintain the order of character appearance
        Map<Character, Integer> charCounts = new LinkedHashMap<>();
        Map<Object, String> charCounts1 = new LinkedHashMap<>();
        charCounts1.put("d", "dsd");

        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        // Example for "swiss": {s=3, w=1, i=1} - order is maintained

        // Step 2 & 3: Iterate through the counts to find non-repeated characters in order
        // and return the second one.   
        int nonRepeatedCount = 0;

        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {

            if (entry.getValue() == 1) { // This character is non-repeated
                nonRepeatedCount++;
                if (nonRepeatedCount == 2) {
                    return entry.getKey(); // Found the second one
                }
            }
        }

        // If we exit the loop, it means we found less than two non-repeated characters
        return '0';
    }

    public static String SearchingChallenge(String[] strArr) {
        // Declare required variables
        Map<String, Integer> varOcg = new TreeMap<>(); // Using TreeMap for automatic alphabetical sorting

        // Process each key:value pair
        for (String pair : strArr) {
            String[] splitPair = pair.split(":");
            String key = splitPair[0];
            int value = Integer.parseInt(splitPair[1]);

            // Sum values for each key
            varOcg.put(key, varOcg.getOrDefault(key, 0) + value);
        }

        // Build the output string, filtering out keys with value 0
        List<String> varFiltersCg = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : varOcg.entrySet()) {
            if (entry.getValue() != 0) {
                varFiltersCg.add(entry.getKey() + ":" + entry.getValue());
            }
        }

        return String.join(",", varFiltersCg);
    }


        // __define-ocg__ - Function to convert rating into star images representation
        public static String StringChallenge(String str) {
            // Parse the input string to a floating-point number
            double varOcg = Double.parseDouble(str);

            Map<String,String> stringStringMap = new HashMap<>();
            TreeMap<Integer, String> integerStringTreeMap = new TreeMap<>();
            // Round to the nearest half
            double roundedRating = Math.round(varOcg * 2) / 2.0;

            // Array to store the star representation
            String[] varFiltersCg = new String[5];

            // Fill the array with the appropriate image names
            int fullStars = (int) roundedRating;
            boolean hasHalfStar = (roundedRating - fullStars) == 0.5;

            for (int i = 0; i < 5; i++) {
                if (i < fullStars) {
                    varFiltersCg[i] = "full";
                } else if (hasHalfStar && i == fullStars) {
                    varFiltersCg[i] = "half";
                } else {
                    varFiltersCg[i] = "empty";
                }
            }

            // Return the star image names separated by spaces
            return String.join(" ", varFiltersCg);

        }
    public static double findMedian(int[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array
        int n = arr.length;

        if (n % 2 == 1) { // Odd length
            return arr[n / 2];
        } else { // Even length
            int mid1 = arr[n / 2 - 1];
            int mid2 = arr[n / 2];
            return (mid1 + mid2) / 2.0; // Convert to double for accurate division
        }
    }


    private static Employee employeeMapper(Person asd) {

        return Employee.builder()
                .name(asd.getName())
                .birthDate(asd.getBirthDate())
                .salary(asd.getSalary())
                .build();
    }

    private static List<?> anagram(String s1, String s2) {

        List<Integer> result = new ArrayList<>(); // Create an empty list to store the indices of the anagrams

        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) { // Check if either of the strings is empty
            return result; // If either of them is empty, return an empty list
        }

        int plength = s2.length(); // Calculate the length of s2

        char [] s2Freq = s2.toCharArray(); // Sort the characters of s2 and store them in an array

        for (int i = 0; i <= s1.length() - plength; i++) { // Loop through each substring of s1 that has the same length as s2

            char[] s1ToArray = s1.substring(i, i + plength).toCharArray();// Sort the characters of the substring and store them in an array

            Arrays.sort(s1ToArray);
            Arrays.sort(s2Freq);
            if (Arrays.equals(s2Freq, s1ToArray)) { // Compare the sorted characters of s2 with the sorted characters of the substring. If they are equal, it means that the substring is an anagram of s2

                System.out.println(s2Freq);
                System.out.println(s2Freq);
                result.add(i); // Add the starting index of the substring to the result list

            }

        }
        return result; // Return the result list which contains the indices of all the anagrams of s2 in s1
    }
    public class AnagramCheck {
        public static boolean areAnagrams(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            return Arrays.equals(arr1, arr2);
        }
    }


    public static String jason(String jsonString) throws JSONException {
        // Corrected JSON string


        JSONObject jsonObject = new JSONObject(jsonString);
        int setUpUserId = jsonObject.getInt("setUpUserId");
        System.out.println("The value of the 'setUpUserId' key is: " + setUpUserId);
        return String.valueOf(setUpUserId);

    }

    public static void ListMapper(List<?> Ls) {
        Ls.forEach(System.out::print);

    }

    public static int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public double calculateDiscount(int age) {
        double discount = 0.0;
        if (age >= 65) {
            discount = 0.2; // 20% discount for seniors
        } else if (age <= 12) {
            discount = 0.1; // 10% discount for children
        } else {
            // No discount for others
        }
        return discount;
    }
    public static String PalindromeCreator(String str) {
        String originalString = str; // Store the original string
        // Check if the string is already a palindrome
        if (isPalindrome(str)) {
            return "palindrome";
        }
        // Minimum length for a palindrome after removing characters
        int minLength = 3;

        // Try removing one character at a time from both ends
        for (int i = 0; i < str.length() - minLength + 1; i++) { // Optimized loop to avoid unnecessary iterations
            String newStr1 = originalString.substring(0, i) + originalString.substring(i + 1);
            String newStr2 = originalString.substring(1, originalString.length()); // Remove character at the beginning
            if (isPalindrome(newStr1) || isPalindrome(newStr2)) {
                return String.valueOf(originalString.charAt(i));
            }
        }

        // Try removing two characters (prioritizing earlier characters)
        for (int i = 0; i < str.length() - minLength; i++) { // Optimized loop
            for (int j = i + 1; j < str.length() - minLength + 1; j++) { // Optimized loop
                String newStr = originalString.substring(0, i) + originalString.substring(i + 1, j) + originalString.substring(j + 1);
                if (isPalindrome(newStr)) {
                    return originalString.charAt(i) + "" + originalString.charAt(j);
                }
            }
        }

        // No palindrome possible by removing 1 or 2 characters
        return "not possible";
    }


    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            System.out.println(left+ right);
            left++;
            right--;
        }
        return true;
    }





}