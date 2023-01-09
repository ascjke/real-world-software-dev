package ru.borisov;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRule implements Rule {

    private final Condition condition;
    private final Action action;

    @Override
    public void perform(Facts facts) {
        if (condition.evaluate(facts)) {
            action.perform(facts);
        }
    }
}
