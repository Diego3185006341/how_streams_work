package org.example;

import javax.naming.LinkException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {

    private static ExpetionClass expetionClass;
    public static void main(String [] args) throws ExpetionClass {


       // System.out.println(possibleExeption(-1));

        for(int i = 0; i < 10; i++){
            System.out.println(fibonachi(i));
        }



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
    public static int median(int [] list){

        int length = list.length;
        

        return list[ length / 2];


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










}
