package com.jing.svg.dataType.dom;

import java.util.Map;

public interface Node<T> {

    public String getTagName();

    public String getValue();

    public T getParent();

    public NodeList<T> getChildrenNodes();

    public T getFirstChild();

    public T getLastChild();

    public T getPreviousSibling();

    public T getNextSibling();

    public Map<String, Attribute> getAttributes();

    public String getAttribute(String name);

    public boolean hasAttributes();

    public boolean hasOwnAttribute(String name);

    public T cloneNode(boolean deep);
}
