/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*
* $Author: rajiv$
* $Date: Mar 5, 2012$
*/
package io.algorithms.api.v1.impl;

import io.algorithms.api.v1.DataSetResource;
import io.algorithms.common.resource.DataSetBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

/**
 * 
 */
public class DataSetResourceImpl implements DataSetResource {

    /* (non-Javadoc)
     * @see io.algorithms.ws.v1.api.DataSetResource#getDataSets()
     */
    public DataSetsBean getDataSets() {
        return new DataSetsBean();
    }

    /* (non-Javadoc)
     * @see io.algorithms.ws.v1.api.DataSetResource#getDataSet(java.lang.String)
     */
    public DataSetBean getDataSet(long id) {
        return new DataSetBean(new DataSetBase("name", "none"));
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.DataSetResource#newDataSet()
     */
    public Response createDataSet(DataSetBean dataSet) {
        URI createdURI = URI.create("/datasets/" + dataSet.getId());
        return Response.created(createdURI).build();
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.DataSetResource#addToDataSet(java.io.InputStream)
     */
    public Response addToDataSet(InputStream is) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = br.readLine()) != null) {
                Logger.getAnonymousLogger().info("********************* " + s);
            }
            br.close();
            return Response.ok().build();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Response.notModified(e.getMessage()).build();
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.DataSetResource#deleteDataSet(io.algorithms.api.v1.DataSetBean)
     */
    public Response deleteDataSet(long id) {
        return Response.ok().build();
    }

}
