
package com.aysidisi.plainspringwebapp.web.account.dao;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.plainspringwebapp.web.account.model.Account;

public interface AccountDao extends MongoRepository<Account, BigInteger>
{
	Account findByName(String name);
}
