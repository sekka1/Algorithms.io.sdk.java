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
@XmlRootElement(name="jobs")
public class JobsBean {
    private List<JobBean> datasets;

    @XmlElement(name="job")
    public List<JobBean> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<JobBean> datasets) {
        this.datasets = datasets;
    }
}
