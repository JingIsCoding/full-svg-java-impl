package com.jing.svg.dom;

import com.jing.svg.dataType.Constants.TagName;

import java.util.Map;

public interface Node<T> {

    TagName getTagName();

    String getContent();

    void setContent(String content);

    void setParent(T t);

    T getParent();

    NodeList<T> getChildrenNodes();

    boolean hasChild();

    T getFirstChild();

    T getLastChild();

    T getPreviousSibling();

    T getNextSibling();

    Map<String, Attribute> getAttributes();

    Attribute getAttribute(String name);

    boolean hasAttributes();

    boolean hasOwnAttribute(String name);

    T cloneNode(boolean deep);
}
