/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;

import java.net.URI;

import io.algorithms.common.Constants;
import io.algorithms.common.resource.Algorithm;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 */
public class AlgorithmIdXmlAdapter extends XmlAdapter<URI, Algorithm> {

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
     */
    @Override
    public Algorithm unmarshal(URI v) throws Exception {
        return null; // ComponentBroker.getAlgorithmById(Long.parseLong(v));
    }

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
     */
    @Override
    public URI marshal(Algorithm v) throws Exception {
        return URI.create("/v1/algorithms/" + (v == null ? Constants.RESOURCE_ID_DEFAULT : v.getId()));
    }

}
