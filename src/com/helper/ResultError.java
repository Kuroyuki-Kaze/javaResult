package com.helper;

public enum ResultError implements Debug<ResultError> {
    ResultIsOk;

    @Override
    public Result<String, FormatError> format() {
        String formattedString;

        switch (this) {
            case ResultIsOk:
                formattedString = "Result is Ok";
                break;
            default:
                formattedString = "Unknown error";
        }

        return Result.ok(formattedString);
    }
}
