package ru.eltech.csa.siths.entity.relationship;

import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.data.neo4j.annotation.EndNode;

import ru.eltech.csa.siths.entity.node.Company;
import ru.eltech.csa.siths.entity.node.User;

@RelationshipEntity(type = "worksIn")
public class Employment extends AbstractEventRelationshipEntity {
    
	@StartNode
    private User user;

    @EndNode 
    private Company company;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setCompany(Company company) {
    	this.company = company;
    }

    public Company getCompany() {
    	return this.company;
    }

}