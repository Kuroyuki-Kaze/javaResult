package com.helper;

public class Option<T> {
    private OptionVariant variant;
    private T value;

    private Option(OptionVariant variant, T value) {
        this.variant = variant;
        this.value = value;
    }

    public static <T> Option<T> some(T value) {
        return new Option<T>(OptionVariant.Some, value);
    }

    public static <T> Option<T> none() {
        return new Option<T>(OptionVariant.None, null);
    }

    public Boolean isSome() {
        return variant == OptionVariant.Some;
    }

    public Boolean isNone() {
        return variant == OptionVariant.None;
    }

    public T unwrap() {
        if (isNone()) {
            Panic.panic(OptionError.ValueIsNone);
        }
        return value;
    }

    public T unwrapOr(T orValue) {
        if (isNone()) {
            return orValue;
        }
        return value;
    }

    public T unwrapOrElse(Runnable orElse) {
        if (isNone()) {
            orElse.run();
        }
        return value;
    }
}