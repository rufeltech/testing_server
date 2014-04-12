package ru.eltech.csa.siths.repository;

import org.springframework.data.neo4j.conversion.Result;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import ru.eltech.csa.siths.entity.node.IssueType;

public interface IssueTypeRepository extends GraphRepository<IssueType> {

	// @Query("START n=node:__types__(className = 'ru.eltech.csa.siths.entity.node.IssueType') RETURN n ORDER BY n.weight ASC")
	// EndResult<IssueType> findAllOrderByWeightAsc();

	Result<IssueType> findAll();

	IssueType findOneByName(String name);

}