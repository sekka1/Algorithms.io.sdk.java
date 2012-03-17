/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
* $Author: rajiv $
* $Date: 2011/09/29 $
*/
package io.algorithms.common.resource;

import java.util.List;
import java.util.Map;

/**
 * Represents a group of connector components.
 * @author Rajiv Subrahmanyam
 */
public interface Group extends Component {
    /**
     * Returns the list of all children.
     * @return List of children
     */
    List<? extends Component> getChildren();

    /**
     * Returns list of children of the given type.
     * @param <T> type of children needed
     * @param type Class of type
     * @return List of children of given type
     */
    <T extends Component> List<T> getChildren(Class<T> type);

    /**
     * Returns map of children keyed by ID.
     * @return Map of children keyed by ID
     */
    Map<Long, ? extends Component> getChildMap();

    /**
     * Returns map of children keyed by ID.
     * @param type type of children needed
     * @return Map of children keyed by ID
     */
    <T extends Component> Map<Long, T> getChildMap(Class<T> type);

    /**
     * Get a child given ID.
     * @param id ID of child
     * @return Child 
     */
    Component getChildById(Long id);

    /**
     * Get child of a given type by ID.
     * @param <T> type of child
     * @param type type of child
     * @param id id of child
     * @return Child
     */
    <T extends Component> T getChildById(Class<T> type, Long id);

    /**
     * Get a child given name.
     * @param name name of child
     * @return Child 
     */
    Component getChildByName(String name);

    /**
     * Get child of a given type by name.
     * @param <T> type of child
     * @param type type of child
     * @param name name of child
     * @return Child
     */
    <T extends Component> T getChildByName(Class<T> type, String name);

    /**
     * Returns list of all descendants of the given type.
     */
    <T extends Component> List<T> getDescendants(Class<T> type);

    /**
     * Returns descendant with given id.
     */
    <T extends Component> T getDescendantById(Class<T> type, Long id);

    /**
     * Returns descendants with given name.
     */
    <T extends Component> List<T> getDescendantsByName(Class<T> type, String name);
    
    /**
     * Set children to given list.
     * @param managedEntities list to set as children
     */
    void setChildren(List<? extends Component> children);

    /**
     * Adds a child.
     * @param child child to be added
     */
    void addChild(Component child);

    /**
     * Adds children.
     * @param children children to be added
     */
    void addChildren(List<? extends Component> children);

    /**
     * Removes a child.
     * @param child child to be removed
     */
    void removeChild(Component child);
    
    /**
     * Removes a child.
     * @param child child to be removed
     */
    void removeChildren(List<? extends Component> child);
    
    /**
     * Removes all children.
     */
    void removeAll();
    
}
