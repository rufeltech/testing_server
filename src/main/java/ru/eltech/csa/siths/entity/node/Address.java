package ru.eltech.csa.siths.entity.node;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import org.neo4j.graphdb.Direction;

import ru.eltech.csa.siths.entity.AbstractNeo4jEntity;

@NodeEntity
public class Address extends AbstractNeo4jEntity {

    @NotEmpty(message = "Country name should not be empty")
    @Size(max = 255, message = "Country name should not be longer than ${max} characters")
    @Indexed
    private String countryName;

    @Size(max = 255, message = "State/province name should not be longer than ${max} characters")
    @Indexed
    private String stateOrProvinceName;

    @NotEmpty(message = "City name should not be empty")
    @Size(max = 255, message = "City name should not be longer than ${max} characters")
    @Indexed
    private String cityName;

    @NotEmpty(message = "Postal code should not be empty")
    @Size(min = 3, max = 10, message = "Country name should be between ${min} and ${max} characters long")
    @Indexed
    private String postalCode;

    @NotEmpty(message = "Primary address should not be empty")
    @Size(max = 255, message = "Primary address should not be longer than ${max} characters")
    @Indexed
    private String primaryAddresLine;

    @Size(max = 255, message = "Secondary address should not be longer than ${max} characters")
    @Indexed
    private String secondaryAddressLine;

    public Address( String countryName, 
                    String stateOrProvinceName, 
                    String cityName, 
                    String postalCode,
                    String primaryAddresLine,
                    String secondaryAddressLine ) {
        this.countryName = countryName;
        this.stateOrProvinceName = stateOrProvinceName;
        this.cityName = cityName;
        this.postalCode = postalCode;
        this.primaryAddresLine = primaryAddresLine;
        this.secondaryAddressLine = secondaryAddressLine;
    }

    public Address( String countryName, 
                    String cityName, 
                    String postalCode,
                    String primaryAddresLine ) {
        this.countryName = countryName;
        this.stateOrProvinceName = stateOrProvinceName;
        this.cityName = cityName;
        this.postalCode = postalCode;
        this.primaryAddresLine = primaryAddresLine;
        this.secondaryAddressLine = secondaryAddressLine;
    }

    public Address() {
        
    }

    public void setCountryName(String countryName) {
    	this.countryName = countryName;
    }

    public String getCountryName() {
    	return this.countryName;
    }

    public void setStateOrProvinceName(String stateOrProvinceName) {
        this.stateOrProvinceName = stateOrProvinceName;
    }

    public String getStateOrProvinceName() {
        return this.stateOrProvinceName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPrimaryAddressLine(String primaryAddresLine) {
        this.primaryAddresLine = primaryAddresLine;
    }

    public String getPrimaryAddressLine() {
        return this.primaryAddresLine;
    }

    public void setSecondaryAddressLine(String secondaryAddressLine) {
        this.secondaryAddressLine = secondaryAddressLine;
    }

    public String getSecondaryAddressLine() {
        return this.secondaryAddressLine;
    }

}