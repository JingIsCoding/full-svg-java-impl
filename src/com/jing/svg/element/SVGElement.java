package com.jing.svg.element;


import com.jing.svg.SVGSVGElement;
import com.jing.svg.dom.Element;

public interface SVGElement extends Element<SVGElement> {
    public void setId(String id);

    public String getId();

    public void setXmlBase(String xmlBase);

    public String getXmlBase();

    public void setOwnerSVGElement(SVGSVGElement element);

    public SVGSVGElement getOwnerSVGElement();

    public SVGElement getViewportElement();

    public void appendChild(SVGElement element);

}
