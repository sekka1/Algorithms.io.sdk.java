/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.common.resource;

/**
 * 
 */
public class JobBase extends ComponentBase implements Job {
    
    private Algorithm algorithm;
    private DataSet dataSet;
    
    /**
     * Required for JAXB
     */
    public JobBase() { }
    
    /**
     * Ctor.
     */
    public JobBase(String name, String description, Algorithm algorithm, DataSet dataSet) {
        super(name, description);
        this.setDataSet(dataSet); this.setAlgorithm(algorithm);
    }
    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Job#getDataSet()
     */
    @Override
    public DataSet getDataSet() {
        return dataSet;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Job#setDataSet(io.algorithms.common.resource.DataSet)
     */
    @Override
    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Job#getAlgorithm()
     */
    @Override
    public Algorithm getAlgorithm() {
        return algorithm;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Job#setAlgorithm(io.algorithms.common.resource.Algorithm)
     */
    @Override
    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

}
