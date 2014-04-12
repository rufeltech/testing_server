package ru.eltech.csa.siths.entity.node;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;

// ToDo:
// 1. Validators, validators, validators

public abstract class AbstractMeasuredCharacteristic extends AbstractNeo4jEntity {

    private String name;

    private int weight;

    public AbstractMeasuredCharacteristic(String name, int weight) {
        this.name = name;
        this.weight = weight;
    } 

    public AbstractMeasuredCharacteristic() {

    }

    public void setName( String name ) {
    	this.name = name;
    }

    public String getName() {
    	return this.name;
    }

    public void setWeight( int weight ) {
    	this.weight = weight;
    }

    public int getWeight() {
    	return this.weight;
    }

}