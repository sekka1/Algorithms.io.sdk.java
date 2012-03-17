/*
 * Copyright 2012 Algorithms.io. All Rights Reserved.
 */
package io.algorithms.common.resource;

import static io.algorithms.common.Constants.*;

/**
 * 
 */
public interface Algorithm extends Component {

    /**
     * @return the inputType
     */
    public abstract DataType getInputType();

    /**
     * @param inputType the inputType to set
     */
    public abstract void setInputType(DataType inputType);

    /**
     * @return the queryType
     */
    public abstract DataType getQueryType();

    /**
     * @param queryType the queryType to set
     */
    public abstract void setQueryType(DataType queryType);

    /**
     * @return the outputType
     */
    public abstract DataType getOutputType();

    /**
     * @param outputType the outputType to set
     */
    public abstract void setOutputType(DataType outputType);
}
