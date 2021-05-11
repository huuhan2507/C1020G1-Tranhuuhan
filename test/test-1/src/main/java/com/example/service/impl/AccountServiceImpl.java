package com.example.service.impl;

import com.example.model.Account;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void changePassword(Account account, String oldPassword, String newPassword, String confirmPassword) {
        if (checkChangePassword( account,oldPassword,newPassword,confirmPassword )){
            accountRepository.changePassword( account.getAccountId(), newPassword  );
        }
    }

    @Override
    public Account findAccountByAccountName(String accountName) {
        return accountRepository.findAccountByAccountName( accountName );
    }

    @Override
    public boolean checkChangePassword(Account account , String oldPassword, String newPassword, String confirmPassword) {
            return !oldPassword.equals( newPassword ) && newPassword.equals( confirmPassword );
    }
}
