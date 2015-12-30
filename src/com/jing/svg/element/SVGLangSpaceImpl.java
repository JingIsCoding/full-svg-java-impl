package com.jing.svg.element;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.XML_LANG;
import static com.jing.svg.dataType.Constants.ElementAttributeNames.XML_SPACE;

public class SVGLangSpaceImpl implements SVGLangSpace {
    private SVGElement svgElement;


    public SVGLangSpaceImpl(SVGElement svgElement){
        this(svgElement,null,null);
    }

    private SVGLangSpaceImpl(SVGElement svgElement, String xmllang, String xmlspace) {
        this.svgElement = svgElement;
        svgElement.setAttribute(XML_LANG.toString(),xmllang);
        svgElement.setAttribute(XML_SPACE.toString(),xmlspace);
    }

    public String getXmlspace() {
        return (String)svgElement.getAttribute(XML_SPACE.toString()).getValue();
    }

    public String getXmllang() {
        return (String)svgElement.getAttribute(XML_LANG.toString()).getValue();
    }
}
