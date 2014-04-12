package ru.eltech.csa.siths.entity.relationship;

import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;
import org.springframework.data.neo4j.annotation.EndNode;

import ru.eltech.csa.siths.entity.node.AbstractTextPost;
import ru.eltech.csa.siths.entity.node.User;

@RelationshipEntity(type = "postedBy")
public class Post extends AbstractEventRelationshipEntity {
    
	@StartNode 
	private AbstractTextPost textPost;

    @EndNode 
    private User user;

    public void setTextPost(AbstractTextPost textPost) {
    	this.textPost = textPost;
    }

    public AbstractTextPost getTextPost() {
    	return this.textPost;
    }

    public void setUser(User user) {
    	this.user = user;
    }

    public User getUser() {
    	return this.user;
    }

}