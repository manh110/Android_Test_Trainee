package com.example.test.viewModel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.lifecycle.ViewModel;

import com.example.test.Interface.LoginResultCallbacks;
import com.example.test.Model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private LoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(LoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
        this.user = new User();
    }

    //Phương thức lấy email từ giao diện
    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View v) {
        int errorCode = user.isValidData();
        if (errorCode == 0) {
            loginResultCallbacks.onError("Email can't empty!");
        } else if (errorCode == 1){
            loginResultCallbacks.onError("Your Email is invalid!");
        }else if(errorCode == 2){
            loginResultCallbacks.onError("Password lenght must more than 6!");
        }else if (errorCode == 3){
            loginResultCallbacks.onError("Password contain at lest 1 number and 1 special character!");
        }else {
            loginResultCallbacks.onSuccess("Login success!");
        }
    }


}
