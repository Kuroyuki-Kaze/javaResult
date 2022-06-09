package com.helper;

public enum FormatError implements Debug<FormatError>{
    FormatFailed;

    @Override
    public Result<String, FormatError> format() {
        String formattedString;

        switch (this) {
            case FormatFailed:
                formattedString = "Format failed";
                break;
            default:
                formattedString = "Unknown error";
        }

        return Result.ok(formattedString);
    }
}