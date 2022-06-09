package com.helper;

import java.lang.reflect.InvocationTargetException;

public class Panic<E> {
    @SuppressWarnings("unchecked")
    public static <E> void panic(E error) {
        try {
            throw new RuntimeException(String.format("Program panicked with error %s, message: %s", error.getClass().getSimpleName(), error.getClass().getDeclaredMethod("format") != null ? ((Result<String, FormatError>) error.getClass().getDeclaredMethod("format").invoke(error)).unwrap() : error));
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
