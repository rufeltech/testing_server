package ru.eltech.csa.siths.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import ru.eltech.csa.siths.entity.node.Role;

public interface RoleRepository extends GraphRepository<Role> {

	public Role findByName(String name);

}