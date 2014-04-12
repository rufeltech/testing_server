package ru.eltech.csa.siths.entity.node;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.annotation.NodeEntity;

import org.neo4j.graphdb.Direction;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;
import ru.eltech.csa.siths.entity.relationship.Permission;

@NodeEntity
public class Role extends AbstractNeo4jEntity implements GrantedAuthority {

    @Indexed(unique = true)
    private String name;

    @RelatedToVia(type = "permittedToPerform", direction = Direction.INCOMING)
    private Set<Permission> permissions;

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthority() {
        return this.name;
    }

    public void addPermission(Permission permission) {
        this.permissions.add(permission);
    }

}