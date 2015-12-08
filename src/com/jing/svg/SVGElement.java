package com.jing.svg;

/**
 * Created by jguo on 12/8/2015.
 */
public interface SVGElement extends BaseElement{
    void setId(String id);

    String getId();

    SVGSVGElement getOwnerSVGElement();

    SVGElement getViewportElement();
}
