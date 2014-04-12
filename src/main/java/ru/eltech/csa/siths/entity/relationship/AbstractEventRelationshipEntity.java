package ru.eltech.csa.siths.entity.relationship;

import java.sql.Date;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;

public abstract class AbstractEventRelationshipEntity extends AbstractNeo4jEntity {
    
    private Date date;

    public void setDate(Date date) {
    	this.date = date;
    }

    public Date getDate() {
    	return this.date;
    }

}