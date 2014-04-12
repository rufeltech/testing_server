package ru.eltech.csa.siths.service.base;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractEntityService<T extends GraphRepository> {
	
	@Autowired
	protected T entityRepository;

	@Autowired
	protected Neo4jOperations template;

	public AbstractEntityService(T entityRepository) {
		this.entityRepository = entityRepository;
	}

	public AbstractEntityService() {
		
	}

	public void setEntityRepository(T entityRepository) {
		this.entityRepository = entityRepository;
	}

	public T getEntityRepository() {
		return this.entityRepository;
	}

}