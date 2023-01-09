import org.junit.Test;
import ru.borisov.*;

import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class BusinessRuleEngineTest {

//    final Condition condition = (Facts facts) -> "CEO".equals(facts.getFact("jobTitle"));
//    final Action action = (Facts facts) -> {
//        var name = facts.getFact("name");
//        Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
//    };
//    final Rule rule = new DefaultRule(condition, action);

    Rule rule = RuleBuilder
            .when(facts -> "CEO".equals(facts.getFact("jobTitle")))
            .then(facts -> {
                var name = facts.getFact("name");
                Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
            });

//    @Test
//    public void shouldHaveNoRulesInitially() {
//        final Facts facts = new Facts();
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//
//        assertEquals(0, businessRuleEngine.count());
//    }
//
//    @Test
//    public void shouldAddTwoActions() {
//        final Facts env = new Facts();
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(env);
//
//        businessRuleEngine.addAction(facts -> {
//            Stage dealStage = Stage.valueOf(facts.getFact("stage"));
//            var amount = Double.parseDouble(facts.getFact("amount"));
//            var forecastedamount = amount * switch (dealStage) {
//                case LEAD -> 0.2;
//                case EVALUATING -> 0.5;
//                case INTERESTED -> 0.8;
//                case CLOSED -> 1;
//            };
//            facts.addFact("forecastedAmount", String.valueOf(forecastedamount));
//        });
//
//        assertEquals(1, businessRuleEngine.count());
//    }
//
//    @Test
//    public void shouldExecuteOneAction() {
//        final Facts facts = new Facts();
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        final Action mockAction = mock(Action.class);
//
//        businessRuleEngine.addAction(mockAction);
//        businessRuleEngine.run();
//
//        verify(mockAction).execute(facts);
//    }
//
//    @Test
//    public void shouldPerformActionWithFacts() {
//        final Action mockAction = mock(Action.class);
//        final Facts mockfacts = mock(Facts.class);
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockfacts);
//
//        businessRuleEngine.addAction(mockAction);
//        businessRuleEngine.run();
//
//        verify(mockAction).execute(mockfacts);
//    }
}
