package ru.eltech.csa.siths.service.behaviour;

import java.util.Set;

import ru.eltech.csa.siths.entity.node.IssuePriority;

public interface IssuePriorityService {
 
    public boolean isIssuePriorityExists(String name);

    public boolean isIssuePriorityExists(IssuePriority issuePriority);

    public IssuePriority createIssuePriority(IssuePriority issuePriority);

    public IssuePriority getIssuePriorityByName(String name);

    public Set<IssuePriority> getIssuePrioritiesList();

}