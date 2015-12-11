package com.jing.svg.dataType.dom;

import java.util.List;

public interface Element<T> extends Node<T>{

    void setAttribute(String name,String value);

    String getAttribute(String name);

    void removeAttribute(String name);

    List<Element> getElementByTagName(String name);
}
