/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.common.resource;

import static io.algorithms.common.Constants.*;

/**
 * Algorithm.
 */
public class AlgorithmBase extends ComponentBase implements Algorithm {
    private DataType inputType, queryType, outputType;

    /**
     * Required for JAXB
     */
    public AlgorithmBase() { }
    
    /**
     * Ctor.
     */
    public AlgorithmBase(String name, String description,
            DataType inputType, DataType queryType, DataType outputType) {
        super(name, description);
        this.inputType = inputType; this.queryType = queryType; this.outputType = outputType;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Algorithm#getInputType()
     */
    @Override
    public DataType getInputType() {
        return inputType;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Algorithm#setInputType(io.algorithms.common.resource.AlgorithmBase.DataType)
     */
    @Override
    public void setInputType(DataType inputType) {
        this.inputType = inputType;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Algorithm#getQueryType()
     */
    @Override
    public DataType getQueryType() {
        return queryType;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Algorithm#setQueryType(io.algorithms.common.resource.AlgorithmBase.DataType)
     */
    @Override
    public void setQueryType(DataType queryType) {
        this.queryType = queryType;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Algorithm#getOutputType()
     */
    @Override
    public DataType getOutputType() {
        return outputType;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Algorithm#setOutputType(io.algorithms.common.resource.AlgorithmBase.DataType)
     */
    @Override
    public void setOutputType(DataType outputType) {
        this.outputType = outputType;
    }
}
