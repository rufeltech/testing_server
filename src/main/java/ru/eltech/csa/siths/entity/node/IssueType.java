package ru.eltech.csa.siths.entity.node;

import org.springframework.data.neo4j.annotation.NodeEntity;

import ru.eltech.csa.siths.entity.node.AbstractMeasuredCharacteristic;

@NodeEntity
public class IssueType extends AbstractMeasuredCharacteristic {

	public IssueType(String name, int weight) {
        super(name, weight);
    } 

    public IssueType() {

    }

}