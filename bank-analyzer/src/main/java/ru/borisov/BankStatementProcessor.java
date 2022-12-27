package ru.borisov;

import ru.borisov.domain.BankTransaction;
import ru.borisov.transactionfilter.BankTransactionFilter;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {

                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double findMostExpensiveTransactionInMonth(final Month month) {
        List<BankTransaction> filteredTransactions = filterTransactionsByMonth(month);
        double max = Math.abs(filteredTransactions.get(0).getAmount());
        for (int i = 1; i < filteredTransactions.size(); i++) {
            max = Math.max(Math.abs(max), Math.abs(filteredTransactions.get(i).getAmount()));
        }
        return max;
    }

    public double findLeastExpensiveTransactionInMonth(final Month month) {
        List<BankTransaction> filteredTransactions = filterTransactionsByMonth(month);
        double min = Math.abs(filteredTransactions.get(0).getAmount());
        for (int i = 1; i < filteredTransactions.size(); i++) {
            min = Math.min(Math.abs(min), Math.abs(filteredTransactions.get(i).getAmount()));
        }
        return min;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter filter) {

        return bankTransactions.stream()
                .filter(transaction -> filter.test(transaction))
                .collect(Collectors.toList());
    }


    private List<BankTransaction> filterTransactionsByMonth(Month month) {
        List<BankTransaction> filteredTransactions = bankTransactions.stream()
                .filter(t -> t.getDate().getMonth().equals(month))
                .collect(Collectors.toList());

        return filteredTransactions;
    }
}
