package com.jing.svg.dom;

import java.util.Objects;

/**
 * Created by jguo on 12/8/2015.
 */
public class Attribute {

    public Attribute(Element ownerElement){
        this(ownerElement,null,null);
    }

    public Attribute(Element ownerElement, String name, Object value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private Object value;
    private Element ownerElement;

    public Object getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Element getOwnerElement() {
        return ownerElement;
    }

    public void setOwnerElement(Element ownerElement) {
        this.ownerElement = ownerElement;
    }
}
