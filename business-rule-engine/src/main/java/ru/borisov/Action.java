package ru.borisov;

@FunctionalInterface
public interface Action {
    void perform(Facts facts);
}
