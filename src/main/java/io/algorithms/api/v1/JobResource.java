/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv$
* $Date: Feb 22, 2012$
*/
package io.algorithms.api.v1;

import io.algorithms.api.v1.impl.JobBean;
import io.algorithms.api.v1.impl.JobsBean;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Data set Service
 */
@Path("/v1/jobs")
public interface  JobResource {
    /**
     * Gets all jobs.
     * @return List of all dataset descriptions
     */
    @GET
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public JobsBean getJobs();
    
    /**
     * Creates a new data set.
     * @param dataSet details of Dataset to be created
     * @return Response with link to newly created dataset
     */
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createJob(JobBean job);

    /**
     * Get job by id.
     * @param id ID of data set to be fetched
     * @return Data set description
     */
    @GET
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public JobBean getJob(@PathParam("id") long id);

    /**
     * Modifies job.
     * @param is
     * @return Response
     */
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response updateJob(JobBean job);

    /**
     * Delete given data set.
     * @param id id of data set to be deleted
     * @return
     */
    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteJob(@PathParam("id") long id);
}
