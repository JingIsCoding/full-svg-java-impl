package com.jing.svg;

import java.util.List;

/**
 * Created by jguo on 12/8/2015.
 */
public class SVGSVGElement implements SVGElement {
    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public SVGSVGElement getOwnerSVGElement() {
        return null;
    }

    @Override
    public SVGElement getViewportElement() {
        return null;
    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public void setAttribute(String name, String value) {

    }

    @Override
    public String getAttribute(String name) {
        return null;
    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public List<BaseElement> getElementByTagName(String name) {
        return null;
    }
}
