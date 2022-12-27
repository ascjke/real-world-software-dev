package ru.borisov.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SummaryStatistics {

    private final double sum;
    private final double max;
    private final double min;
    private final double average;
}
