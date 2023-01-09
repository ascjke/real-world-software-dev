package ru.borisov;

@FunctionalInterface
public interface Condition {
    boolean evaluate(Facts facts);
}
