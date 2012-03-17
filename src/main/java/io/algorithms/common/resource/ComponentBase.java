/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv $
* $Date: 2011/09/29 $
*/
package io.algorithms.common.resource;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Base impl of Component. It attempts to be thread safe.
 * Most of this code was refactored from BaseConnectorComponent.
 * @author Rajiv Subrahmanyam
 */
public class ComponentBase implements Component {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0); // This is to be replaced with JPA auto generated id
    
    private volatile long _id;
    private volatile String _name, _description;
    private volatile String _uri;
    private volatile Group _parent;

    public ComponentBase() { }
    
    /**
     * @param id
     * @param name
     */
    public ComponentBase(String name, String description) {
        this();
        _id = ID_GENERATOR.incrementAndGet();
        _name = name;
        _description = description;
    }

    @Override
    public long getId() {
        return _id;
    }

    /* (non-Javadoc)
     * @see io.algorithms.rajivtest.Component#setId(java.lang.String)
     */
    @Override
    public void setId(long id) {
        _id = id;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        if (name == null) { throw new NullPointerException("Name cannot be null"); }
        _name = name;
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @Override
    public Group getParent() {
        return _parent;
    }

    @Override
    public void setParent(Group parent) {
        _parent = parent;
        _uri = parent == null ? "/" + getName() : parent.getURI() + "/" + getName();
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Component o) {
        return Long.valueOf(_id).compareTo(Long.valueOf(o.getId()));
    }
    
    /**
     * @return a URI representation of this connector's parent
     * @param connectorComponent
     */
    @Override
    public String getURI() {
        return _uri == null ? "" : _uri;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getURI();
    }
}
