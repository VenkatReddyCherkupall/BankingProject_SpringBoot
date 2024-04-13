package com.sb.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.model.Account;

@Repository
public interface IAccountRepo extends JpaRepository<Account, Long>{

	
}
