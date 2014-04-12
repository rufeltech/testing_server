package ru.eltech.csa.siths.service.implementation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.Role;
import ru.eltech.csa.siths.entity.relationship.Permission;
import ru.eltech.csa.siths.repository.RoleRepository;
import ru.eltech.csa.siths.service.base.AbstractEntityService;
import ru.eltech.csa.siths.service.behaviour.RoleService;

import java.util.Set;
import java.util.HashSet;

@Service
public class RoleServiceImpl extends AbstractEntityService<RoleRepository> implements RoleService  {
 

    public boolean isRoleExists(String name) {
        if ( this.getRoleByName(name) != null )
            return true;
        else
            return false;
    }

    @Transactional
    public Role createRole(Role role) {
        if ( this.isRoleExists( role.getName() ) )
            return null;
        try {
            return this.entityRepository.save(role);
        } catch (Exception e) {
            return null;
        }   
    }

    public Role getRoleByName(String name) {
        return this.entityRepository.findByName(name);
    }

}