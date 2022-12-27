package ru.borisov;

import ru.borisov.parser.BankStatementCSVParser;
import ru.borisov.parser.BankStatementParser;

public class MainApplication {

    public static void main(String[] args) throws Exception {

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        bankStatementAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);

    }
}
