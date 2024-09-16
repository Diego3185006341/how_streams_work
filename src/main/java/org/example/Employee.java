package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Employee {
    String name ;
    private LocalDate birthDate;
    double salary;
}
