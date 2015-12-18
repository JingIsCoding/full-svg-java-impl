package com.jing.svg;

import com.jing.svg.dataType.Constants;
import com.jing.svg.dom.Attribute;
import com.jing.svg.dom.NodeList;
import com.jing.svg.element.*;
import com.jing.svg.element.SVGBaseElement;

import java.util.List;
import java.util.Map;

import static com.jing.svg.dataType.Constants.TagName.DESC;

public class SVGDescElement extends SVGBaseElement implements SVGLangSpace {
    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    public SVGDescElement() {
        super(DESC);
    }

    public SVGDescElement(SVGSVGElement ownerSVGElement) {
        super(DESC, ownerSVGElement);
    }

    public SVGDescElement(String value, SVGSVGElement ownerSVGElement) {
        super(DESC, value, ownerSVGElement);
    }

    public SVGDescElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(DESC, value, ownerSVGElement, viewPortElement);
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
