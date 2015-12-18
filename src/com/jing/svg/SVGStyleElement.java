package com.jing.svg;


import com.jing.svg.dataType.Constants;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.SVGElement;
import com.jing.svg.element.SVGBaseElement;
import com.jing.svg.element.SVGLangSpace;
import com.jing.svg.element.SVGLangSpaceImpl;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName.STYLE;


public class SVGStyleElement extends SVGBaseElement implements SVGLangSpace {
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
        return (String) this.getAttribute("title").getValue();
    }

    public void setTitle(String title) {
        this.setAttribute("title", title);
    }

    public String getType() {
        return (String) this.getAttribute("type").getValue();
    }

    public void setType(String type) {
        this.setAttribute("type", type);
    }

    public String getMedia() {
        return (String) this.getAttribute("media").getValue();
    }

    public void setMedia(String media) {
        this.setAttribute("media", media);
    }


    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    @Override
    public String getXmlspace() {
        return svgLangSpace.getXmlspace();
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }
}
