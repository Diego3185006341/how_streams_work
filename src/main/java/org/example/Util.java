package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Util {



    public static List<Employee> Result() {
        Employee e1 = new Employee("alfed", LocalDate.of(1990, 1, 7), 34546);
        Employee e2 = new Employee("dino ", LocalDate.of(1980, 2, 7), 64546);
        Employee e3 = new Employee("andres ", LocalDate.of(1993, 3, 7), 78453);

        return Arrays.asList(e1,e2,e3);
    }

    public static List<Integer> Result1() {
        return Arrays.asList(4,8,15,16,23,42);
    }


}
