package com.example.controller;

import com.example.model.Account;
import com.example.model.User;
import com.example.service.AccountService;
import com.example.service.UserService;
import com.example.service.impl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PutMapping("/user/{idUser}/update/status/{idStatus}")
    public ResponseEntity<?> updateStatus(@PathVariable("idUser") Integer idUser, @PathVariable("idStatus") Integer idStatus) {
        userService.updateStatus( idUser, idStatus );
        return new ;
    }

    @GetMapping("user/{accountName}")
    public ResponseEntity<?> getUserByAccountName(@PathVariable("accountName") String accountName) {
        Account account = accountService.findAccountByAccountName( accountName );
        if (account == null) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
        User user = userService.findUserByAccountId( account.getAccountId() );
        if (user == null) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
        }
        return ResponseEntity.ok( user );
    }

    @PutMapping("/user/{idUser}/update/avatar")
    public void updateAvatar(@PathVariable("idUser") Integer idUser, @RequestParam("image") String image,
                             @RequestParam("imageFile") String imageName) {
        userService.updateAvatar( idUser, image, imageName );
    }

    @PutMapping("/user/{idUser}/update/background")
    public void updateBackground(@PathVariable("idUser") Integer idUser, @RequestParam("background") String image,
                                 @RequestParam("imageFile") String imageName) {
        userService.updateBackground( idUser, image, imageName );
    }

    @GetMapping("/account/{idAccount}/changePassword")
    public void sendMailConfirmChangePassword(@PathVariable("idAccount") Integer id,
                                              @RequestParam("code") Integer code) {
        User user = userService.findUserByAccountId( id );
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo( user.getEmail() );
        simpleMailMessage.setSubject( "Confirm Change Password" );
        simpleMailMessage.setFrom( "huuhan2507@gmail.com" );
        simpleMailMessage.setText( "Your Code: " + code );
        emailSenderService.sendEmail( simpleMailMessage );
    }
    @GetMapping("/account/{accountName}")
    public ResponseEntity<?> getAccountByAccountName(@PathVariable("accountName") String accountName){
        Account account = accountService.findAccountByAccountName( accountName );
        return ResponseEntity.ok( account );
    }

    @PutMapping("/account/{accountName}/changePassword")
    public void ChangePassword(@PathVariable("accountName") String accountName,
                               @RequestParam("oldPassword") String oldPassword,
                               @RequestParam("newPassword") String newPassword,
                               @RequestParam("confirmPassword") String confirmPassword) {
        Account account = accountService.findAccountByAccountName( accountName );
        accountService.changePassword( account, oldPassword, newPassword, confirmPassword );
    }

}
