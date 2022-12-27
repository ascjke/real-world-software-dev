package ru.borisov.dataexport;

import ru.borisov.domain.SummaryStatistics;

public interface Exporter {
    String export(SummaryStatistics summaryStatistics);
}
