/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;

import io.algorithms.api.v1.JobResource;
import io.algorithms.common.Constants.DataType;
import io.algorithms.common.resource.AlgorithmBase;
import io.algorithms.common.resource.DataSetBase;
import io.algorithms.common.resource.JobBase;

import java.net.URI;

import javax.ws.rs.core.Response;

/**
 * 
 */
public class JobResourceImpl implements JobResource {

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.JobResource#getJobs()
     */
    public JobsBean getJobs() {
        return new JobsBean();
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.JobResource#createJob(io.algorithms.api.v1.JobBean)
     */
    public Response createJob(JobBean job) {
        URI createdURI = URI.create("/datasets/" + job.getId());
        return Response.created(createdURI).build();
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.JobResource#getJob(long)
     */
    public JobBean getJob(long id) {
        return new JobBean(new JobBase("name", "description",
                new AlgorithmBase("abcd", "efgh", DataType.MATRIX_DOUBLE, DataType.VECTOR_DOUBLE, DataType.VECTOR_DOUBLE),
                new DataSetBase("name", "description")));
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.JobResource#updateJob(io.algorithms.api.v1.JobBean)
     */
    public Response updateJob(JobBean job) {
        return Response.ok().build();
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.JobResource#deleteJob(long)
     */
    public Response deleteJob(long id) {
        return Response.ok().build();
    }

}
