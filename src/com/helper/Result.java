package com.helper;

public class Result<T, E extends Debug<E>> {
    private ResultVariant variant;
    private Option<T> value;
    private Option<E> error;

    private Result(ResultVariant variant, Option<T> value, Option<E> error) {
        this.variant = variant;
        this.value = value;
        this.error = error;
    }

    public static <T, E extends Debug<E>> Result<T, E> ok(T value) {
        return new Result<T, E>(ResultVariant.Ok, Option.some(value), Option.none());
    }

    public static <T, E extends Debug<E>> Result<T, E> err(E error) {
        return new Result<T, E>(ResultVariant.Err, Option.none(), Option.some(error));
    }

    public Boolean isOk() {
        return variant == ResultVariant.Ok;
    }

    public Boolean isErr() {
        return variant == ResultVariant.Err;
    }

    public T unwrap() {
        if (isErr()) {
            Panic.panic(error.unwrap());
        }

        return value.unwrap();
    }

    public T unwrapOr(T orValue) {
        if (isErr()) {
            return orValue;
        }

        return value.unwrap();
    }

    public T unwrapOrElse(Runnable orElse) {
        if (isErr()) {
            orElse.run();
        }

        return value.unwrap();
    }

    public E unwrapErr() {
        if (isOk()) {
            Panic.panic(ResultError.ResultIsOk);
        }

        return error.unwrap();
    }
}
