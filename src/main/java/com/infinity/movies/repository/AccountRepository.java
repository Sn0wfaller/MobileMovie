package com.infinity.movies.repository;

import com.infinity.movies.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

    @Query(value = "select au.name from account a\n" +
            "join account_authority aau ON aau.id_account = a.id_account\n" +
            "join authority au ON au.id_authority = aau.id_authority\n" +
            "where a.username = ?1 and au.id_authority = (select max(au1.id_authority) from account a1\n" +
            "join account_authority aau1 ON aau1.id_account = a1.id_account\n" +
            "join authority au1 ON au1.id_authority = aau1.id_authority)", nativeQuery = true)
    String findMaxAuthorityByUsername(String username);

    @Query("select a.password from Account a where a.username = ?1")
    String getEncodedPass(String username);
}
