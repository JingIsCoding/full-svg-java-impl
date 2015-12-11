package com.jing.svg.dataType;

import com.jing.svg.SVGSVGElement;
import com.jing.svg.dataType.dom.Element;

/**
 * Created by jguo on 12/8/2015.
 */
public interface SVGElement extends Element<SVGElement> {
    void setId(String id);

    String getId();

    void setXmlBase(String xmlBase);

    String getXmlBase();

    SVGSVGElement getOwnerSVGElement();

    SVGElement getViewportElement();
}
