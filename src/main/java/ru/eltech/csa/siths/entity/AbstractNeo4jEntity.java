package ru.eltech.csa.siths.entity;

import org.springframework.data.neo4j.annotation.GraphId;
import java.io.Serializable;

public abstract class AbstractNeo4jEntity implements Serializable{

	@GraphId
	private Long id;

	public AbstractNeo4jEntity(long id) {
		this.id = id;
	}

	public AbstractNeo4jEntity() {
		
	}

	public Long getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {

		if ( this == obj ) {
			return true;
		}

		if ( id == null || obj == null || !getClass().equals( obj.getClass() ) ) {
		    return false;
		}
		
		return id.equals( ( (AbstractNeo4jEntity)obj ).id );

	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}
}