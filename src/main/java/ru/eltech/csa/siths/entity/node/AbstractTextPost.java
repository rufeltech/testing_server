package ru.eltech.csa.siths.entity.node;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.support.index.IndexType;

import org.neo4j.graphdb.Direction;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;
import ru.eltech.csa.siths.entity.relationship.Post;

public abstract class AbstractTextPost extends AbstractNeo4jEntity {

	@NotEmpty(message = "Comment field should not be empty")
    @Size(max = 5000, message = "Comment should not be longer than ${max} characters")
	@Indexed(indexName = "postTextFulltextIndex", indexType = IndexType.FULLTEXT)
    public String text;

    @RelatedToVia(type = "postedBy", direction = Direction.OUTGOING)
    private Post post;

    public AbstractTextPost(String text) {
        this.text = text;
    } 

    public AbstractTextPost() {

    }

    public void setText( String text ) {
    	this.text = text;
    }

    public String getText() {
    	return this.text;
    }

    public void setPost( Post post ) {
    	this.post = post;
    }

    public Post getPost() {
    	return this.post;
    }

}