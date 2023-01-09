package ru.borisov;


import java.util.ArrayList;
import java.util.List;

public class BusinessRuleEngine {

    private final List<Rule> rules;
    private final Facts facts;


    public BusinessRuleEngine(final Facts facts) {
        this.rules = new ArrayList<>();
        this.facts = facts;
    }

    public void addRule(final Rule rule) {
        rules.add(rule);
    }


    public void run() {
        rules.forEach(action -> action.perform(facts));
    }
}
