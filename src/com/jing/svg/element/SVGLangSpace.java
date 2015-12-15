package com.jing.svg.element;

public class SVGLangSpace {

    public SVGLangSpace(){

    }

    public SVGLangSpace(String xmllang, String xmlspace) {
        this.xmllang = xmllang;
        this.xmlspace = xmlspace;
    }

    private String xmllang;
    private String xmlspace;

    public String getXmlspace() {
        return xmlspace;
    }

    public void setXmlspace(String xmlspace) {
        this.xmlspace = xmlspace;
    }

    public String getXmllang() {
        return xmllang;
    }

    public void setXmllang(String xmllang) {
        this.xmllang = xmllang;
    }
}
