package com.second.phonebookapp;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {
    private String username;
    private String phonenumber;
    private String groupuser;

    public User(String username, String phonenumber, String groupuser) {
        this.username = username;
        this.phonenumber = phonenumber;
        this.groupuser = groupuser;
    }

    public User() {
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(com.second.phonebookapp.BR.username);
    }

    @Bindable
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        notifyPropertyChanged(com.second.phonebookapp.BR.phonenumber);
    }

    @Bindable
    public String getGroupuser() {
        return groupuser;
    }

    public void setGroupuser(String groupuser) {
        this.groupuser = groupuser;
        notifyPropertyChanged(com.second.phonebookapp.BR.groupuser);
    }
}
