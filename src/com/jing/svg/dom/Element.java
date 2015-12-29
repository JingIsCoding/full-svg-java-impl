package com.jing.svg.dom;

import java.util.List;

import static com.jing.svg.dataType.Constants.TagName;

public interface Element<T> extends Node<T>{

    void setAttribute(String name,Object value);

    Attribute getAttribute(String name);

    Object getAttributeValue(String name);

    void removeAttribute(String name);

    List<T> getElementByTagName(TagName name);

    T getElementById(String id);
}
