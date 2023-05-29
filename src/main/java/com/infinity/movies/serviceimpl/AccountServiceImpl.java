package com.infinity.movies.serviceimpl;

import com.infinity.movies.entity.Account;
import com.infinity.movies.entity.Authority;
import com.infinity.movies.exception.ResourceNotFoundException;
import com.infinity.movies.model.AccountModel;
import com.infinity.movies.repository.AuthorityRepository;
import com.infinity.movies.repository.AccountRepository;
import com.infinity.movies.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AuthorityRepository authorityRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Account getUserById(Long id) {

        return accountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Пользователя с id =" + id + " не существует."));
    }

    @Override
    public Iterable<Account> getUsers() {

        return accountRepository.findAll();
    }

    @Override
    public boolean addUser(AccountModel accountModel) {

        Account account = accountRepository.findByUsername(accountModel.getUsername());

        if (account != null){
            return false;
        }
        Authority authority = authorityRepository.findByName("ROLE_USER");

        account = Account.builder()
                .authorities(Collections.singletonList(authority))
                .username(accountModel.getUsername())
                .password(bCryptPasswordEncoder.encode(accountModel.getPassword()))
                .build();

        accountRepository.save(account);
        return true;
    }

    @Override
    public String getMaxAuthorityByUsername(String username) {

        return accountRepository.findMaxAuthorityByUsername(username);
    }

    @Override
    public Account updateUser(Long id, AccountModel accountModel) {

        if (!accountRepository.existsById(id)){
            throw new ResourceNotFoundException("Пользователя с id = " + id + " не существует.");
        }
        Account account = accountRepository.getById(id);

        List<Authority> authoritiesList = new ArrayList<>();
        for (Long authorityId: accountModel.getAuthoritiesIds()) {

            Authority authority = authorityRepository.findById(authorityId)
                    .orElseThrow(() -> new ResourceNotFoundException("Прав с id =" + authorityId + " не существует."));
            authoritiesList.add(authority);
        }

        account.setAuthorities(authoritiesList);
        account.setUsername(accountModel.getUsername());
        account.setPassword(accountModel.getPassword());

        return accountRepository.save(account);
    }

    @Override
    public Account authorizationUser(AccountModel accountModel) {

        String encodedPass = accountRepository.getEncodedPass(accountModel.getUsername());
        if (!Objects.equals(encodedPass, "")){
            if(bCryptPasswordEncoder.matches(accountModel.getPassword(), encodedPass)){
                return accountRepository.findByUsername(accountModel.getUsername());
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {

        accountRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);

        if (account == null){
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        return account;
    }
}
