package ru.eltech.csa.siths.repository;

import org.springframework.data.neo4j.conversion.Result;

import org.springframework.data.neo4j.repository.GraphRepository;

import ru.eltech.csa.siths.entity.node.IssuePriority;

public interface IssuePriorityRepository extends GraphRepository<IssuePriority> {

	Result<IssuePriority> findAll();

}