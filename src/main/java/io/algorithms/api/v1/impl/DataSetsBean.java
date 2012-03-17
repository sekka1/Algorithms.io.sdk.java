/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a collection of data sets.
 */
@XmlRootElement(name="datasets")
public class DataSetsBean {
    private List<DataSetBean> datasets;

    @XmlElement(name="dataset")
    public List<DataSetBean> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<DataSetBean> datasets) {
        this.datasets = datasets;
    }
}
