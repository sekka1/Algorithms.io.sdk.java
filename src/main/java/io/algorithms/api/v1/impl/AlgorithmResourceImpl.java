/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.api.v1.impl;

import io.algorithms.api.v1.AlgorithmResource;
import io.algorithms.common.Constants.DataType;
import io.algorithms.common.resource.AlgorithmBase;

import java.net.URI;
import java.util.Arrays;

import javax.ws.rs.core.Response;

/**
 * Implementation for AlgorithmResource
 */
public class AlgorithmResourceImpl implements AlgorithmResource {

    /* (non-Javadoc)
     * @see io.algorithms.api.AlgorithmResource#getAlgorithms()
     */
    public AlgorithmsBean getAlgorithms() {
        return new AlgorithmsBean(Arrays.asList(
                new AlgorithmBean(new AlgorithmBase("1", "testdescription", DataType.MATRIX_DOUBLE, DataType.VECTOR_DOUBLE, DataType.VECTOR_DOUBLE)),                
                new AlgorithmBean(new AlgorithmBase("2", "testdescription", DataType.MATRIX_DOUBLE, DataType.VECTOR_DOUBLE, DataType.VECTOR_DOUBLE)),               
                new AlgorithmBean(new AlgorithmBase("3", "testdescription", DataType.MATRIX_DOUBLE, DataType.VECTOR_DOUBLE, DataType.VECTOR_DOUBLE)),               
                new AlgorithmBean(new AlgorithmBase("1", "testdescription", DataType.MATRIX_DOUBLE, DataType.VECTOR_DOUBLE, DataType.VECTOR_DOUBLE))               
                ));
    }

    /* (non-Javadoc)
     * @see io.algorithms.ws.api.AlgorithmResource#createAlgorithm(io.algorithms.ws.api.Algorithm)
     */
    public Response createAlgorithm(AlgorithmBean algorithm) {
        return Response.created(URI.create("/v1/algorithms/" + algorithm.getId())).build();
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.AlgorithmResource#getAlgorithm(java.lang.String)
     */
    public AlgorithmBean getAlgorithm(long id) {
        return new AlgorithmBean(new AlgorithmBase("testname", "testdescription", DataType.MATRIX_DOUBLE, DataType.VECTOR_DOUBLE, DataType.VECTOR_DOUBLE));
    }

    /* (non-Javadoc)
     * @see io.algorithms.api.v1.AlgorithmResource#deleteAlgorithm(long)
     */
    @Override
    public Response deleteAlgorithm(long id) {
        return Response.ok().build();
    }

}
