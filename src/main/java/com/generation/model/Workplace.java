package com.generation.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@Getter
@Setter
public class Workplace {
    private static Long id_counter = 1L;
    private Long id;
    private Long stir;
    private Integer salary;
    private String workplace;
    private LocalDate startDate;
    private LocalDate endDate;

    public Workplace(Integer salary, String workplace, LocalDate startDate, LocalDate endDate) {
        this.id = id_counter++;
        this.stir = new Random().nextLong(15000, 100000000);
        this.salary = salary;
        this.workplace = workplace;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
