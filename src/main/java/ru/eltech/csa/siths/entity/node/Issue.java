package ru.eltech.csa.siths.entity.node;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.support.index.IndexType;

import org.neo4j.graphdb.Direction;

import java.util.ArrayList;

import ru.eltech.csa.siths.entity.node.AbstractTextPost;
import ru.eltech.csa.siths.entity.node.Comment;

@NodeEntity
public class Issue extends AbstractTextPost {

    @Indexed(unique = true)
    private String publicId;

    @NotEmpty(message = "Title field should not be empty")
    @Size(max = 255, message = "Title should not be longer than ${max} characters")
    @Indexed(indexName = "issueTitleTextFulltextIndex", indexType = IndexType.FULLTEXT)
    private String title;

    @RelatedTo(type = "repliedTo", direction = Direction.INCOMING)
    private ArrayList<Comment> comments;

    public Issue(String title, String text) {
        super(text);
        this.title = title;
    }

    public Issue() {

    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getPublicId() {
        return this.publicId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public ArrayList<Comment> getComments() {
        return this.comments;
    }

    public Comment getComment(int index) {
        return this.comments.get(index);
    }

}