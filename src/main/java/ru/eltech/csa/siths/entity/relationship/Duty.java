package ru.eltech.csa.siths.entity.relationship;

import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.data.neo4j.annotation.EndNode;

import ru.eltech.csa.siths.entity.node.Project;
import ru.eltech.csa.siths.entity.node.User;

@RelationshipEntity(type = "worksOn")
public class Duty extends AbstractEventRelationshipEntity {
    
	@StartNode
    private User user;

    @EndNode 
    private Project project;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setProject(Project project) {
    	this.project = project;
    }

    public Project getProject() {
    	return this.project;
    }

}