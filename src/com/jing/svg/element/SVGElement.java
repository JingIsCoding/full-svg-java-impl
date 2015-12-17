package com.jing.svg.element;


import com.jing.svg.SVGSVGElement;
import com.jing.svg.dom.Element;

public interface SVGElement extends Element<SVGElement> {
    void setId(String id);

    String getId();

    void setXmlBase(String xmlBase);

    String getXmlBase();

    void setOwnerSVGElement(SVGSVGElement element);

    SVGSVGElement getOwnerSVGElement();

    SVGElement getViewportElement();

    void appendChild(SVGElement element);

}
