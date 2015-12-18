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

import static com.jing.svg.dataType.Constants.TagName.SYMBOL;

public class SVGSymbolElement extends SVGBaseElement implements SVGLangSpace {

    private SVGLangSpace svgLangSpace = new SVGLangSpaceImpl(this);

    public SVGSymbolElement() {
        super(SYMBOL);
    }

    public SVGSymbolElement(SVGSVGElement ownerSVGElement) {
        super(SYMBOL, ownerSVGElement);
    }

    public SVGSymbolElement(String value, SVGSVGElement ownerSVGElement) {
        super(SYMBOL, value, ownerSVGElement);
    }

    public SVGSymbolElement(String value, SVGSVGElement ownerSVGElement, SVGElement viewPortElement) {
        super(SYMBOL, value, ownerSVGElement, viewPortElement);
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
