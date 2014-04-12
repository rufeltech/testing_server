package ru.eltech.csa.siths.service.implementation;

import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eltech.csa.siths.entity.node.IssueType;
import ru.eltech.csa.siths.repository.IssueTypeRepository;
import ru.eltech.csa.siths.service.base.AbstractEntityService;
import ru.eltech.csa.siths.service.behaviour.IssueTypeService;

@Service
public class IssueTypeServiceImpl extends AbstractEntityService<IssueTypeRepository> implements IssueTypeService  {

	public boolean isIssueTypeExists(String name) {
        if ( this.getIssueTypeByName(name) != null )
            return true;
        else
            return false;
	}

    public boolean isIssueTypeExists(IssueType issueType) {
    	return this.isIssueTypeExists( issueType.getName() );
    }

    @Transactional
    public IssueType createIssueType(IssueType issueType) {
        if ( this.isIssueTypeExists( issueType ) )
            return null;
        try {
            return this.entityRepository.save(issueType);
        } catch (Exception e) {
            return null;
        }   
    }

    public IssueType getIssueTypeByName(String name) {
    	return this.entityRepository.findOneByName(name);
    }

    @Transactional
    public Set<IssueType> getIssueTypesList() {
    	return this.entityRepository.findAll().as(Set.class);
    }

}