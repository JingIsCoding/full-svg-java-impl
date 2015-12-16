package com.jing.svg.dom;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dataType.Constants.TagName;

import java.util.Map;

public interface Node<T> {

    public TagName getTagName();

    public String getValue();

    public void setParent(T t);

    public T getParent();

    public NodeList<T> getChildrenNodes();

    public boolean hasChild();

    public T getFirstChild();

    public T getLastChild();

    public T getPreviousSibling();

    public T getNextSibling();

    public Map<String, Attribute> getAttributes();

    public Attribute getAttribute(String name);

    public boolean hasAttributes();

    public boolean hasOwnAttribute(String name);

    public T cloneNode(boolean deep);
}
