package ru.eltech.csa.siths.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import ru.eltech.csa.siths.entity.node.Comment;

public interface CommentRepository extends GraphRepository<Comment> {

}