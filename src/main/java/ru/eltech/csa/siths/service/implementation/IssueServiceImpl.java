package ru.eltech.csa.siths.service.implementation;

import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import ru.eltech.csa.siths.entity.node.Issue;
import ru.eltech.csa.siths.repository.IssueRepository;
import ru.eltech.csa.siths.service.base.AbstractEntityService;
import ru.eltech.csa.siths.service.behaviour.IssueService;
import ru.eltech.csa.siths.service.behaviour.ObjectMessageDigestService;

@Service
public class IssueServiceImpl extends AbstractEntityService<IssueRepository> implements IssueService  {

    @Autowired
    ObjectMessageDigestService md5ObjectMessageDigestService; 

    public boolean isIssueExists(String publicId) {
        if ( this.getIssueByPublicId(publicId) != null )
            return true;
        else
            return false;
    }

    public boolean isIssueExists(Issue issue) {
        return this.isIssueExists( this.countMessageDigest(issue) );
    }

    @Transactional
    public Issue createIssue(Issue issue) {
        String messageDigest = this.countMessageDigest(issue);

        if ( issue.getPublicId() != messageDigest )
            issue.setPublicId(messageDigest);

        if ( this.isIssueExists( issue.getPublicId() ) )
            return null;
        try {
            return this.entityRepository.save(issue);
        } catch (Exception e) {
            return null;
        }   
    }

    public Issue getIssueByPublicId(String publicId) {
        return this.entityRepository.findByPublicId(publicId);
    }

    private String countMessageDigest(Issue issue) {
        return md5ObjectMessageDigestService.getObjectMessageDigest( 
                    new Issue( issue.getTitle(), issue.getText() ) );
    }

}