package com.jing.svg.element;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.XML_LANG;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.XML_SPACE;

public class SVGLangSpaceImpl implements SVGLangSpace {
    private SVGElement svgElement;


    public SVGLangSpaceImpl(SVGElement svgElement){
        this.svgElement = svgElement;
    }


    public String getXmlspace() {
        return svgElement.hasOwnAttribute(XML_SPACE.toString()) ? (String)svgElement.getAttribute(XML_SPACE.toString()).getValue() : null;
    }

    public String getXmllang() {
        return svgElement.hasOwnAttribute(XML_SPACE.toString()) ? (String)svgElement.getAttribute(XML_LANG.toString()).getValue() : null;
    }
}
