package com.jing.svg.dom;

public class Attribute<T> {

    public Attribute(Element ownerElement){
        this(ownerElement,null,null);
    }

    public Attribute(Element ownerElement, String name, T value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private T value;
    private Element ownerElement;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
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
