/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;


import static io.algorithms.common.Constants.DataType;
import io.algorithms.common.resource.Algorithm;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Represents an algorithm.
 */
@XmlRootElement(name="algorithm")
public class AlgorithmBean {
    private Algorithm algorithm;

    /**
     * Required for JAXB
     */
    public AlgorithmBean() { }
    
    /**
     * Ctor.
     */
    public AlgorithmBean(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public long getId() {
        return algorithm.getId();
    }

    /* (non-Javadoc)
     * @see io.algorithms.rajivtest.Component#setId(java.lang.String)
     */
    public void setId(long id) {
        algorithm.setId(id);
    }

    public String getName() {
        return algorithm.getName();
    }

    public void setName(String name) {
        algorithm.setName(name);
    }

    public String getDescription() {
        return algorithm.getDescription();
    }

    public void setDescription(String description) {
        algorithm.setDescription(description);
    }

    /**
     * @return the inputType
     */
    public DataType getInputType() {
        return algorithm.getInputType();
    }

    /**
     * @param inputType the inputType to set
     */
    public void setInputType(DataType inputType) {
        algorithm.setInputType(inputType);
    }

    /**
     * @return the queryType
     */
    public DataType getQueryType() {
        return algorithm.getQueryType();
    }

    /**
     * @param queryType the queryType to set
     */
    public void setQueryType(DataType queryType) {
        algorithm.setQueryType(queryType);
    }

    /**
     * @return the outputType
     */
    public DataType getOutputType() {
        return algorithm.getOutputType();
    }

    /**
     * @param outputType the outputType to set
     */
    public void setOutputType(DataType outputType) {
        algorithm.setOutputType(outputType);
    }
    
    @XmlTransient
    public Algorithm getAlgorithm() {
        return algorithm;
    }
}
