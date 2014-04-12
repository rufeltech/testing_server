package ru.eltech.csa.siths.service.behaviour;

import java.util.Set;

import ru.eltech.csa.siths.entity.node.IssueType;

public interface IssueTypeService {
 
    public boolean isIssueTypeExists(String name);

    public boolean isIssueTypeExists(IssueType issueType);

    public IssueType createIssueType(IssueType issueType);

    public IssueType getIssueTypeByName(String name);

    public Set<IssueType> getIssueTypesList();

}