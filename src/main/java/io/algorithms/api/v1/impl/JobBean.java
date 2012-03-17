/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;


import io.algorithms.common.resource.Algorithm;
import io.algorithms.common.resource.DataSet;
import io.algorithms.common.resource.JobBase;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Represents a data set.
 */
@XmlRootElement(name="job")
public class JobBean {

    private JobBase job;
    
    /**
     * Required for JAXB
     */
    public JobBean() { }
    
    /**
     * Ctor.
     */
    public JobBean(JobBase job) {
        this.job = job;
    }
    
    public long getId() {
        return job.getId();
    }

    /* (non-Javadoc)
     * @see io.algorithms.rajivtest.Component#setId(java.lang.String)
     */
    public void setId(long id) {
        job.setId(id);
    }

    public String getName() {
        return job.getName();
    }

    public void setName(String name) {
        job.setName(name);
    }

    public String getDescription() {
        return job.getDescription();
    }

    public void setDescription(String description) {
        job.setDescription(description);
    }

    /**
     * @return the dataSetId
     */
    @XmlJavaTypeAdapter(type = DataSet.class, value = DataSetIdXmlAdapter.class)
    public DataSet getDataSet() {
        return job.getDataSet();
    }

    /**
     * @param dataSetId the dataSetId to set
     */
    public void setDataSet(DataSet dataSet) {
        job.setDataSet(dataSet);
    }

    /**
     * @return the algorithmId
     */
    @XmlJavaTypeAdapter(type = Algorithm.class, value = AlgorithmIdXmlAdapter.class)
    public Algorithm getAlgorithm() {
        return job.getAlgorithm();
    }

    /**
     * @param algorithmId the algorithmId to set
     */
    public void setAlgorithm(Algorithm algorithm) {
        job.setAlgorithm(algorithm);
    }
    
    @XmlTransient
    public JobBase getJob() {
        return job;
    }
}
