package ru.borisov;

@FunctionalInterface
public interface Rule {
    void perform(Facts facts);
}
