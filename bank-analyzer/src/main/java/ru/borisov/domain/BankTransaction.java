package ru.borisov.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;
}