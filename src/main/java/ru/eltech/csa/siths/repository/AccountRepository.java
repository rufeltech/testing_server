package ru.eltech.csa.siths.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import ru.eltech.csa.siths.entity.node.Account;

public interface AccountRepository extends GraphRepository<Account> {

	public Account findByName(String name);

	public Account findByEmail(String email);

}