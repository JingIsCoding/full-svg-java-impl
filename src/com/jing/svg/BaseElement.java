package com.jing.svg;

import java.util.List;

public interface BaseElement {

    public String getTagName();

    void setAttribute(String name,String value);

    String getAttribute(String name);

    void removeAttribute(String name);

    List<BaseElement> getElementByTagName(String name);
}
