/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a collection of algorithms.
 */
@XmlRootElement(name="algorithms")
public class AlgorithmsBean {
    private List<AlgorithmBean> algorithms;
    
    public AlgorithmsBean() { }

    public AlgorithmsBean(List<AlgorithmBean> algorithms) {
        this.setAlgorithms(algorithms);
    }

    @XmlElement(name="algorithm")
    public List<AlgorithmBean> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(List<AlgorithmBean> algorithms) {
        this.algorithms = algorithms;
    }
}
