package com.jing.svg.element;

public class SVGLangSpaceImpl implements SVGLangSpace {
    private SVGElement svgElement;

    private static final String XMLLang = "xml:lang";
    private static final String XMLSpace = "xml:space";

    public SVGLangSpaceImpl(SVGElement svgElement){
        this(svgElement,null,null);
    }

    private SVGLangSpaceImpl(SVGElement svgElement, String xmllang, String xmlspace) {
        this.svgElement = svgElement;
        svgElement.setAttribute(XMLLang,xmllang);
        svgElement.setAttribute(XMLSpace,xmlspace);
    }

    public String getXmlspace() {
        return (String)svgElement.getAttribute(XMLSpace).getValue();
    }

    public String getXmllang() {
        return (String)svgElement.getAttribute(XMLLang).getValue();
    }
}
