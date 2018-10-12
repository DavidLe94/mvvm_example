package com.android.haule.android_mvvm_example.viewmodels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.haule.android_mvvm_example.BR;
import com.android.haule.android_mvvm_example.models.User;

/**
 * Created by Hau Le on 2018-10-12.
 */
public class LoginViewModel extends BaseObservable{
    private User user;

    private String successMessage = "Login was successful";
    private String emailIsEmpty = "Email is required";
    private String passwordIsEmpty = "Password is required";
    private String emailDoesNotFormat = "Does not email format";
    private String passLength = "Password must more than 5 character";

    @Bindable
    public String toastMessage = null;

    public String getToastMessage(){
        return toastMessage;
    }

    private void setToastMessage(String toastMessage){
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    public LoginViewModel(){
        user = new User("", "");
    }

    public void afterEmailTextChanged(CharSequence s){
        user.setEmail(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s){
        user.setPassword(s.toString());
    }

    public void loginClicked(){
        switch (user.isInputDataValid()){
            case 1:
                setToastMessage(successMessage);
                break;
            case -1:
                setToastMessage(emailIsEmpty);
                break;
            case -2:
                setToastMessage(passwordIsEmpty);
                break;
            case -3:
                setToastMessage(passLength);
                break;
            case -4:
                setToastMessage(emailDoesNotFormat);
                break;
        }
    }
}
