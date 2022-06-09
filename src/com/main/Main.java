package com.main;

import com.helper.*;

class Main {
    public static void main(String[] args) {
        SuperPrivateData data = login("admin", "admin").unwrap();

        System.out.println(data.getSecretName());
        System.out.println(data.getSecretSSN());
    }

    public static Result<SuperPrivateData, LoginFailure> login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            return Result.ok(SuperPrivateData.getInstance());
        } else {
            return Result.err(LoginFailure.WrongCredentials);
        }
    }
}

enum LoginFailure implements Debug<LoginFailure>{
    WrongCredentials;

    @Override
    public Result<String, FormatError> format() {
        String formattedString;

        switch (this) {
            case WrongCredentials:
                formattedString = "Wrong credentials";
                break;
            default:
                formattedString = "Unknown error";
        }

        return Result.ok(formattedString);
    }
}

class SuperPrivateData {
    private static SuperPrivateData _instance;
    private static String _secretName = "Some Name";
    private static String _secretSSN = "112233445566778899";

    private SuperPrivateData() {
    }

    public static SuperPrivateData getInstance() {
        if (_instance == null) {
            _instance = new SuperPrivateData();
        }
        return _instance;
    }

    public String getSecretName() {
        return _secretName;
    }

    public String getSecretSSN() {
        return _secretSSN;
    }
}