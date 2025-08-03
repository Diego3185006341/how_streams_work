package org.example;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Builder

public class Person {
    String name;
    private LocalDate birthDate;
    double salary;
    String gender;
}