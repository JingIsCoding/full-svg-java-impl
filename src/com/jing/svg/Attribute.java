package com.jing.svg;

/**
 * Created by jguo on 12/8/2015.
 */
public class Attribute {

    public Attribute(){
        this(null,null);
    }

    public Attribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

    public String getValue() {
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
}
