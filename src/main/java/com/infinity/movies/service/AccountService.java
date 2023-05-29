package com.infinity.movies.service;


import com.infinity.movies.entity.Account;
import com.infinity.movies.model.AccountModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {

    Account getUserById(Long id);

    Iterable<Account> getUsers();

    boolean addUser(AccountModel accountModel);

    String getMaxAuthorityByUsername(String username);

    Account updateUser(Long id, AccountModel accountModel);

    Account authorizationUser(AccountModel accountModel);

    void deleteById(Long id);
}
