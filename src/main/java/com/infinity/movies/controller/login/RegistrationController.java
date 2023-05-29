package com.infinity.movies.controller.login;


import com.infinity.movies.model.AccountModel;
import com.infinity.movies.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

    private final AccountService accountService;


    @PostMapping()
    public ResponseEntity<Boolean> registration(@RequestBody AccountModel accountModel)
    {
        return new ResponseEntity<>(accountService.addUser(accountModel), HttpStatus.CREATED);
    }
}
