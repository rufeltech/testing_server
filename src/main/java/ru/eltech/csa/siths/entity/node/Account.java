package ru.eltech.csa.siths.entity.node;

import java.util.Set;
import java.util.HashSet;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.annotation.NodeEntity;

import org.neo4j.graphdb.Direction;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;
import ru.eltech.csa.siths.entity.node.Role;
import ru.eltech.csa.siths.form.entity.FeaturedAccount;
import ru.eltech.csa.siths.entity.relationship.Permission;
import ru.eltech.csa.siths.entity.relationship.Ownership;

@NodeEntity
public class Account extends AbstractNeo4jEntity {

    @NotEmpty(message = "Account name field should not be empty")
    @Size(min = 3, max = 32, message = "Account name should be between ${min} and ${max} characters long")
    @Indexed(unique = true)
    private String name;

    @Email(message="Please provide a valid email address")
    @NotEmpty(message = "Email field should not be empty")
    @Indexed
    private String email;

    private String salt;

    private String passwordHash;

    @RelatedToVia(type = "permittedToPerform", direction = Direction.OUTGOING)
    private Set<Permission> permissions = new HashSet<Permission>();

    @RelatedToVia(type = "belongsTo", direction = Direction.INCOMING)
    private Ownership ownership;

    public Account(FeaturedAccount featuredAccount) {
        this.name = featuredAccount.getName();
        this.email = featuredAccount.getEmail();
        this.passwordHash = featuredAccount.getPassword();
    }

    public Account(String name, String email, String passwordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public Account() {

    }

    public void setName(String name) {
    	this.name = name;
    }

    public String getName() {
    	return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public void addRole(Role role) {
        this.permissions.add(new Permission(this, role));
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return this.permissions;
    }

    public void setOwnership(Ownership ownership) {
        this.ownership = ownership;
    }

    public Ownership getOwnership() {
        return this.ownership;
    }

}