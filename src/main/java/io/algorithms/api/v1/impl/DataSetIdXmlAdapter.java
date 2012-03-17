/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;

import java.net.URI;

import io.algorithms.common.Constants;
import io.algorithms.common.resource.DataSet;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * 
 */
public class DataSetIdXmlAdapter extends XmlAdapter<URI, DataSet> {

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#unmarshal(java.lang.Object)
     */
    @Override
    public DataSet unmarshal(URI v) throws Exception {
        return null; // ComponentBroker.getDataSetById(Long.parseLong(v));
    }

    /* (non-Javadoc)
     * @see javax.xml.bind.annotation.adapters.XmlAdapter#marshal(java.lang.Object)
     */
    @Override
    public URI marshal(DataSet v) throws Exception {
        return URI.create("/v1/datasets/" + (v == null ? Constants.RESOURCE_ID_DEFAULT : v.getId()));
    }

}
