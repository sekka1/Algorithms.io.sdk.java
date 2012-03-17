/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import io.algorithms.common.resource.DataSet;

/**
 * Represents a data set.
 */
@XmlRootElement(name="dataset")
public class DataSetBean {
    private DataSet dataSet;
    
    public DataSetBean() {}
    
    public DataSetBean(DataSet dataSet) {
        this.dataSet = dataSet;
    }
    
    public long getId() {
        return dataSet.getId();
    }

    /* (non-Javadoc)
     * @see io.algorithms.rajivtest.Component#setId(java.lang.String)
     */
    public void setId(long id) {
        dataSet.setId(id);
    }

    public String getName() {
        return dataSet.getName();
    }

    public void setName(String name) {
        dataSet.setName(name);
    }

    public String getDescription() {
        return dataSet.getDescription();
    }

    public void setDescription(String description) {
        dataSet.setDescription(description);
    }
    
    @XmlTransient
    public DataSet getDataSet() {
        return dataSet;
    }
}
