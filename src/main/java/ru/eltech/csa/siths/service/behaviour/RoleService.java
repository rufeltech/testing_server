package ru.eltech.csa.siths.service.behaviour;

import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.Role;
import ru.eltech.csa.siths.entity.relationship.Permission;

public interface RoleService {
 
    public boolean isRoleExists(String name);

    public Role createRole(Role role);

    public Role getRoleByName(String name);

}