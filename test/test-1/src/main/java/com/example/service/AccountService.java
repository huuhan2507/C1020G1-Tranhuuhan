package com.example.service;

import com.example.model.Account;
import org.springframework.stereotype.Repository;


public interface AccountService {
    void changePassword(Account account, String oldPassword, String newPassword, String confirmPassword);

    Account findAccountByAccountName(String accountName);

    boolean checkChangePassword(Account account,String oldPassword, String newPassword, String confirmPassword);
}
