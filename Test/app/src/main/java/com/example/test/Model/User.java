package com.example.test.Model;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;

import androidx.annotation.NonNull;

import java.util.regex.Pattern;

public class User extends BaseObservable {
    @NonNull
    private String email, password;
    private boolean checkValueCheck;

    public User() {
    }

    public User(@NonNull String email, @NonNull String password) {
        this.email = email;
        this.password = password;
    }

    public boolean isCheckValueCheck() {
        return checkValueCheck;
    }

    public void setCheckValueCheck(boolean checkValueCheck) {
        this.checkValueCheck = checkValueCheck;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int isValidData() {
        final String PASSWORD_PATTERN = "([a-z,A-Z]*[0-9][[a-z,A-Z],[0-9]]*[$&+,:;=?@#|'<>.^*()%!-]" +
                "|[$&+,:;=?@#|'<>.^*()%!-][a-z,A-Z]*[0-9][[a-z,A-Z],[0-9]]*" +
                "|[a-z,A-Z]*[0-9]+[$&+,:;=?@#|'<>.^*()%!-][[a-z,A-Z],[0-9]]*" +
                "|[0-9]+[a-z,A-Z]*[$&+,:;=?@#|'<>.^*()%!-][[a-z,A-Z],[0-9]]*)";
        if (TextUtils.isEmpty(getEmail())) return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) return 1;
        else if (getPassword().length() <= 6) return 2;
        else if (!Pattern.compile(PASSWORD_PATTERN).matcher(getPassword()).matches()) return 3;
        else return -1;
    }
}

