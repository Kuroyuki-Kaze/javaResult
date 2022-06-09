package com.helper;

public enum OptionError implements Debug<OptionError> {
    ValueIsNone;

    @Override
    public Result<String, FormatError> format() {
        String formattedString;

        switch (this) {
            case ValueIsNone:
                formattedString = "Value is None";
                break;
            default:
                formattedString = "Unknown error";
        }

        return Result.ok(formattedString);
    }
}
