package ru.borisov.transactionfilter;

import ru.borisov.domain.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(BankTransaction bankTransaction);
}
