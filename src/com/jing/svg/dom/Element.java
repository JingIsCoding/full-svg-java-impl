package com.jing.svg.dom;

import com.jing.svg.dataType.Constants;

import java.util.List;

import static com.jing.svg.dataType.Constants.*;

public interface Element<T> extends Node<T>{

    void setAttribute(String name,String value);

    Attribute getAttribute(String name);

    void removeAttribute(String name);

    List<T> getElementByTagName(TagName name);
}
