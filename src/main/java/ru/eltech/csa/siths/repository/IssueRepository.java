package ru.eltech.csa.siths.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import ru.eltech.csa.siths.entity.node.Issue;

public interface IssueRepository extends GraphRepository<Issue> {
	
	public Issue findByPublicId(String publicId);

}