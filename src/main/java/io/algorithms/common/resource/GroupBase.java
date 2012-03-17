/*
* Copyright 2012 Algorithms.io. All Rights Reserved.
*/
package io.algorithms.common.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Base implementation for Group. This class attempts to be thread safe.
 * @author Rajiv Subrahmanyam
 */
public class GroupBase extends ComponentBase implements Group {

    private volatile Map<Long, Component> _childIdMap = new LinkedHashMap<Long, Component>(); // guarded by this
    private volatile Map<String, Component> _childNameMap = new LinkedHashMap<String, Component>(); // guarded by this
    private volatile List<Component> _children = new ArrayList<Component>(); // guarded by this

    public GroupBase() {}
    
    public GroupBase(String name, String description) {
        super(name, description);
    }
    
    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildren()
     */
    @Override
    public List<? extends Component> getChildren() {
        if (_children == null) { return null; }
        return Collections.unmodifiableList(_children);
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildren(java.lang.Class)
     */
    @Override
    public <T extends Component> List<T> getChildren(Class<T> type) {
        if (type == null) { return null; }
        List<T> children = new ArrayList<T>();
        for (Component child : _children) {
            if (type.isInstance(child)) {
                children.add(type.cast(child));
            }
        }
        return Collections.unmodifiableList(children);
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildMap()
     */
    @Override
    public Map<Long, ? extends Component> getChildMap() {
        if (_childIdMap == null) { return null; }
        return Collections.unmodifiableMap(_childIdMap);
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildMap(java.lang.Class)
     */
    @Override
    public <T extends Component> Map<Long, T> getChildMap(Class<T> type) {
        if (type == null || _childIdMap == null) { return null; }
        
        Map<Long, T> map = new LinkedHashMap<Long, T>();
        for (Entry<Long, ? extends Component> entry : _childIdMap.entrySet()) {
            if (type.isInstance(entry.getValue())) {
                map.put(entry.getKey(), type.cast(entry.getValue()));
            }
        }
        return Collections.unmodifiableMap(map);
    }


    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildById(java.lang.String)
     */
    @Override
    public Component getChildById(Long id) {
        if (id == null || _childIdMap == null) { return null; }
        return _childIdMap.get(id);
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildById(java.lang.Class, java.lang.String)
     */
    @Override
    public <T extends Component> T getChildById(Class<T> type, Long id) {
        Component child = getChildById(id);
        if (child == null) { return null; }
        return type.isInstance(child) ? type.cast(child) : null;
    }


    @Override
    public Component getChildByName(String name) {
        if (name == null || _childNameMap == null) { return null; }
        return _childNameMap == null ? null : _childNameMap.get(name);
    }

    @Override
    public <T extends Component> T getChildByName(Class<T> type, String name) {
        Component child = getChildByName(name);
        if (child == null) { return null; }
        return type.isInstance(child) ? type.cast(child) : null;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getChildrenRecursive(java.lang.Class)
     */
    @Override
    public <T extends Component> List<T> getDescendants(Class<T> type) {
        if (type == null) { return null; }
        List<T> descendants = new ArrayList<T>();
        List<? extends Component> children = getChildren();
        if (children != null) {
            for (Component child : children) {
                // We want neither duplicates nor loops.
                if (!descendants.contains(child)) {
                    if (type.isInstance(child)) {
                        descendants.add(type.cast(child));
                    }
                    if (child instanceof Group) {
                        Group childGroup = (Group) child;
                        descendants.addAll(childGroup.getDescendants(type));
                    }
                }
            }
        }
        return descendants;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#getDescendantById(java.lang.Class, java.lang.String)
     */
    @Override
    public <T extends Component> T getDescendantById(Class<T> type, Long id) {
        if (id == null) { return null; }
        List<T> descendantsOfType = getDescendants(type);
        if (descendantsOfType == null) { return null; }
        for (T child: descendantsOfType) {
            if (child.getId() == id) {
                return child;
            }
        }
        return null;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#findChildrenRecursiveByName(java.lang.Class, java.lang.String)
     */
    @Override
    public <T extends Component> List<T> getDescendantsByName(Class<T> type, String name) {
        if (name == null) { return null; }
        List<T> descendantsOfType = getDescendants(type);
        if (descendantsOfType == null) { return null; }
        List<T> descendantsOfName = new ArrayList<T>();
        for (T child: descendantsOfType) {
            if (child.getName().equals(name)) {
                descendantsOfName.add(child);
            }
        }
        return descendantsOfName;
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#setChildren(java.util.List)
     */
    @Override
    public void setChildren(List<? extends Component> children) {
        synchronized(this) {
            removeAll();
            addChildren(children);
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#addChild(io.algorithms.common.resource.ConnectorComponent)
     */
    @Override
    public void addChild(Component child) {
        if (child != null) {
            addChildren(Collections.singletonList(child));
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#addAllChildren(java.util.List)
     */
    @Override
    public void addChildren(List<? extends Component> children) {
        if (children != null && children.size() > 0) {
            synchronized(this) {
                _children.addAll(children);
                for (Component child : children) {
                    _childIdMap.put(child.getId(), child);
                    _childNameMap.put(child.getName(), child);
                    child.setParent(this);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#removeChild(io.algorithms.common.resource.ConnectorComponent)
     */
    @Override
    public void removeChild(Component child) {
        if (child != null) {
            removeChildren(Collections.singletonList(child));
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#removeChild(io.algorithms.common.resource.ConnectorComponent)
     */
    @Override
    public void removeChildren(List<? extends Component> children) {
        if (children != null && children.size() > 0) {
            synchronized (this) {
                _children.removeAll(children);
                for (Component child : children) {
                    _childIdMap.remove(child.getId());
                    _childNameMap.remove(child.getName());
                    child.setParent(null);
                }
            }
        }
    }

    /* (non-Javadoc)
     * @see io.algorithms.common.resource.Group#removeChild(io.algorithms.common.resource.ConnectorComponent)
     */
    @Override
    public void removeAll() {
        removeChildren(_children);
    }

    @Override
    public void setParent(Group parent) {
        super.setParent(parent);
        // Since the group's fully qualified id and URI might have changed
        // we need to update it for all of the children.
        if (_children != null) {
            for (Component child : _children) {
                child.setParent(this);
            }
        }
    }
}
