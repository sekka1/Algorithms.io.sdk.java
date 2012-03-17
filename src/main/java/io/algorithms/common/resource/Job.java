/*
 * Copyright 2012 Algorithms.io. All Rights Reserved.
 */
package io.algorithms.common.resource;

/**
 * 
 */
public interface Job extends Component {

    /**
     * @return the dataSetId
     */
    public abstract DataSet getDataSet();

    /**
     * @param dataSetId the dataSetId to set
     */
    public abstract void setDataSet(DataSet dataSet);

    /**
     * @return the algorithmId
     */
    public abstract Algorithm getAlgorithm();

    /**
     * @param algorithmId the algorithmId to set
     */
    public abstract void setAlgorithm(Algorithm algorithm);

}
