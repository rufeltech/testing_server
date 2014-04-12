package ru.eltech.csa.siths.service.behaviour;

import ru.eltech.csa.siths.entity.node.Issue;

public interface IssueService {
 
    public boolean isIssueExists(String publicId);

    public boolean isIssueExists(Issue issue);

    public Issue createIssue(Issue issue);

    public Issue getIssueByPublicId(String publicId);

}