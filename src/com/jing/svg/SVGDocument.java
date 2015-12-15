package com.jing.svg;


public class SVGDocument {
    private String title;
    private String referrer;
    private String domain;
    private String URL;
    private SVGSVGElement rootSvgElement;

    public SVGDocument(SVGSVGElement rootSvgElement){
        this.rootSvgElement = rootSvgElement;
    }

    public SVGSVGElement getRootSvgElement() {
        return rootSvgElement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
