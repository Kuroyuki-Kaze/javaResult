package com.helper;

public interface Debug<T> {
    Result<String, FormatError> format();
}