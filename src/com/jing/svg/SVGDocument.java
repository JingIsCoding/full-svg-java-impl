package com.jing.svg;


import com.jing.svg.dataType.Constants;
import com.jing.svg.element.SVGElement;

import java.util.HashMap;
import java.util.Map;

public class SVGDocument {
    private String title;
    private String referrer;
    private String domain;
    private String URL;
    private SVGSVGElement rootSvgElement;

    public SVGDocument(){
    }

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

    private static Map<String,Class> classMap = new HashMap<>();
    static {
        classMap.put(Constants.TagName.SVG.toString(), SVGSVGElement.class);
        classMap.put(Constants.TagName.G.toString(), SVGGElement.class);
        classMap.put(Constants.TagName.DEFS.toString(), SVGDefsElement.class);
        classMap.put(Constants.TagName.DESC.toString(), SVGDescElement.class);
        classMap.put(Constants.TagName.STYLE.toString(), SVGStyleElement.class);
        classMap.put(Constants.TagName.SWITCH.toString(), SVGSwitchElement.class);
        classMap.put(Constants.TagName.TITLE.toString(), SVGTitleElement.class);
        classMap.put(Constants.TagName.USE.toString(), SVGUseElement.class);
    }

    public SVGElement createElement(String tagName) throws IllegalAccessException, InstantiationException {
        String name = tagName.trim().toLowerCase();
        if(classMap.get(name)!= null){
            return (SVGElement) classMap.get(name).newInstance();
        }
        else{
            throw new IllegalArgumentException();
        }
    }
}
