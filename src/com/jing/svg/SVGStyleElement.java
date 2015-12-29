package com.jing.svg;


import com.jing.svg.dom.CSSStyleSheet;
import com.jing.svg.element.SVGBaseElement;
import com.jing.svg.element.SVGElement;
import com.jing.svg.element.SVGLangSpace;
import com.jing.svg.element.SVGLangSpaceImpl;

import static com.jing.svg.dataType.Constants.ElementAttributeNames.*;
import static com.jing.svg.dataType.Constants.TagName.STYLE;


public class SVGStyleElement extends SVGBaseElement implements SVGLangSpace {
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);
    private CSSStyleSheet cssStyleSheet;
    public SVGStyleElement() {
        super(STYLE);
    }

    public SVGStyleElement(SVGSVGElement ownerSVGElement) {
        super(STYLE, ownerSVGElement);
    }

    public SVGStyleElement(String value, SVGSVGElement ownerSVGElement) {
        super(STYLE, value, ownerSVGElement);
    }

    public SVGStyleElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(STYLE, value, ownerSVGElement, viewPortElement);
    }

    public String getTitle() {
        return (String) this.getAttributeValue(TITLE.toString());
    }

    public String getType() {
        return (String) this.getAttributeValue(TYPE.toString());
    }

    public String getMedia() {
        return (String) this.getAttributeValue(MEDIA.toString());
    }

    @Override
    public String getXmlspace() {
        return svgLangSpace.getXmlspace();
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }

    protected void consolidateStyle() {
        if(cssStyleSheet == null){
            cssStyleSheet = new CSSStyleSheet(this.getContent());
        }
        cssStyleSheet.apply(this.getOwnerSVGElement());
    }
}
