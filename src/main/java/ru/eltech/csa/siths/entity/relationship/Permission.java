package ru.eltech.csa.siths.entity.relationship;

import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.data.neo4j.annotation.EndNode;

import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.Role;

@RelationshipEntity(type = "permittedToPerform")
public class Permission extends AbstractEventRelationshipEntity {
    
	@StartNode
    private Account account;

    @EndNode 
    private Role role;

    public Permission(Account account, Role role) {
        this.account = account;
        this.role = role;
    }

    public Permission() {

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setRole(Role role) {
    	this.role = role;
    }

    public Role getRole() {
    	return this.role;
    }

}