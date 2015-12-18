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

import static com.jing.svg.dataType.Constants.TagName.TITLE;

public class SVGTitleElement extends SVGBaseElement implements SVGLangSpace {

    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    public SVGTitleElement() {
        super(TITLE);
    }

    public SVGTitleElement(SVGSVGElement ownerSVGElement) {
        super(TITLE, ownerSVGElement);
    }

    public SVGTitleElement(String value, SVGSVGElement ownerSVGElement) {
        super(TITLE, value, ownerSVGElement);
    }

    public SVGTitleElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(TITLE, value, ownerSVGElement, viewPortElement);
    }

    @Override
    public String getXmlspace() {
        return svgLangSpace.getXmlspace();
    }

    @Override
    public String getXmllang() {
        return svgLangSpace.getXmllang();
    }
}
