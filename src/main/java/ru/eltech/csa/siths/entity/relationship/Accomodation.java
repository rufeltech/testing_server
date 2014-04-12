package ru.eltech.csa.siths.entity.relationship;

import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.data.neo4j.annotation.EndNode;

import ru.eltech.csa.siths.entity.node.Address;
import ru.eltech.csa.siths.entity.node.User;

@RelationshipEntity(type = "residesAt")
public class Accomodation extends AbstractEventRelationshipEntity {
    
	@StartNode
    private User user;

    @EndNode 
    private Address address;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setAddress(Address address) {
    	this.address = address;
    }

    public Address getAddress() {
    	return this.address;
    }

}