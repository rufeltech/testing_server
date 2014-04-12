package ru.eltech.csa.siths.entity.relationship;

import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.data.neo4j.annotation.EndNode;

import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.User;

@RelationshipEntity(type = "belongsTo")
public class Ownership extends AbstractEventRelationshipEntity {
    
	@StartNode
    private Account account;

    @EndNode 
    private User user;

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

}