package ru.eltech.csa.siths.entity.node;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import org.neo4j.graphdb.Direction;

import java.util.List;

import ru.eltech.csa.siths.entity.node.AbstractTextPost;
import ru.eltech.csa.siths.entity.node.Issue;

@NodeEntity
public class Comment extends AbstractTextPost {

	@RelatedTo(type = "repliedTo", direction = Direction.OUTGOING)
	private Issue issue;

	public void setIssue(Issue issue) {
        this.issue = issue;
    }

    public Issue getIssue() {
        return this.issue;
    }

}