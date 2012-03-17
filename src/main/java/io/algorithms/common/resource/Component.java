/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv $
* $Date: 2011/09/29 $
*/
package io.algorithms.common.resource;

/**
 * Represents a generic component.
 */
public interface Component extends Comparable<Component> {
    /**
     * Returns the ID of the component.
     */
    long getId();

    /**
     * Sets the ID of the component.
     */
    void setId(long id);

    /**
     * Returns the name of the component.
     */
    String getName();

    void setName(String name);

    /**
     * Returns the description of the component.
     */
    String getDescription();

    void setDescription(String description);

    /**
     * @return the parent Connector Component
     */
    Group getParent();

    /**
     * Sets the parent.
     * @param parent
     */
    void setParent(Group parent);
    
    /**
     * Returns the URI of this component
     * @return
     */
    String getURI();
}
