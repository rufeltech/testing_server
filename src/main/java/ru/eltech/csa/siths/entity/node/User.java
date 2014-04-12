package ru.eltech.csa.siths.entity.node;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import org.neo4j.graphdb.Direction;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;
import ru.eltech.csa.siths.entity.relationship.Accomodation;
import ru.eltech.csa.siths.entity.relationship.Ownership;

@NodeEntity
public class User extends AbstractNeo4jEntity {

	String firstName;

	String lastName;

	@RelatedToVia(type = "residesAt", direction = Direction.OUTGOING)
	Accomodation accomodation;

	@RelatedToVia(type = "belongsTo", direction = Direction.OUTGOING)
    private Ownership ownership;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String firstName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setAccomodation(Accomodation accomodation) {
		this.accomodation = accomodation;
	}

	public Accomodation getAccomodation() {
		return this.accomodation;
	}

	public void setOwnership(Ownership ownership) {
		this.ownership = ownership;
	}

	public Ownership getOwnership() {
		return this.ownership;
	}

}