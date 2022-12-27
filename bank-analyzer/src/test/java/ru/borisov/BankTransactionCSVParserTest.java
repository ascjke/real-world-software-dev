package ru.borisov;

import org.junit.Assert;
import org.junit.Test;
import ru.borisov.domain.BankTransaction;
import ru.borisov.parser.BankStatementCSVParser;
import ru.borisov.parser.BankStatementParser;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class BankTransactionCSVParserTest {

    private BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        String line = "30-01-2017,-50,Tesco";

        BankTransaction result = statementParser.parseFrom(line);

        BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), 0.0d);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }

    @Test
    public void parseLinesFromTest() {

        List<String> lines = List.of(
                "30-01-2017,-100,Deliveroo",
                "30-01-2017,-50,Tesco",
                "01-02-2017,6000,Salary",
                "02-02-2017,2000,Royalties"
        );

        List<BankTransaction> expected = List.of(
                new BankTransaction(LocalDate.of(2017, 1, 30), -100, "Deliveroo"),
                new BankTransaction(LocalDate.of(2017, 1, 30), -50, "Tesco"),
                new BankTransaction(LocalDate.of(2017, 2, 1), 6000, "Salary"),
                new BankTransaction(LocalDate.of(2017, 2, 2), 2000, "Royalties")
        );

        Assert.assertEquals(expected, statementParser.parseLinesFrom(lines));
    }
}
